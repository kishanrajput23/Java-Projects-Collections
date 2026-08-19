import java.awt.*;
import java.awt.event.*;

public class OnlineLearningSystemAWT {
    private Frame loginFrame, registerFrame, courseFrame, profileFrame;
    private Panel loginPanel, registerPanel, coursePanel, profilePanel;
    private Label usernameLabel, passwordLabel, nameLabel, emailLabel, courseLabel;
    private TextField usernameTextField, passwordTextField, nameTextField, emailTextField;
    private Button loginButton, registerButton, courseButton, profileButton, backButton;
    private Choice courseChoice;
    private Checkbox termsCheckbox;
    public OnlineLearningSystemAWT() {
        createLoginGUI();
    }

    private void createLoginGUI() {
        loginFrame = new Frame("Login");
        loginFrame.setSize(300, 200);
        loginFrame.setLayout(new BorderLayout());

        loginPanel = new Panel();
        loginPanel.setLayout(new FlowLayout());

        usernameLabel = new Label("Username:");
        usernameTextField = new TextField(20);
        passwordLabel = new Label("Password:");
        passwordTextField = new TextField(20);
        loginButton = new Button("Login");
        registerButton = new Button("Register");

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameTextField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordTextField);
        loginPanel.add(loginButton);
        loginPanel.add(registerButton);

        loginFrame.add(loginPanel, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createRegisterGUI();
                loginFrame.setVisible(false);
            }
        });
        
        loginFrame.setVisible(true);
    }

    private void createRegisterGUI() {
        registerFrame = new Frame("Register");
        registerFrame.setSize(300, 250);
        registerFrame.setLayout(new BorderLayout());

        registerPanel = new Panel();
        registerPanel.setLayout(new FlowLayout());

        nameLabel = new Label("Name:");
        nameTextField = new TextField(20);
        emailLabel = new Label("Email:");
        emailTextField = new TextField(20);
        usernameLabel = new Label("Username:");
        usernameTextField = new TextField(20);
        passwordLabel = new Label("Password:");
        passwordTextField = new TextField(20);
        termsCheckbox = new Checkbox("I agree to terms and conditions");
        registerButton = new Button("Register");
        backButton = new Button("Back");

        registerPanel.add(nameLabel);
        registerPanel.add(nameTextField);
        registerPanel.add(emailLabel);
        registerPanel.add(emailTextField);
        registerPanel.add(usernameLabel);
        registerPanel.add(usernameTextField);
        registerPanel.add(passwordLabel);
        registerPanel.add(passwordTextField);
        registerPanel.add(termsCheckbox);
        registerPanel.add(registerButton);
        registerPanel.add(backButton);

        registerFrame.add(registerPanel, BorderLayout.CENTER);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerFrame.dispose();
                loginFrame.setVisible(true);
            }
        });

        
        registerFrame.setVisible(true);
    }

    private void createCourseGUI() {
        courseFrame = new Frame("Courses");
        courseFrame.setSize(300, 200);
        courseFrame.setLayout(new BorderLayout());

        coursePanel = new Panel();
        coursePanel.setLayout(new FlowLayout());

        courseLabel = new Label("Select Course:");
        courseChoice = new Choice();
        courseChoice.add("Course 1");
        courseChoice.add("Course 2");
        courseChoice.add("Course 3");
        courseButton = new Button("Enroll");
        backButton = new Button("Back");

        coursePanel.add(courseLabel);
        coursePanel.add(courseChoice);
        coursePanel.add(courseButton);
        coursePanel.add(backButton);

        courseFrame.add(coursePanel, BorderLayout.CENTER);

        courseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createProfileGUI();
                courseFrame.dispose();
            }
        });
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                courseFrame.dispose();
                loginFrame.setVisible(true);
            }
        });
        courseFrame.setVisible(true);
    }

    private void createProfileGUI() {
        profileFrame = new Frame("Profile");
        profileFrame.setSize(300, 250);
        profileFrame.setLayout(new BorderLayout());

        profilePanel = new Panel();
        profilePanel.setLayout(new FlowLayout());

        new TextArea(10, 20);
        profileButton = new Button("Save");
        backButton = new Button("Back");

        profileFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
            public void windowOpened(WindowEvent e) {}
            public void windowIconified(WindowEvent e) {}
            public void windowDeiconified(WindowEvent e) {}
            public void windowActivated(WindowEvent e) {}
            public void windowDeactivated(WindowEvent e) {}
        });
        
        profileFrame.add(profilePanel, BorderLayout.CENTER);

        profileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Profile saved");
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                profileFrame.dispose();
                courseFrame.setVisible(true);
            }
        });
        loginFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        registerFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        courseFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        profileFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        
        profileFrame.setVisible(true);
    }

    private void login() {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Please enter username and password");
            return;
        }

        // Authenticate user
        if (authenticateUser(username, password)) {
            createCourseGUI();
            loginFrame.dispose();
        } else {
            System.out.println("Invalid username or password");
        }
    }

    private void register() {
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (name.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()) {
            System.out.println("Please fill out all fields");
            return;
        }

        if (!termsCheckbox.getState()) {
            System.out.println("Please agree to terms and conditions");
            return;
        }

        if (registerUser(name, email, username, password)) {
            System.out.println("Registration successful");
            registerFrame.dispose();
            loginFrame.setVisible(true);
        } else {
            System.out.println("Registration failed");
        }
    }

    private boolean authenticateUser(String username, String password) {
    
        return true;
    }

    private boolean registerUser(String name, String email, String username, String password) {
        
        return true;
    }

    public static void main(String[] args) {
        new OnlineLearningSystemAWT();
    }
}