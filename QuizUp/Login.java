
package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Login extends JFrame implements ActionListener {
    
    JButton rules, back;
    JTextField tfname;
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        add(image);
        
        JLabel heading = new JLabel("QUIZ UP");
        heading.setBounds(810, 60, 300, 45);
        heading.setFont(new Font("Consolas", Font.BOLD, 40));
        heading.setForeground(Color.DARK_GRAY);
        add(heading);
        
          JLabel name = new JLabel("Enter Your Name");
        name.setBounds(810, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        name.setForeground(Color.DARK_GRAY);
        add(name);
        
         tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);
        
         rules = new JButton("Proceed");
        rules.setBounds(735, 270, 120, 25);
        add(rules);
        rules.setBackground(new Color(0,0,0));
        rules.addActionListener(this);
        rules.setForeground(Color.WHITE);
        
         back = new JButton("Back");
        back.setBounds(915, 270, 120, 25);
        add(back);
        back.setBackground(new Color(0,0,0));
        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        
        image.setBounds(0, 0, 600, 500);
        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        }else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String args[]) {
        Login login = new Login();
        
        }
    }
        
        

