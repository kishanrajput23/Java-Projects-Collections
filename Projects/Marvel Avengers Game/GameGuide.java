import java.awt.*;  
import javax.swing.JFrame;  
import java.awt.event.*;
import javax.swing.*;

class GameGuide extends JFrame
{
	public static int decider;
	GameGuide()
	{
		JLabel gg,background;
		JButton exit,back,av1,av2,av3,av4,v1,v2;
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
		gg=new JLabel(new ImageIcon("GameGuide.png"));
		gg.setBounds(560,50,362,79);
		background.add(gg);
		//mmbutton
		exit=new JButton(new ImageIcon("Exit.png"));
		exit.setBounds(1200,650,291,79);
		exit.setBackground(Color.BLACK);
		background.add(exit);
		//exit

		back=new JButton(new ImageIcon("backbtn.png"));
		back.setBounds(0,0,100,100);
		back.setBackground(Color.BLACK);
		background.add(back);

		av1=new JButton(new ImageIcon("IMbtn.png"));
		av1.setBounds(150,200,444,79);
		av1.setBackground(Color.BLACK);
		background.add(av1);

		av2=new JButton(new ImageIcon("Hbtn.png"));
		av2.setBounds(900,200,444,79);
		av2.setBackground(Color.BLACK);
		background.add(av2);

		av3=new JButton(new ImageIcon("Tbtn.png"));
		av3.setBounds(150,350,444,79);
		av3.setBackground(Color.BLACK);
		background.add(av3);

		av4=new JButton(new ImageIcon("CAbtn.png"));
		av4.setBounds(900,350,444,79);
		av4.setBackground(Color.BLACK);
		background.add(av4);

		v1=new JButton(new ImageIcon("Thanosbtn.png"));
		v1.setBounds(150,500,444,79);
		v1.setBackground(Color.BLACK);
		background.add(v1);

		v2=new JButton(new ImageIcon("Lokibtn.png"));
		v2.setBounds(900,500,444,79);
		v2.setBackground(Color.BLACK);
		background.add(v2);

		//all actions
		av1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				GameGuide.decider=1;
				Description d=new Description();
				d.guideDecider(GameGuide.decider);
				d.setVisible(true);
				setVisible(false);
			}
		});
		av2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				GameGuide.decider=2;
				Description d=new Description();
				d.guideDecider(GameGuide.decider);
				d.setVisible(true);
				setVisible(false);
			}
		});
		av3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				GameGuide.decider=3;
				Description d=new Description();
				d.guideDecider(GameGuide.decider);
				d.setVisible(true);
				setVisible(false);
			}
		});
		av4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				GameGuide.decider=4;
				Description d=new Description();
				d.guideDecider(GameGuide.decider);
				d.setVisible(true);
				setVisible(false);
			}
		});
		v1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				GameGuide.decider=5;
				Description d=new Description();
				d.guideDecider(GameGuide.decider);
				d.setVisible(true);
				setVisible(false);
			}
		});
		v2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				GameGuide.decider=6;
				Description d=new Description();
				d.guideDecider(GameGuide.decider);
				d.setVisible(true);
				setVisible(false);
			}
		});
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
	public static void main(String args[])
	{
		GameGuide g=new GameGuide();
	}
}