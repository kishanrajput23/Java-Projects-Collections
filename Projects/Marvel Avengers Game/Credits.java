import java.awt.*;  
import javax.swing.JFrame;  
import java.awt.event.*;
import javax.swing.*;

class Credits extends JFrame
{
	Credits()
	{
		JLabel cr,background,txt1,txt2,txt3,txt4;
		JButton exit,back;
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
		cr=new JLabel(new ImageIcon("Credits.png"));
		cr.setBounds(580,50,362,79);
		background.add(cr);
		//mmbutton
		exit=new JButton(new ImageIcon("Exit.png"));
		exit.setBounds(610,600,291,79);
		exit.setBackground(Color.BLACK);
		background.add(exit);
		//exit

		back=new JButton(new ImageIcon("backbtn.png"));
		back.setBounds(0,0,100,100);
		back.setBackground(Color.BLACK);
		background.add(back);

		txt1=new JLabel(new ImageIcon("txt1.png"));
		txt1.setBounds(300,175,441,73);
		background.add(txt1);

		txt2=new JLabel(new ImageIcon("txt2.png"));
		txt2.setBounds(300,275,440,73);
		background.add(txt2);

		txt3=new JLabel(new ImageIcon("txt3.png"));
		txt3.setBounds(300,375,300,73);
		background.add(txt3);

		txt4=new JLabel(new ImageIcon("txt4.png"));
		txt4.setBounds(300,475,823,73);
		background.add(txt4);

		//all actions
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
				MainMenu m=new MainMenu();
			}
		});
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
		Credits c=new Credits();
	}
}