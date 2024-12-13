import java.awt.*;  
import javax.swing.JFrame;  
import java.awt.event.*;
import javax.swing.*;

class MainMenu extends JFrame
{
	MainMenu()
	{
		JLabel mm,background,logo;
		JButton pg,gg,rg,c,exit,back;
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
		logo=new JLabel(new ImageIcon("logo.png"));
		logo.setBounds(645,280,214,236);
		background.add(logo);
		//background image finish
		mm=new JLabel(new ImageIcon("MMbtn.png"));
		mm.setBounds(620,50,266,79);
		background.add(mm);
		//mmbutton
		pg=new JButton(new ImageIcon("PlayGame.png"));
		pg.setBounds(150,250,361,79);
		pg.setBackground(Color.BLACK);
		background.add(pg);
		//play game button
		gg=new JButton(new ImageIcon("GameGuide.png"));
		gg.setBounds(995,250,360,79);
		gg.setBackground(Color.BLACK);
		background.add(gg);
		//game Guide
		rg=new JButton(new ImageIcon("RateGame.png"));
		rg.setBounds(150,500,360,79);
		rg.setBackground(Color.BLACK);
		background.add(rg);	
		//rate game
		c=new JButton(new ImageIcon("Credits.png"));
		c.setBounds(995,500,360,79);
		c.setBackground(Color.BLACK);
		background.add(c);
		//credits
		exit=new JButton(new ImageIcon("Exit.png"));
		exit.setBounds(610,600,291,79);
		exit.setBackground(Color.BLACK);
		background.add(exit);
		//exit
		back=new JButton(new ImageIcon("backbtn.png"));
		back.setBounds(0,0,100,100);
		back.setBackground(Color.BLACK);
		background.add(back);

		//all Actions
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
				Introduction i=new Introduction();
			}
		});
		pg.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
				Fight f=new Fight();
			}
		});
		gg.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
				GameGuide gg=new GameGuide();
			}
		});
		rg.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
				Reviews r=new Reviews();
			}
		});
		c.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
				Credits c=new Credits();
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
		MainMenu m=new MainMenu();
	}
}