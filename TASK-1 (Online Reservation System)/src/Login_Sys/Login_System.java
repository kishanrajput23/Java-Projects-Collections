package Login_Sys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;

import Reservationform.Reservation;//importing Reservation package

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login_System {

	private JFrame frame;
	private JTextField textField;  //textField is variable for the username that is entered
	private JPasswordField txtPassword; ////textPassword is variable for the password that is entered

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_System window = new Login_System();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_System() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {//Defining labels that would appear on the login form
		frame = new JFrame();
		frame.setBounds(200, 200, 813, 581);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login to Railway Reservation System");//Heading
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(172, 62, 481, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel IblUsername = new JLabel("Username");//Username
		IblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		IblUsername.setBounds(167, 160, 129, 31);
		frame.getContentPane().add(IblUsername);
		
		JLabel IblPassword = new JLabel("Password");//Password
		IblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		IblPassword.setBounds(167, 214, 83, 20);
		frame.getContentPane().add(IblPassword);
		
		textField = new JTextField();//Creating textField for entering username
		textField.setBounds(306, 162, 187, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		txtPassword = new JPasswordField();//Creating textPassword for entering password
		txtPassword.setBounds(306, 211, 187, 31);
		frame.getContentPane().add(txtPassword);
		
		JButton btnNewButton = new JButton("Log In");//Login as submit button
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//On clicking login following operations would be performed
				
				String password = txtPassword.get;
				String username = textField.getText();
				
				if(password.contains("king")&& username.contains("one")) {//If the username and password matches
					txtPassword.setText(null);
					textField.setText(null);
					Reservation info=new Reservation();//Reservation form opens
					Reservation.main(null);
					
				}
				else {//If doesn't matches error
					JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
					textField.setText(null);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(143, 353, 89, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");//Reset button for clearing all fields
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				txtPassword.setText(null);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1.setBounds(306, 353, 89, 33);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");//Exit button to exit form
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmLoginSystem = new JFrame("Exit");//Dialog box to confirm exit
				if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(473, 353, 89, 33);
		frame.getContentPane().add(btnNewButton_2);
		
		JSeparator separator = new JSeparator();//Separators to create different sections in form
		separator.setBounds(29, 303, 657, -19);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();//Separators to create different sections in form
		separator_1.setBounds(100, 117, 571, -5);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();//Separators to create different sections in form
		separator_2.setBounds(43, 419, 637, -33);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();//Separators to create different sections in form
		separator_3.setBounds(82, 290, 607, 2);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();//Separators to create different sections in form
		separator_4.setBounds(82, 119, 607, 14);
		frame.getContentPane().add(separator_4);
		
		JSeparator separator_5 = new JSeparator();//Separators to create different sections in form
		separator_5.setBounds(43, 117, 1, 166);
		frame.getContentPane().add(separator_5);
		
		JSeparator separator_6 = new JSeparator();//Separators to create different sections in form
		separator_6.setBounds(43, 110, 1, 174);
		frame.getContentPane().add(separator_6);
		
		JSeparator separator_7 = new JSeparator();//Separators to create different sections in form
		separator_7.setBounds(43, 282, 1, 2);
		frame.getContentPane().add(separator_7);
	}
}
