package billingsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import systemstyle.Format;

// TODO: Auto-generated Javadoc
/**
 * * @author Jason Li.
 *
 * @version 1.0
 * @since 19.12.2016 *
 * 
 * 
 *        The Class MainController.
 */
public class MainController {

	/** The login. */
	@FXML
	private Button login;

	/** The user. */
	@FXML
	private TextField user;

	/** The pwd fld. */
	@FXML
	private PasswordField pwdFld;

	/** The users list. */
	private ArrayList<User> usersList;

	/** The current user. */
	private User currentUser;

	/** The Constant userLogger. */
	private static final Logger userLogger = Logger.getLogger(MainController.class.getName() + "_User");

	/** The fh user. */
	private static FileHandler fhUser;

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(MainController.class.getName());

	/** The fh log. */
	private static FileHandler fhLog;

	/** The file. */
	private File file;

	/** The menubook. */
	private ArrayList<Order> menubook = new ArrayList<Order>();

	/** The order log. */
	private ArrayList<Order> orderLog = new ArrayList<Order>();

	/** The full format. */
	private static DateFormat fullFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());

	/** The date format. */
	private static DateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");

	/** The time format. */
	private static DateFormat timeFormat = new SimpleDateFormat("HH:mm");

	/** The date time format. */
	private static DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("HH:mm");

	/** The user path. */
	private String userPath = "res/users.ser";

	/** The user log path. */
	private String userLogPath = "res/";

	/** The log path. */
	private String logPath = "res/activity.log";

	/** The order log path. */
	private String orderLogPath = "res/orderlog.ser";

	/** The csv path. */
	private String csvPath = "res/export.csv";

	/** The menu path. */
	private String menuPath = "res/menubook.ser";

	/**
	 * Handle login.
	 *
	 * @param evt
	 *            the login event
	 * 
	 */
	@FXML
	private void handleLogin(ActionEvent evt) {

		// Set up general logger
		try {
			fhLog = new FileHandler(logPath, true);
			logger.addHandler(fhLog);
			SimpleFormatter formatter = new SimpleFormatter();
			fhLog.setFormatter(formatter);
		} catch (SecurityException e) {
			logger.log(Level.SEVERE, "" + e);
		} catch (IOException e) {
			logger.log(Level.WARNING,
					"Logger could not be set up to log to activity log. Logs will only be displayed in the console. \n"
							+ e);
		}

		// Load available users for system
		try {
			FileInputStream fileIn = new FileInputStream(userPath);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			usersList = (ArrayList<User>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			logger.log(Level.SEVERE, "No user list have been found. Try reloading program. ");
		} catch (ClassNotFoundException c) {
			logger.log(Level.SEVERE, "" + c);
		}

		// Login validation section
		// Loop through stored users to see if entered user matches any
		boolean matchFound = false;
		for (int i = 0; i < usersList.size(); i++) {
			String enteredUser = user.getText();
			String storedUser = usersList.get(i).getUserName();
			if (enteredUser.equals(storedUser)) {
				String enteredPwd = pwdFld.getText();
				if (enteredPwd.equals(usersList.get(i).getUserPassword())) {
					matchFound = true;
					currentUser = usersList.get(i);
					userLogPath += (currentUser.getUserName() + "_activity.log");
					// Set up user logger
					try {
						fhUser = new FileHandler(userLogPath, true);
						fhUser.setLevel(Level.FINE);
						userLogger.setLevel(Level.FINE);
						userLogger.addHandler(fhUser);
						SimpleFormatter formatter = new SimpleFormatter();
						fhUser.setFormatter(formatter);
					} catch (SecurityException e) {
						logger.log(Level.SEVERE, "" + e);
					} catch (IOException e) {
						logger.log(Level.WARNING,
								"User activity logger failed to set up. An unlogged user session has been started by "
										+ currentUser.getUserName());
						logger.log(Level.WARNING,
								"Logger could not be set up to log to activity log. Logs will only be displayed in the console. \n"
										+ e);
					}
					userLogger.log(Level.FINE, currentUser.getUserName() + " has logged into the system. ");
				}
				break;
			}
		}
		// Login & password correct
		if (matchFound) {
			constructMainScreen();
		}
		// Else error message
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Login failed");
			alert.setHeaderText("Login failed");
			alert.setContentText("Login or password incorrect");

			alert.showAndWait();
		}
	}

	// Main Screen construction section

	/** The v menu. */
	// Variables for Main Screen Menu
	private VBox vMenu;

	/** The account. */
	private Button account;

	/** The v manager. */
	// Variables for Manager Menu
	private VBox vManager;

	/** The manage users. */
	private Button manageUsers;

	/** The add menubook. */
	private Button addMenubook;

	/** The tbl pane. */
	// Variables for Main Screen Scroll Pane
	private Pane tblPane;

	/** The tbl scrl pane. */
	private ScrollPane tblScrlPane;

	/** The lbl. */
	private Table lbl;

	/** The pane height. */
	int paneWidth = 1000, paneHeight = 600;

	/** The btn height. */
	int btnWidth = 125, btnHeight = 35;

	/** The tbl height. */
	int tblWidth = 100, tblHeight = 100;

	/** The v menu width. */
	int vMenuWidth = 200;

	/** The v manager height. */
	int vManagerHeight = 200;

	/** The file chooser. */
	private static FileChooser fileChooser = new FileChooser();

	/**
	 * Construct main screen.
	 */
	private void constructMainScreen() {

		Stage stage = null;
		Pane root;
		stage = (Stage) login.getScene().getWindow();
		root = new Pane();
		root.setPadding(new Insets(25));

		// General Menu section
		vMenu = new VBox(15);
		vMenu.setPadding(new Insets(25));
		// vMenu.setStyle("-fx-background-color: #a0522d;");
		vMenu.setAlignment(Pos.TOP_CENTER);
		vMenu.setPrefSize(vMenuWidth, paneHeight);

		account = new Button("Account settings");
		account.setPrefSize(btnWidth, btnHeight);
		account.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent at) {
				Dialog dialog = new Dialog();
				dialog.setTitle("Account Setting");
				dialog.setHeaderText("Enter new password and click save");

				GridPane grid = new GridPane();
				grid.setHgap(10);
				grid.setVgap(10);

				PasswordField password = new PasswordField();
				password.setPromptText("Password");
				PasswordField passwordConfirm = new PasswordField();
				passwordConfirm.setPromptText("Password");

				Button save = new Button("Change password");
				save.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent change) {
						String passwordSet = password.getText();
						String passwordSetConfirm = passwordConfirm.getText();
						// Check if both fields are filled
						if (!(passwordSet.equals("") || (passwordSetConfirm.equals("")))) {
							// Check if passwords matched
							if (passwordSet.equals(passwordSetConfirm)) {
								currentUser.setPassword(passwordSetConfirm);
								userLogger.log(Level.FINE, "Successfully changed password.");

								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Password changed");
								alert.setHeaderText("Password changed");
								alert.setContentText("You have successfully changed your password");
								alert.showAndWait();

								try {
									FileOutputStream fileOut = new FileOutputStream(userPath);
									ObjectOutputStream out = new ObjectOutputStream(fileOut);
									out.writeObject(usersList);
									out.close();
									fileOut.close();
								} catch (IOException i) {
									logger.log(Level.SEVERE, "" + i);
								}

							} else {

							}
						} else {
							invalidInputAlert();
						}
					}
				});

				grid.add(new Label("Logged in as: "), 0, 0);
				grid.add(new Label(currentUser.getUserName()), 1, 0);
				grid.add(new Label("New Password:"), 0, 1);
				grid.add(password, 1, 1);
				grid.add(new Label("Confirm new password:"), 0, 2);
				grid.add(passwordConfirm, 1, 2);
				grid.add(save, 1, 3);

				ButtonType exit = new ButtonType("Exit", ButtonData.OK_DONE);
				dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);

				dialog.getDialogPane().setContent(grid);
				dialog.showAndWait();
			}
		});

		Button allOrders = new Button("View Order Log");
		allOrders.setPrefSize(btnWidth, btnHeight);
		allOrders.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			@SuppressWarnings("deprecation")
			public void handle(ActionEvent ravt) {
				Dialog dialog = new Dialog();
				dialog.setTitle("Order Log Manager");
				dialog.setHeaderText("Order Log:");

				GridPane grid = new GridPane();
				grid.setHgap(10);
				grid.setVgap(10);

				grid.add(new Label("Search orders"), 0, 0);
				String[] searchColumns = { "Table No.", "Order Name", "From", "Until", "From", "Until", "Comments" };
				// Populating columns
				for (int i = 0; i < searchColumns.length; i++) {
					Label searchLbl = new Label(searchColumns[i]);
					grid.add(searchLbl, i, 1);
				}

				// Inner display of all orders
				GridPane searchInner = new GridPane();
				Format.innergrid(searchInner);
				searchInner.setPrefWidth(400);
				searchInner.setMinHeight(200);
				String[] searchInnerCol = { "Table No.", "Order Name", "Price", "Quantity", "Total", "Order Datetime",
						"Comments" };
				double multiplier = 1;
				boolean localRights = currentUser.getUserRights();
				// Create list for selection
				ArrayList<Order> selectedList = new ArrayList<Order>();
				// Adjust column width depending on user type
				if (localRights) {
					multiplier = 0.95;
				}
				ColumnConstraints scol1 = new ColumnConstraints();
				scol1.setPercentWidth(45 / (searchInnerCol.length - 4) * multiplier);
				searchInner.getColumnConstraints().add(scol1);
				ColumnConstraints scol2 = new ColumnConstraints();
				scol2.setPercentWidth(25 * multiplier);
				searchInner.getColumnConstraints().add(scol2);
				ColumnConstraints scol3 = new ColumnConstraints();
				scol3.setPercentWidth(10 * multiplier);
				searchInner.getColumnConstraints().add(scol3);
				ColumnConstraints scol4 = new ColumnConstraints();
				scol4.setPercentWidth(10 * multiplier);
				searchInner.getColumnConstraints().add(scol4);
				ColumnConstraints scol5 = new ColumnConstraints();
				scol5.setPercentWidth(10 * multiplier);
				searchInner.getColumnConstraints().add(scol5);
				ColumnConstraints scol6 = new ColumnConstraints();
				scol6.setPercentWidth(45 / (searchInnerCol.length - 4) * multiplier);
				searchInner.getColumnConstraints().add(scol6);
				ColumnConstraints scol7 = new ColumnConstraints();
				scol7.setPercentWidth(45 / (searchInnerCol.length - 4) * multiplier);
				searchInner.getColumnConstraints().add(scol7);
				if (localRights) {
					ColumnConstraints scol8 = new ColumnConstraints();
					scol8.setPercentWidth(5);
					searchInner.getColumnConstraints().add(scol8);
				}

				// Generate search display
				ArrayList<Order> localLog = new ArrayList<Order>(orderLog);
				for (int i = 0; i < currentTables.size(); i++) {
					ArrayList<Order> innerLocal = new ArrayList<Order>(currentTables.get(i).getOrders());
					for (int n = 0; n < innerLocal.size(); n++) {
						localLog.add(innerLocal.get(n));
					}
				}
				ArrayList<Order> displayList = new ArrayList<Order>(localLog);
				Collections.reverse(displayList);
				refreshSearch(searchInner, displayList, searchInnerCol, selectedList);
				ScrollPane searchScroll = new ScrollPane();
				searchScroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);
				searchScroll.setFitToWidth(true);
				searchScroll.setPrefHeight(200);
				searchScroll.setContent(searchInner);
				grid.add(searchScroll, 0, 4, searchColumns.length, 1);

				// Populate search fields
				ArrayList<String> tblNames = new ArrayList<String>();
				tblNames.add("Any");
				for (int i = 1; i <= 15; i++) {
					tblNames.add("Table" + i);
				}
				ObservableList<String> oTableList = FXCollections.observableArrayList(tblNames);
				ComboBox searchTable = new ComboBox(oTableList);
				searchTable.getSelectionModel().selectFirst();
				grid.add(searchTable, 0, 2);

				TextField searchName = new TextField();
				grid.add(searchName, 1, 2);

				DatePicker fromDate = new DatePicker();
				fromDate.setPrefWidth(btnWidth);
				fromDate.setValue(LocalDate.now().minusDays(1));
				grid.add(fromDate, 2, 2);

				DatePicker untilDate = new DatePicker();
				untilDate.setPrefWidth(btnWidth);
				untilDate.setValue(LocalDate.now());
				grid.add(untilDate, 3, 2);

				Date localNow = new Date();
				Date localFrom = (Date) localNow.clone();
				localFrom.setHours(localFrom.getHours() - 1);
				TextField fromTime = new TextField();
				fromTime.setText(timeFormat.format(localFrom));
				grid.add(fromTime, 4, 2);

				TextField untilTime = new TextField();
				untilTime.setText(timeFormat.format(localNow));
				grid.add(untilTime, 5, 2);

				TextField searchComments = new TextField();
				grid.add(searchComments, 6, 2);

				Button launchSearch = new Button("Search");
				launchSearch.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent sat) {
						// Prepare filled out search fields
						String localTbl = (String) searchTable.getValue();
						String localName = searchName.getText();
						LocalDate localFromD;
						if (fromDate.getValue() != null) {
							// from date - 1 to include current day
							localFromD = fromDate.getValue().minusDays(1);
						} else {
							localFromD = fromDate.getValue();
						}
						LocalDate localUntilD;
						if (untilDate.getValue() != null) {
							// until date + 1 to include current day
							localUntilD = untilDate.getValue().plusDays(1);
						} else {
							localUntilD = untilDate.getValue();
						}
						LocalTime localFromT;
						if (!fromTime.getText().equals("")) {
							localFromT = LocalTime.parse(fromTime.getText(), dateTimeFormat).minusSeconds(1);
						} else {
							localFromT = null;
						}
						LocalTime localUntilT;
						if (!untilTime.getText().equals("")) {
							localUntilT = LocalTime.parse(untilTime.getText(), dateTimeFormat).plusMinutes(1);
						} else {
							localUntilT = null;
						}
						String localComments = searchComments.getText();
						if (!(localTbl.isEmpty() && localName.isEmpty() && localComments.isEmpty())) {
							ArrayList<Order> searchDisplay = new ArrayList<Order>(displayList);
							// Filter for table search value
							if (!localTbl.equals("Any")) {
								searchDisplay = (ArrayList<Order>) searchDisplay.stream()
										.filter(result -> result.getSrcTbl().equals(localTbl))
										.collect(Collectors.toList());
							}
							// Filter for order search value
							if (!localName.isEmpty()) {
								searchDisplay = (ArrayList<Order>) searchDisplay.stream()
										.filter(result -> result.getName().equals(localName))
										.collect(Collectors.toList());
							}
							// Filter for date intervals
							if (!(localFromD == null || localUntilD == null)) {
								searchDisplay = (ArrayList<Order>) searchDisplay
										.stream().filter(result -> result.getDate().toInstant()
												.atZone(ZoneId.systemDefault()).toLocalDate().isAfter(localFromD))
										.collect(Collectors.toList());
								searchDisplay = (ArrayList<Order>) searchDisplay
										.stream().filter(result -> result.getDate().toInstant()
												.atZone(ZoneId.systemDefault()).toLocalDate().isBefore(localUntilD))
										.collect(Collectors.toList());
							}
							// Filter for time intervals
							if (!(localFromT == null || localUntilT == null)) {
								searchDisplay = (ArrayList<Order>) searchDisplay
										.stream().filter(result -> result.getDate().toInstant()
												.atZone(ZoneId.systemDefault()).toLocalTime().isAfter(localFromT))
										.collect(Collectors.toList());
								searchDisplay = (ArrayList<Order>) searchDisplay
										.stream().filter(result -> result.getDate().toInstant()
												.atZone(ZoneId.systemDefault()).toLocalTime().isBefore(localUntilT))
										.collect(Collectors.toList());
							}
							// Filter for comments
							if (!localComments.isEmpty()) {
								searchDisplay = (ArrayList<Order>) searchDisplay.stream()
										.filter(result -> result.getComment().equals(localComments))
										.collect(Collectors.toList());
							}
							refreshSearch(searchInner, searchDisplay, searchInnerCol, selectedList);
						} else {
							invalidInputAlert();
						}
					}
				});
				grid.add(launchSearch, 5, 3);

				// Manager Import Export Section
				grid.add(new Label("Import orders to order list"), 2, 5);
				Button importOrders = new Button("Import Orders");
				importOrders.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent exporter) {
						fileChooser.setTitle("Open Resource File");
						// Set extension filter
						FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text delimited files",
								"*.txt", "*.csv");
						fileChooser.getExtensionFilters().add(extFilter);
						// Using login button simply because showOpenDialog
						// requires a stage input
						file = fileChooser.showOpenDialog(login.getScene().getWindow());
						if (file != null) {
							BufferedReader csvReader = null;
							String line = "";
							String delimiter = ",";
							try {
								csvReader = new BufferedReader(new FileReader(file));
								while ((line = csvReader.readLine()) != null) {
									String[] orderProperties = line.split(delimiter);
									String impName = orderProperties[0];
									Double impPrice = Double.parseDouble(orderProperties[1]);
									int impQnty = Integer.parseInt(orderProperties[2]);
									String impTbl = orderProperties[3];
									Double impTotal = Double.parseDouble(orderProperties[4]);
									String impComment = orderProperties[5];
									Date impDate = dateFormat.parse(orderProperties[6]);
									Order impOrder = new Order(impName, impPrice, impQnty, impTbl, impComment, impDate);

									orderLog.add(impOrder);
									displayList.add(0, impOrder);
								}
								refreshSearch(searchInner, displayList, searchInnerCol, selectedList);
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Import Success");
								alert.setHeaderText("Import Success");
								alert.setContentText("Orders successfully imported!");
								alert.showAndWait();
								userLogger.log(Level.FINE, currentUser.getUserName()
										+ " imported order from an external list to order log.");
							} catch (IOException e) {
								invalidInputAlert();
							} catch (ParseException p) {
								invalidInputAlert();
							} catch (Exception ex) {
								Alert alert = new Alert(AlertType.ERROR);
								alert.setTitle("Import Error");
								alert.setHeaderText("Import Error");
								alert.setContentText(
										"Import failed. Check if file content has the appropriate format. If yes and the error remains, consult the error log.");
								alert.showAndWait();
								logger.log(Level.WARNING, "Import failed due to " + ex);
							} finally {

								if (csvReader != null) {
									try {
										csvReader.close();
									} catch (IOException ex) {
										logger.log(Level.SEVERE, "" + ex);
									}
								}
							}
						}
					}
				});

				grid.add(importOrders, 2, 6);
				grid.add(new Label("Export selected orders as CSV"), 5, 5);
				Button exportOrders = new Button("Export Orders");
				exportOrders.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent exporter) {
						if (selectedList.size() > 0) {
							// Call toCsvRow for every object in list and
							// collect in String
							String ordersAsCsv = selectedList.stream().map(Order::toCsvRow)
									.collect(Collectors.joining(System.getProperty("line.separator")));
							FileWriter csvFw = null;
							BufferedWriter csvWriter = null;
							try {
								csvFw = new FileWriter(csvPath);
								csvWriter = new BufferedWriter(csvFw);
								csvWriter.write(ordersAsCsv);

								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Export success");
								alert.setHeaderText("Export success");
								alert.setContentText("Selected orders successfully exported!");

								alert.showAndWait();

							} catch (IOException ex) {
								logger.log(Level.SEVERE, "" + ex);
							} finally {
								try {
									if (csvWriter != null)
										csvWriter.close();
									if (csvFw != null)
										csvFw.close();
								} catch (IOException e) {
									logger.log(Level.SEVERE, "" + e);
								}
							}
						} else {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Invalid Selection");
							alert.setHeaderText("Invalid Selection");
							alert.setContentText("No selected orders registered. Please select orders to be exported.");
							alert.showAndWait();
						}
					}
				});
				grid.add(exportOrders, 5, 6);

				ButtonType saveButton = new ButtonType("Done", ButtonData.OK_DONE);
				dialog.getDialogPane().getButtonTypes().addAll(saveButton);
				dialog.getDialogPane().setContent(grid);
				Optional<ButtonType> result = dialog.showAndWait();
				if (result.isPresent() && result.get() == saveButton) {
					try {
						// Creates new order log
						FileOutputStream fileOut = new FileOutputStream(orderLogPath);
						ObjectOutputStream out = new ObjectOutputStream(fileOut);
						out.writeObject(orderLog);
						out.close();
						fileOut.close();
					} catch (IOException logX2) {
						logger.log(Level.WARNING, "" + logX2);
					}
				}
			}
		});

		vMenu.getChildren().addAll(allOrders, account);

		// Manager menu section, only available if user is admin type
		if (currentUser.getUserRights()) {
			vMenu.setPrefSize(vMenuWidth, paneHeight - vManagerHeight);
			vManager = new VBox(15);
			vManager.setPadding(new Insets(25));
			// vManager.setStyle("-fx-background-color: #a0522d;");
			vManager.setAlignment(Pos.TOP_CENTER);
			vManager.setPrefSize(vMenuWidth, vManagerHeight - 10);
			vManager.setLayoutY(paneHeight - vManagerHeight + 10);

			manageUsers = new Button("Manage Users");
			manageUsers.setPrefSize(btnWidth, btnHeight);
			manageUsers.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent useravt) {
					Dialog dialog = new Dialog();
					dialog.setTitle("Manage Users");
					dialog.setHeaderText("Choose any of the actions below");

					GridPane grid = new GridPane();
					grid.setHgap(10);
					grid.setVgap(10);

					TextField userName = new TextField();
					ObservableList<String> userTypes = FXCollections.observableArrayList("Standard", "Admin");

					final ComboBox userSelect = new ComboBox(userTypes);
					userSelect.getSelectionModel().selectFirst();

					GridPane userInner = new GridPane();
					Format.innergrid(userInner);
					int userInnerCol = 3;
					for (int i = 0; i < userInnerCol; i++) {
						ColumnConstraints column = new ColumnConstraints(100);
						userInner.getColumnConstraints().add(column);
					}
					// ArrayList<User> localList = new
					// ArrayList<User>(usersList);
					refreshUsers(userInner, usersList);
					ScrollPane userInnerScrl = new ScrollPane();
					userInnerScrl.setVbarPolicy(ScrollBarPolicy.ALWAYS);
					userInnerScrl.setPrefHeight(150);
					userInnerScrl.setContent(userInner);

					Button addUser = new Button("Add");
					addUser.setTooltip(new Tooltip("Default password for new user is empty"));
					addUser.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent userat) {
							if (userName.getText().equals("")) {
								invalidInputAlert();
							} else {
								String name = userName.getText();
								boolean doubleEntry = false;
								// Check if user exists already
								for (int j = 0; j < usersList.size(); j++) {
									if (usersList.get(j).getUserName().equals(name)) {
										doubleEntry = true;
										Alert alert = new Alert(AlertType.ERROR);
										alert.setTitle("Invalid Input Error");
										alert.setHeaderText("Double Entry Error");
										alert.setContentText("This user already exists! No new user created.");
										alert.showAndWait();
										break;
									}
								}
								if (!doubleEntry) {
									boolean type;
									if (userSelect.getValue().equals("Admin")) {
										type = true;
									} else {
										type = false;
									}
									User user = new User(name, "", type);
									usersList.add(user);
									refreshUsers(userInner, usersList);
									try {
										FileOutputStream fileOut = new FileOutputStream(userPath);
										ObjectOutputStream out = new ObjectOutputStream(fileOut);
										out.writeObject(usersList);
										userLogger.log(Level.FINE, "Added new user " + userName.getText() + " of type "
												+ userSelect.getValue() + " to the system.");
										out.close();
										fileOut.close();
									} catch (IOException i) {
										logger.log(Level.SEVERE, "" + i);
									}
								}
							}
						}
					});

					grid.add(new Label("User Name"), 0, 0);
					grid.add(new Label("User Type"), 1, 0);
					grid.add(userName, 0, 1);
					grid.add(userSelect, 1, 1);
					grid.add(addUser, 2, 1);
					grid.add(new Label("Existing users"), 0, 2);
					grid.add(userInnerScrl, 0, 3, 3, 1);

					ButtonType saveButton = new ButtonType("Done", ButtonData.OK_DONE);
					dialog.getDialogPane().getButtonTypes().addAll(saveButton);
					dialog.getDialogPane().setContent(grid);
					dialog.showAndWait();
				}
			});
			addMenubook = new Button("Menubook");
			addMenubook.setPrefSize(btnWidth, btnHeight);
			addMenubook.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent at) {
					Dialog dialog = new Dialog();
					dialog.setTitle("Menubook Manager");
					dialog.setHeaderText("Make changes to menubook and click save");

					GridPane grid = new GridPane();
					grid.setHgap(10);
					grid.setVgap(10);

					TextField mnuName = new TextField();
					TextField mnuPrice = new TextField();
					Button addMnu = new Button("Add");
					ArrayList<Order> localList = new ArrayList<Order>(menubook);
					addMnu.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent a) {
							if (mnuName.getText().equals("") || mnuPrice.getText().equals("")) {
								invalidInputAlert();
							} else {
								String name = mnuName.getText();
								boolean doubleEntry = false;
								// Check if menu exists already
								for (int j = 0; j < menubook.size(); j++) {
									if (menubook.get(j).getName().equals(name)) {
										doubleEntry = true;
										Alert alert = new Alert(AlertType.ERROR);
										alert.setTitle("Invalid Input Error");
										alert.setHeaderText("Double Entry Error");
										alert.setContentText(
												"The item you entered already exists in the menubook. No new item entered.");
										alert.showAndWait();
										break;
									}
								}
								if (!doubleEntry) {
									try {
										// Check if price has more than 2
										// decimals
										String numberText = mnuPrice.getText();
										int integerPlaces = numberText.indexOf('.');
										int decimalPlaces;
										if (integerPlaces >= 0) {
											decimalPlaces = numberText.length() - integerPlaces - 1;
										} else {
											decimalPlaces = 0;
										}
										// Check if price is an actual double
										Double price = Double.parseDouble(mnuPrice.getText());
										if (price < 0 || decimalPlaces > 2) {
											throw new NumberFormatException();
										}
										Order newOrder = new Order(name, price);
										localList.add(newOrder);

										// Overwrite existing menubook with
										// changes
										menubook.clear();
										for (int i = 0; i < localList.size(); i++) {
											menubook.add(localList.get(i));
										}
										// Serialize menubook
										try {
											FileOutputStream fileOut = new FileOutputStream(menuPath);
											ObjectOutputStream out = new ObjectOutputStream(fileOut);
											out.writeObject(menubook);
											out.close();
											fileOut.close();
											userLogger.log(Level.FINE,
													"Added new menu " + mnuName.getText() + " into the system.");
											Alert alert = new Alert(AlertType.INFORMATION);
											alert.setTitle("Order item added");
											alert.setHeaderText("Order item added");
											alert.setContentText(
													"Order item has been successfully added into the menubook and can now be used.");
											alert.showAndWait();
										} catch (IOException i) {
											logger.log(Level.SEVERE, "" + i);
										}
									} catch (NumberFormatException n) {
										invalidInputAlert();
									}
								}
							}
						}
					});

					Button browseBtn = new Button("Check out existing menubook");
					browseBtn.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent browseat) {
							Dialog dialog = new Dialog();
							dialog.setTitle("Menubook");
							dialog.setHeaderText("The following items are in the current menubook");

							GridPane grid = new GridPane();
							grid.setHgap(10);
							grid.setVgap(10);

							TextArea mnuArea = new TextArea();
							mnuArea.setEditable(false);
							DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
							DecimalFormat df = new DecimalFormat("##0.00", formatSymbols);
							for (int i = 0; i < menubook.size(); i++) {
								Order localOrder = menubook.get(i);
								mnuArea.appendText("Name: " + localOrder.getName() + ", Price: "
										+ df.format(localOrder.getPrice()) + "\n");
							}
							grid.add(mnuArea, 0, 1);

							ButtonType done = new ButtonType("Done", ButtonData.OK_DONE);
							dialog.getDialogPane().getButtonTypes().addAll(done);

							dialog.getDialogPane().setContent(grid);

							Optional<ButtonType> result = dialog.showAndWait();
						}
					});

					grid.add(new Label("Menu Name"), 0, 0);
					grid.add(new Label("Menu Price"), 1, 0);
					grid.add(mnuName, 0, 1);
					grid.add(mnuPrice, 1, 1);
					grid.add(addMnu, 2, 1);
					grid.add(browseBtn, 0, 2);

					// Set the button types.
					ButtonType saveButton = new ButtonType("Done", ButtonData.OK_DONE);
					dialog.getDialogPane().getButtonTypes().addAll(saveButton);

					dialog.getDialogPane().setContent(grid);
					dialog.showAndWait();
				}
			});

			vManager.getChildren().addAll(manageUsers, addMenubook);
			root.getChildren().add(vManager);
		}

		// Main screen graphical section
		tblPane = new Pane();
		tblPane.setPadding(new Insets(5));
		tblPane.setStyle("-fx-background-image: url('main_area.jpg');");
		// tblPane.setStyle("-fx-background-color: #d2b48c;");
		tblPane.setLayoutX(vMenuWidth + 10);
		tblPane.setPrefSize(paneWidth - tblPane.getLayoutX(), paneHeight);

		boolean previousTables;
		// Load currently occupied tables from currentTables, if any
		try {
			FileInputStream fileIn = new FileInputStream(tablePath);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			currentTables = (ArrayList<Table>) in.readObject();
			in.close();
			fileIn.close();
			previousTables = true;
		} catch (Exception x) {
			previousTables = false;
		}

		// if no previous tables exist, create dummy tables
		// else load previous tables
		// Format.table(Table lbl, String text, double posX, double posY, int
		// width, int height)
		if (previousTables) {
			for (int i = 0; i < currentTables.size(); i++) {
				lbl = currentTables.get(i);
				String n = lbl.getName();
				double x = lbl.getX(), y = lbl.getY();
				Format.table(lbl, n, x, y, tblWidth, tblHeight);
				handleTable(lbl);
				tblPane.getChildren().add(lbl);
			}
		}

		double posX, posY = 20;
		double mainPaneWidth = paneWidth - tblPane.getLayoutX();
		int tblPadding = 40;
		int maxPosLine = 5;
		int maxTbls = 15;

		for (int i = 0; i < maxTbls; i++) {
			String check = "Table" + (i + 1);
			boolean exists = false;
			for (int j = 0; j < currentTables.size(); j++) {
				if (currentTables.get(j).getName().equals(check)) {
					exists = true;
					break;
				}
			}
			if (!exists) {
				lbl = new Table("Table" + (i + 1));
				posX = (tblPadding + (i % maxPosLine) * (tblWidth + tblPadding));
				posY = tblPadding + (i / maxPosLine) * (tblPadding + tblHeight + tblPadding);
				Format.table(lbl, ("Table" + (i + 1)), posX, posY, tblWidth, tblHeight);
				handleTable(lbl);
				tblPane.getChildren().add(lbl);
			}
		}

		tblScrlPane = new ScrollPane();
		tblScrlPane.setLayoutX(vMenuWidth + 10);
		tblScrlPane.setPrefSize(paneWidth - tblScrlPane.getLayoutX(), paneHeight);
		tblScrlPane.setContent(tblPane);
		root.getChildren().addAll(vMenu, tblScrlPane);
		root.setStyle("-fx-background-image: url('main_area.jpg');");
		// create a new scene with root and set the stage
		Scene scene = new Scene(root, paneWidth, paneHeight);
		// Align center of scene with window center
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		stage.setX((screenBounds.getWidth() - paneWidth) / 2);
		stage.setY((screenBounds.getHeight() - paneHeight) / 2);
		stage.setScene(scene);
		stage.show();

		// (De-)Serialize menubook
		try {
			FileInputStream fileIn = new FileInputStream(menuPath);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			menubook = (ArrayList<Order>) in.readObject();
			in.close();
			fileIn.close();
		} catch (Exception x) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("No menubook available");
			alert.setContentText(
					"No available menubook has been found. Load menu items or create menu items before using order functionalities.");
			alert.showAndWait();
		}

		// (De-)Serialize order log
		try {
			FileInputStream fileIn = new FileInputStream(orderLogPath);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			orderLog = (ArrayList<Order>) in.readObject();
			in.close();
			fileIn.close();
		} catch (Exception logX) {
			logger.log(Level.INFO, "Order log created as no previous log found.");
			try {
				// Creates new order log
				FileOutputStream fileOut = new FileOutputStream(orderLogPath);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(orderLog);
				out.close();
				fileOut.close();
			} catch (IOException logX2) {
				logger.log(Level.WARNING, "" + logX2);
			}
		}
		// Confirm ending session and saving current Tables to a file
		scene.getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent ev) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Please confirm");
				alert.setHeaderText("Confirm end of session");
				alert.setContentText("Are you sure you want to log out?");

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					if (!(currentTables.isEmpty())) {
						serialize(currentTables);
					}
					try {
						// Creates new order log
						FileOutputStream fileOut = new FileOutputStream(orderLogPath);
						ObjectOutputStream out = new ObjectOutputStream(fileOut);
						out.writeObject(orderLog);
						out.close();
						fileOut.close();
					} catch (IOException logX2) {
						logger.log(Level.WARNING, "" + logX2);
					}
					userLogger.log(Level.FINE, currentUser.getUserName() + " has logged out.");
					fhUser.close();
					fhLog.close();
					// Let Window Closer if OK
				} else {
					ev.consume();
				}
			}

		});

	}

	/**
	 * Add table handlers.
	 *
	 * @param lbl
	 *            the lbl
	 */
	// Table constructor section
	private void handleTable(Table lbl) {
		lbl.setOnMousePressed(tablePressedHandler);
		lbl.setOnMouseClicked(tableMenuHandler);
		lbl.setTooltip(new Tooltip("Click on table to add order"));
	}

	/** The current tables. */
	// Serialization section
	private ArrayList<Table> currentTables = new ArrayList<Table>();

	/** The table path. */
	private final String tablePath = "res/current_tables.ser";

	/**
	 * Serialize.
	 *
	 * @param currentTables
	 *            the current tables
	 */
	private void serialize(ArrayList<Table> currentTables) {
		try {
			FileOutputStream fileOut = new FileOutputStream(tablePath);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(currentTables);
			out.close();
			fileOut.close();
			// Message box "Serialized data is saved in tablePath"
		} catch (IOException i) {
			logger.log(Level.SEVERE, "" + i);
		}
	}

	/** The src scene Y. */
	// Table icon movement section
	double srcSceneX, srcSceneY;

	/** The src translate Y. */
	double srcTranslateX, srcTranslateY;

	/** The table pressed handler. */
	// get original data
	EventHandler<MouseEvent> tablePressedHandler = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent evt) {
			srcSceneX = evt.getSceneX();
			srcSceneY = evt.getSceneY();
			srcTranslateX = ((Table) evt.getSource()).getTranslateX();
			srcTranslateY = ((Table) evt.getSource()).getTranslateY();
		}
	};

	/** The table menu handler. */
	// Menu Adding Section
	EventHandler<MouseEvent> tableMenuHandler = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent evt) {
			if (evt.getButton().equals(MouseButton.PRIMARY)) {

				if (evt.getClickCount() == 1) {
					Table selectedTbl = ((Table) evt.getSource());
					// Create the custom dialog.
					Dialog dialog = new Dialog();
					dialog.setTitle("Table Menu");
					dialog.setHeaderText(selectedTbl.getText() + " Menu");

					GridPane grid = new GridPane();
					grid.setHgap(10);
					grid.setVgap(10);

					int rowNum = 0, lblRow = 0;

					// Num of people
					TextField people = new TextField();
					people.setPromptText("Number of people");

					// Innergrid to display ordered items
					ArrayList<Order> localList = new ArrayList<Order>(selectedTbl.getOrders());
					// initializing innergrid before addPane so EventListener
					// can refresh innergrid
					GridPane innergrid = new GridPane();
					Format.innergrid(innergrid);
					innergrid.setPrefWidth(600);
					innergrid.setPadding(new Insets(0));
					// Setting columns width
					String[] innerColumns = { "Menu Name", "Price", "Qnty", "Total", "Comments", "Time added",
							"Cancel Order" };
					ColumnConstraints col1 = new ColumnConstraints();
					col1.setPercentWidth(25);
					innergrid.getColumnConstraints().add(col1);
					ColumnConstraints col2 = new ColumnConstraints();
					col2.setPercentWidth(5);
					innergrid.getColumnConstraints().add(col2);
					ColumnConstraints col3 = new ColumnConstraints();
					col3.setPercentWidth(5);
					innergrid.getColumnConstraints().add(col3);
					ColumnConstraints col4 = new ColumnConstraints();
					col4.setPercentWidth(10);
					innergrid.getColumnConstraints().add(col4);
					ColumnConstraints col5 = new ColumnConstraints();
					col5.setPercentWidth(20);
					innergrid.getColumnConstraints().add(col5);
					ColumnConstraints col6 = new ColumnConstraints();
					col6.setPercentWidth(20);
					innergrid.getColumnConstraints().add(col6);
					ColumnConstraints col7 = new ColumnConstraints();
					col7.setPercentWidth(15);
					innergrid.getColumnConstraints().add(col7);

					// Populating columns
					for (int i = 0; i < innerColumns.length; i++) {
						Label menuLbl = new Label(innerColumns[i]);
						innergrid.add(menuLbl, i, 0);
					}

					// Put innergrid in ScrollPane
					ScrollPane innerScrlPane = new ScrollPane();
					innerScrlPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
					innerScrlPane.setPrefHeight(150);
					innerScrlPane.setContent(innergrid);

					// Amount due
					Label amount = new Label();

					// Add Orders section
					GridPane addPane = new GridPane();
					String[] addColumns = { "Menu Name", "Quantity", "Comments", "Browse Menu", "Add Order" };
					// Populating columns
					for (int i = 0; i < addColumns.length; i++) {
						Label menuLbl = new Label(addColumns[i]);
						addPane.add(menuLbl, i, 0);
					}
					addPane.prefWidth(600);
					addPane.setHgap(10);
					TextField addMenuName = new TextField();
					addMenuName.setPrefWidth(200);
					addPane.add(addMenuName, 0, 1);
					TextField addMenuQnty = new TextField();
					addMenuQnty.setText("1");
					addMenuQnty.setPrefWidth(40);
					addPane.add(addMenuQnty, 1, 1);
					TextField addMenuComment = new TextField();
					addMenuComment.setPrefWidth(150);
					addPane.add(addMenuComment, 2, 1);
					Button addBrowseBtn = new Button("Browse");
					addBrowseBtn.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent browseat) {
							Dialog dialog = new Dialog();
							dialog.setTitle("Menubook");
							dialog.setHeaderText("The following items are in the current menubook");

							GridPane grid = new GridPane();
							grid.setHgap(10);
							grid.setVgap(10);

							TextArea mnuArea = new TextArea();
							mnuArea.setEditable(false);
							for (int i = 0; i < menubook.size(); i++) {
								Order localOrder = menubook.get(i);
								mnuArea.appendText(
										"Name: " + localOrder.getName() + ", Price: " + localOrder.getPrice() + "\n");
							}
							grid.add(mnuArea, 0, 1);

							ButtonType done = new ButtonType("Done", ButtonData.OK_DONE);
							dialog.getDialogPane().getButtonTypes().addAll(done);

							dialog.getDialogPane().setContent(grid);

							Optional<ButtonType> result = dialog.showAndWait();
						}
					});
					addBrowseBtn.setPrefWidth(80);
					addPane.add(addBrowseBtn, 3, 1);
					Button addMenuBtn = new Button("Add Menu");
					addMenuBtn.setPrefWidth(80);
					addMenuBtn.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent at) {
							if (addMenuName.getText().equals("") || addMenuQnty.getText().equals("")) {
								invalidInputAlert();
							} else {
								// Match text of menubook with entered text, add
								// order if match
								String mnuName = addMenuName.getText();
								boolean matchFound = false;
								for (int i = 0; i < menubook.size(); i++) {
									if (mnuName.equals(menubook.get(i).getName())) {
										try {
											int qnty = Integer.parseInt(addMenuQnty.getText());
											if (qnty < 0) {
												throw new NumberFormatException();
											}
											String cmt = addMenuComment.getText();
											String srcTbl = selectedTbl.getName();
											Order tblOrder = new Order(menubook.get(i), qnty, cmt, srcTbl);
											localList.add(tblOrder);
											matchFound = true;
											refreshOrders(innergrid, localList, innerColumns, amount);
										} catch (NumberFormatException n) {
											break;
										}
										break;
									}
								}
								if (!matchFound) {
									invalidInputAlert();
								}
							}
						}
					});
					addPane.add(addMenuBtn, 4, 1);

					// Order List
					// Loops through each order at table and fills label with
					// each order information
					refreshOrders(innergrid, localList, innerColumns, amount);

					Separator separator1 = new Separator();

					grid.add(new Label("Number of people: "), 0, lblRow++);
					grid.add(people, 1, rowNum++);
					grid.add(new Label("Add orders: "), 0, lblRow++);
					grid.add(addPane, 1, rowNum++);
					grid.add(new Label("Current orders: "), 0, lblRow++);
					grid.add(innerScrlPane, 1, rowNum++);
					lblRow++;
					grid.add(separator1, 1, rowNum++);
					grid.add(new Label("Total Amount Due"), 0, lblRow++);
					grid.add(amount, 1, rowNum);

					// If table exists already, load text information
					if (currentTables.contains(selectedTbl)) {
						int srcIndex = currentTables.indexOf(selectedTbl);
						Table srcTable = currentTables.get(srcIndex);
						people.setText(srcTable.getPeople());
					}

					// Set the button types.
					ButtonType saveButton = new ButtonType("Save", ButtonData.OK_DONE);
					ButtonType bill = new ButtonType("Pay", ButtonData.OK_DONE);
					dialog.getDialogPane().getButtonTypes().addAll(saveButton, bill, ButtonType.CANCEL);
					dialog.getDialogPane().setContent(grid);
					Optional<ButtonType> result = dialog.showAndWait();
					if (result.get() == saveButton) {
						// Update Table order list
						selectedTbl.setOrders(localList);
						// If table exists already, override existing table
						if (currentTables.contains(selectedTbl)) {
							currentTables.remove(selectedTbl);
						}
						selectedTbl.setPeople(people.getText());
						currentTables.add(selectedTbl);
						userLogger.log(Level.FINE, "Saved changes made at " + selectedTbl.getName());

					} else if (result.get() == bill) {
						for (int i = 0; i < localList.size(); i++) {
							orderLog.add(localList.get(i));
						}
						selectedTbl.clear();
						currentTables.remove(selectedTbl);
						userLogger.log(Level.FINE, "Received payment of table. Orders logged and table cleared.");
					}
				}
			}
		}
	};

	/**
	 * Refresh users.
	 *
	 * @param innergrid
	 *            the innergrid
	 * @param userList
	 *            the user list
	 */
	private void refreshUsers(GridPane innergrid, ArrayList<User> userList) {
		innergrid.getChildren().clear();
		String[] labels = { "Username", "Type", "Activity", "Options" };
		for (int i = 0; i < labels.length; i++) {
			Label lbl = new Label(labels[i]);
			innergrid.add(lbl, i, 0);
		}
		for (int i = 1; i <= userList.size(); i++) {
			User u = userList.get(i - 1);
			String uName = u.getUserName();
			boolean uAdmin = u.getUserRights();
			Label usName = new Label();
			usName.setText(uName);
			innergrid.add(usName, 0, i);
			Label usType = new Label();
			if (uAdmin) {
				usType.setText("Admin");
			} else {
				usType.setText("Standard");
			}
			innergrid.add(usType, 1, i);
			Button viewLog = new Button("View Log");
			viewLog.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent view) {
					Dialog dialog = new Dialog();
					dialog.setTitle("User Activity log");
					dialog.setHeaderText("Selected activity log");

					GridPane grid = new GridPane();
					grid.setHgap(10);
					grid.setVgap(10);

					TextArea logArea = new TextArea();
					logArea.setEditable(false);
					grid.add(logArea, 0, 1);
					int row = innergrid.getRowIndex((Button) view.getSource());
					Label toView = (Label) getNodeByIndex(innergrid, 0, row);
					String localPath = ("res/" + toView.getText() + "_activity.log");
					try {
						Scanner fileIn = new Scanner(new File(localPath));
						while (fileIn.hasNextLine()) {
							logArea.appendText(fileIn.nextLine() + "\n");
						}
						fileIn.close();
					} catch (IOException i) {
						logger.log(Level.WARNING,
								"No activity log for user has been found. User might have deleted his/her log or has never logged in. \n Opening activity log failed due to: \n "
										+ i);
					}

					ButtonType done = new ButtonType("Done", ButtonData.OK_DONE);
					dialog.getDialogPane().getButtonTypes().addAll(done);

					dialog.getDialogPane().setContent(grid);

					Optional<ButtonType> result = dialog.showAndWait();
				}
			});
			innergrid.add(viewLog, 2, i);
			// Disable delete button for root admin (the first user)
			if (i > 1) {
				Button deleteUser = new Button("Delete");
				deleteUser.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent userdlt) {
						// Confirm before deletion of user
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Confirm User Deletion");
						alert.setHeaderText("Confirm User Deletion");
						alert.setContentText("Are you sure you want to delete this user?");

						Optional<ButtonType> result = alert.showAndWait();
						if (result.get() == ButtonType.OK) {
							@SuppressWarnings("static-access")
							int row = innergrid.getRowIndex((Button) userdlt.getSource());
							Label toDelete = (Label) getNodeByIndex(innergrid, 0, row);
							String toDeleteName = toDelete.getText();
							for (int n = 0; n < userList.size(); n++) {
								String userName = userList.get(n).getUserName();
								if (userName.equals(toDeleteName)) {
									userList.remove(n);
									userLogger.log(Level.FINE, toDeleteName + " has been deleted from the system.");
									break;
								}
							}
							refreshUsers(innergrid, userList);
						}
					}
				});
				innergrid.add(deleteUser, 3, i);
			}
		}
	}

	/**
	 * Refresh search.
	 *
	 * @param innergrid
	 *            the innergrid
	 * @param ordersList
	 *            the orders list
	 * @param labels
	 *            the labels
	 * @param selectedList
	 *            the selected list
	 */
	private void refreshSearch(GridPane innergrid, ArrayList<Order> ordersList, String[] labels,
			ArrayList<Order> selectedList) {
		innergrid.getChildren().clear();
		for (int i = 0; i < labels.length; i++) {
			Label menuLbl = new Label(labels[i]);
			innergrid.add(menuLbl, i, 0);
		}
		// { "Table No.", "Order Name", "Price", "Quantity", "Total", "Order
		// Datetime", "Comments" }
		DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
		DecimalFormat df = new DecimalFormat("##0.00", formatSymbols);
		for (int i = 1; i <= ordersList.size(); i++) {
			int localCol = 0;
			Order mn = ordersList.get(i - 1);
			String mnTbl = mn.getSrcTbl();
			String mnName = mn.getName();
			Double mnPrice = mn.getPrice();
			int mnQnty = mn.getQnty();
			Date mnDate = mn.getDate();
			String mnComment = mn.getComment();
			Label menuTbl = new Label();
			menuTbl.setText(mnTbl);
			innergrid.add(menuTbl, localCol++, i);
			Label menuName = new Label();
			menuName.setText(mnName);
			innergrid.add(menuName, localCol++, i);
			Label price = new Label();
			price.setText("" + df.format(mnPrice));
			innergrid.add(price, localCol++, i);
			Label qnty = new Label();
			qnty.setText("" + mnQnty);
			innergrid.add(qnty, localCol++, i);
			Label lineTotal = new Label();
			lineTotal.setText("" + df.format(mnPrice * mnQnty));
			innergrid.add(lineTotal, localCol++, i);
			Label timeAdded = new Label();
			timeAdded.setText(dateFormat.format(mnDate));
			innergrid.add(timeAdded, localCol++, i);
			Label menuComment = new Label();
			menuComment.setText(mnComment);
			innergrid.add(menuComment, localCol++, i);
		}
		if (currentUser.getUserRights()) {
			Label menuLbl = new Label("Select");
			innergrid.add(menuLbl, labels.length, 0);
			for (int i = 1; i <= ordersList.size(); i++) {
				CheckBox checkBox = new CheckBox();
				checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
					public void changed(ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) {
						// gets row of checkbox selected
						int row = innergrid.getRowIndex(checkBox);
						int cols = labels.length;
						Node[] toExportNodes = getRowNodesByIndex(innergrid, row, cols);
						String[] toExport = new String[toExportNodes.length];
						for (int j = 0; j < toExportNodes.length; j++) {
							Label l = (Label) toExportNodes[j];
							String s = l.getText();
							toExport[j] = s;
						}
						// Create new order here
						try {
							String expTbl = toExport[0];
							String expName = toExport[1];
							Double expPrice = Double.parseDouble(toExport[2]);
							int expQnty = Integer.parseInt(toExport[3]);
							Date expDate = dateFormat.parse(toExport[5]);
							String expComment = toExport[6];
							Order expOrder = new Order(expName, expPrice, expQnty, expTbl, expComment, expDate);
							selectedList.add(expOrder);
						} catch (ParseException p) {
							logger.log(Level.SEVERE, "" + p);
						}
						checkBox.setDisable(true);
					}
				});
				innergrid.add(checkBox, 7, i);
			}
		}
	}

	/**
	 * Refresh orders.
	 *
	 * @param innergrid
	 *            the innergrid
	 * @param ordersList
	 *            the orders list
	 * @param labels
	 *            the labels
	 * @param amount
	 *            the amount
	 */
	private void refreshOrders(GridPane innergrid, ArrayList<Order> ordersList, String[] labels, Label amount) {
		innergrid.getChildren().clear();
		double netAmount = 0.0;
		// Recreating labels
		for (int i = 0; i < labels.length; i++) {
			Label menuLbl = new Label(labels[i]);
			innergrid.add(menuLbl, i, 0);
		}
		DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
		DecimalFormat df = new DecimalFormat("##0.00", formatSymbols);
		for (int i = 1; i <= ordersList.size(); i++) {
			int localCol = 0;
			Order mn = ordersList.get(i - 1);
			String mnName = mn.getName();
			Double mnPrice = mn.getPrice();
			int mnQnty = mn.getQnty();
			Date mnDate = mn.getDate();
			String mnComment = mn.getComment();
			Label menuName = new Label();
			menuName.setText(mnName);
			innergrid.add(menuName, localCol++, i);
			Label price = new Label();
			price.setText("" + df.format(mnPrice));
			innergrid.add(price, localCol++, i);
			Label qnty = new Label();
			qnty.setText("" + mnQnty);
			innergrid.add(qnty, localCol++, i);
			Label lineTotal = new Label();
			lineTotal.setText("" + df.format(mnPrice * mnQnty));
			innergrid.add(lineTotal, localCol++, i);
			Label menuComment = new Label();
			menuComment.setText(mnComment);
			innergrid.add(menuComment, localCol++, i);
			Label timeAdded = new Label();
			timeAdded.setText(dateFormat.format(mnDate));
			innergrid.add(timeAdded, localCol++, i);
			Button deleteOrder = new Button("Delete Order");
			deleteOrder.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent avt) {
					// Confirm before deletion of order
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Confirm Order Deletion");
					alert.setHeaderText("Confirm Order Deletion");
					alert.setContentText("Are you sure you want to delete this order?");

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						@SuppressWarnings("static-access")
						int row = innergrid.getRowIndex((Button) avt.getSource());
						Label toDelete = (Label) getNodeByIndex(innergrid, 0, row);
						String toDeleteName = toDelete.getText();
						for (int n = 0; n < ordersList.size(); n++) {
							String orderName = ordersList.get(n).getName();
							if (orderName.equals(toDeleteName)) {
								ordersList.remove(n);
								break;
							}
						}
						refreshOrders(innergrid, ordersList, labels, amount);
					}
				}
			});
			innergrid.add(deleteOrder, localCol++, i);
			netAmount += (mnPrice * mnQnty);
		}
		amount.setText("" + df.format(netAmount));
	}

	/**
	 * Gets the node by index.
	 *
	 * @param grid
	 *            the grid
	 * @param col
	 *            the col
	 * @param row
	 *            the row
	 * @return the node by index
	 */
	private Node getNodeByIndex(GridPane grid, int col, int row) {
		for (Node node : grid.getChildren()) {
			if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
				return node;
			}
		}
		return null;
	}

	/**
	 * Gets the row nodes by index.
	 *
	 * @param grid
	 *            the grid
	 * @param row
	 *            the row
	 * @param colNum
	 *            the col num
	 * @return the row nodes by index
	 */
	private Node[] getRowNodesByIndex(GridPane grid, int row, int colNum) {
		Node[] nodes = new Node[colNum];
		int colCount = 0;
		for (Node node : grid.getChildren()) {
			if (GridPane.getColumnIndex(node) == colCount && GridPane.getRowIndex(node) == row) {
				nodes[colCount] = node;
				colCount++;
			}
			if (colCount == colNum) {
				return nodes;
			}
		}
		return null;
	}

	/**
	 * Invalid input alert.
	 */
	private void invalidInputAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Invalid Input");
		alert.setHeaderText("Invalid Input");
		alert.setContentText("Please enter a valid item. Fields cannot be all empty.");
		alert.showAndWait();
	}
}
