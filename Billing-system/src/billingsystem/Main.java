package billingsystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * 
 * @author Jason Li
 * @version 1.0
 * @since 19.12.2016
 * 
 * 
 * The Class Main.
 */
public class Main extends Application {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(Main.class.getName());
	
	/** The fh log. */
	private static FileHandler fhLog;
	
	/** The user path. */
	private String userPath = "res/users.ser";
	
	/** The log path. */
	private String logPath = "res/activity.log";
	
	/** The root admin. */
	private final String rootAdmin = "admin";
	
	/** The users list. */
	private ArrayList<User> usersList = null;
	
	/** The jarpath. */
	private String jarpath;

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) {
		
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
		try {
			try {
				FileInputStream fileIn = new FileInputStream(userPath);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				usersList = (ArrayList<User>) in.readObject();
				in.close();
				fileIn.close();
			} catch (IOException i) {
				logger.log(Level.INFO, "Root admin account 'admin' created on first time login.");
				// Create admin account if not existent
				User admin = new User(rootAdmin, "", true);
				usersList = new ArrayList<User>();
				usersList.add(admin);
				try {
					// Create user list with initial admin account
					FileOutputStream fileOut = new FileOutputStream(userPath);
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(usersList);
					out.close();
					fileOut.close();
				} catch (IOException i2) {
					logger.log(Level.WARNING, "" + i2);
				}
			}

			// Create Login Screen
			Parent root = FXMLLoader.load(getClass().getResource("/billingsystem/Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			fhLog.close();

		} catch (Exception e) {
			logger.log(Level.SEVERE,
					"Login Screen file has been deleted or is corrupted. Please restore 'Login.fxml' links. \n" + e);
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
