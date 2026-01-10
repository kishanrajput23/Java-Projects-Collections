import java.awt.*;  
import javax.swing.JFrame;  
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class Reviews extends JFrame
{
	Reviews()
	{
		JLabel re,background,rgtxt1,rgtxt2,rgtxt3;
		JTextField tf1,tf2;
		JTextArea ta3;
		JButton submit,exit,back;
		Font f1,f2,f3;
		//declaration
		setSize(1570,840);
		setLayout(null);
		//background image
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon img=new ImageIcon("BImage.png");
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,1570,770);
		add(background);
		//background image finish
		re=new JLabel(new ImageIcon("RateGame.png"));
		re.setBounds(580,50,362,79);
		background.add(re);
		//mmbutton
		submit=new JButton(new ImageIcon("Submit.png"));
		submit.setBounds(610,600,291,79);
		submit.setBackground(Color.BLACK);
		background.add(submit);

		exit=new JButton(new ImageIcon("Exit.png"));
		exit.setBounds(610,600,291,79);
		exit.setBackground(Color.BLACK);
		background.add(exit);
		exit.setVisible(false);
		//exit
		back=new JButton(new ImageIcon("backbtn.png"));
		back.setBounds(0,0,100,100);
		back.setBackground(Color.BLACK);
		background.add(back);

		rgtxt1=new JLabel(new ImageIcon("rgtxt1.png"));
		rgtxt1.setBounds(225,175,274,73);
		background.add(rgtxt1);

		rgtxt2=new JLabel(new ImageIcon("rgtxt2.png"));
		rgtxt2.setBounds(225,275,296,73);
		background.add(rgtxt2);

		rgtxt3=new JLabel(new ImageIcon("rgtxt3.png"));
		rgtxt3.setBounds(225,375,200,73);
		background.add(rgtxt3);

		//fonts
		f1=new Font("SansSerif",Font.BOLD,35);
		f2=new Font("SansSerif",Font.BOLD,35);
		f3=new Font("SansSerif",Font.BOLD,35);

		//textfield and areas
		tf1=new JTextField();
		tf1.setBounds(600,180,500,50);
		tf1.setFont(f1);
		background.add(tf1);

		tf2=new JTextField();
		tf2.setBounds(600,280,500,50);
		tf2.setFont(f2);
		background.add(tf2);

		ta3=new JTextArea();
		ta3.setBounds(600,380,500,150);
		ta3.setFont(f3);
		background.add(ta3);

		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
				MainMenu m=new MainMenu();
			}
		});
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				String vtf1=tf1.getText();
				String vtf2=tf2.getText();

				if(vtf1.trim().equals("")||vtf2.trim().equals(""))
				{
					System.out.println("Enter All Fields");
					submit.setVisible(true);
					exit.setVisible(false);		
				}
				else
				{
					submit.setVisible(false);
					exit.setVisible(true);
					try
					{
						String reviewfile=tf1.getText()+"\t\t\t"+tf2.getText()+"\t\t\t"+ta3.getText()+"\n";
						char reviewtext[]=reviewfile.toCharArray();
						FileWriter f = new FileWriter("(((((Reviews.txt",true);
						f.write(reviewtext);
						f.close();
					}
					catch(IOException io)
					{
						System.out.println("IOException caught");
					}
				}
			}
		});
		//all actions
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
				System.out.println("Game Ended");
				System.exit(0);
			}
		});
		setVisible(true);
	}
	public static void main (String args[])
	{
		Reviews r=new Reviews();
	}
}