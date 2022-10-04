import java.awt.*;  
import javax.swing.JFrame;  
import java.awt.event.*;
import javax.swing.*;

class Description extends JFrame
{
	int no,flag=0;
	JLabel title,dtxt1,dtxt2,dtxt3,dtxt4,dtxt5,dtxt6,img;

	public void guideDecider(int d)
	{
		no=d;
		if(no==1)
		{
			title=new JLabel(new ImageIcon("IMbtn.png"));
			title.setBounds(540,50,444,79);
			add(title);

			img=new JLabel(new ImageIcon("IMimage.png"));
			img.setBounds(1000,232,300,336);
			add(img);

			dtxt1=new JLabel(new ImageIcon("IM1.png"));
			dtxt1.setBounds(100,150,512,73);
			add(dtxt1);

			dtxt2=new JLabel(new ImageIcon("IM2.png"));
			dtxt2.setBounds(100,250,373,73);
			add(dtxt2);

			dtxt3=new JLabel(new ImageIcon("IM3.png"));
			dtxt3.setBounds(100,350,586,73);
			add(dtxt3);

			dtxt4=new JLabel(new ImageIcon("IM4.png"));
			dtxt4.setBounds(100,450,623,73);
			add(dtxt4);

			dtxt5=new JLabel(new ImageIcon("IM5.png"));
			dtxt5.setBounds(100,550,776,73);
			add(dtxt5);

			dtxt6=new JLabel(new ImageIcon("IM6.png"));
			dtxt6.setBounds(100,650,674,73);
			add(dtxt6);
		}
		else if(no==2)
		{
			title=new JLabel(new ImageIcon("Hbtn.png"));
			title.setBounds(540,50,444,79);
			add(title);
			title.setVisible(true);

			img=new JLabel(new ImageIcon("Himage.png"));
			img.setBounds(1000,232,300,336);
			add(img);
			img.setVisible(true);

			dtxt1=new JLabel(new ImageIcon("H1.png"));
			dtxt1.setBounds(100,150,438,73);
			add(dtxt1);

			dtxt2=new JLabel(new ImageIcon("H2.png"));
			dtxt2.setBounds(100,250,296,73);
			add(dtxt2);

			dtxt3=new JLabel(new ImageIcon("H3.png"));
			dtxt3.setBounds(100,350,607,73);
			add(dtxt3);

			dtxt4=new JLabel(new ImageIcon("H4.png"));
			dtxt4.setBounds(100,450,514,73);
			add(dtxt4);

			dtxt5=new JLabel(new ImageIcon("H5.png"));
			dtxt5.setBounds(100,550,680,73);
			add(dtxt5);

			dtxt6=new JLabel(new ImageIcon("H6.png"));
			dtxt6.setBounds(100,650,664,73);
			add(dtxt6);

		}
		else if(no==3)
		{
			title=new JLabel(new ImageIcon("Tbtn.png"));
			title.setBounds(540,50,444,79);
			add(title);
			title.setVisible(true);

			img=new JLabel(new ImageIcon("Timage.png"));
			img.setBounds(1000,178,300,444);
			add(img);
			img.setVisible(true);

			dtxt1=new JLabel(new ImageIcon("T1.png"));
			dtxt1.setBounds(100,150,448,73);
			add(dtxt1);

			dtxt2=new JLabel(new ImageIcon("T2.png"));
			dtxt2.setBounds(100,250,304,73);
			add(dtxt2);

			dtxt3=new JLabel(new ImageIcon("T3.png"));
			dtxt3.setBounds(100,350,747,73);
			add(dtxt3);

			dtxt4=new JLabel(new ImageIcon("T4.png"));
			dtxt4.setBounds(100,450,689,73);
			add(dtxt4);

			dtxt5=new JLabel(new ImageIcon("T5.png"));
			dtxt5.setBounds(100,550,659,73);
			add(dtxt5);

			dtxt6=new JLabel(new ImageIcon("T6.png"));
			dtxt6.setBounds(100,650,634,73);
			add(dtxt6);

		}
		else if(no==4)
		{
			title=new JLabel(new ImageIcon("CAbtn.png"));
			title.setBounds(540,50,444,79);
			add(title);
			title.setVisible(true);

			img=new JLabel(new ImageIcon("CAimage.png"));
			img.setBounds(1000,190,300,419);
			add(img);
			img.setVisible(true);

			dtxt1=new JLabel(new ImageIcon("CA1.png"));
			dtxt1.setBounds(100,150,680,73);
			add(dtxt1);

			dtxt2=new JLabel(new ImageIcon("CA2.png"));
			dtxt2.setBounds(100,250,539,73);
			add(dtxt2);

			dtxt3=new JLabel(new ImageIcon("CA3.png"));
			dtxt3.setBounds(100,350,598,73);
			add(dtxt3);

			dtxt4=new JLabel(new ImageIcon("CA4.png"));
			dtxt4.setBounds(100,450,670,73);
			add(dtxt4);

			dtxt5=new JLabel(new ImageIcon("CA5.png"));
			dtxt5.setBounds(100,550,600,73);
			add(dtxt5);

			dtxt6=new JLabel(new ImageIcon("CA6.png"));
			dtxt6.setBounds(100,650,602,73);
			add(dtxt6);

		}
		else if(no==5)
		{
			title=new JLabel(new ImageIcon("Thanosbtn.png"));
			title.setBounds(540,50,444,79);
			add(title);
			title.setVisible(true);

			img=new JLabel(new ImageIcon("Thimage.png"));
			img.setBounds(1000,194,300,412);
			add(img);
			img.setVisible(true);

			dtxt1=new JLabel(new ImageIcon("TH1.png"));
			dtxt1.setBounds(100,150,490,73);
			add(dtxt1);

			dtxt2=new JLabel(new ImageIcon("TH2.png"));
			dtxt2.setBounds(100,250,352,73);
			add(dtxt2);

			dtxt3=new JLabel(new ImageIcon("TH3.png"));
			dtxt3.setBounds(100,350,640,73);
			add(dtxt3);

			dtxt4=new JLabel(new ImageIcon("TH4.png"));
			dtxt4.setBounds(100,450,618,73);
			add(dtxt4);

			dtxt5=new JLabel(new ImageIcon("TH5.png"));
			dtxt5.setBounds(100,550,752,73);
			add(dtxt5);

			dtxt6=new JLabel(new ImageIcon("TH6.png"));
			dtxt6.setBounds(100,650,569,73);
			add(dtxt6);

		}
		else if(no==6)
		{
			title=new JLabel(new ImageIcon("Lokibtn.png"));
			title.setBounds(540,50,444,79);
			add(title);
			title.setVisible(true);

			img=new JLabel(new ImageIcon("Limage.png"));
			img.setBounds(1000,167,300,466);
			add(img);
			img.setVisible(true);

			dtxt1=new JLabel(new ImageIcon("L1.png"));
			dtxt1.setBounds(100,150,422,73);
			add(dtxt1);

			dtxt2=new JLabel(new ImageIcon("L2.png"));
			dtxt2.setBounds(100,250,282,73);
			add(dtxt2);

			dtxt3=new JLabel(new ImageIcon("L3.png"));
			dtxt3.setBounds(100,350,636,73);
			add(dtxt3);

			dtxt4=new JLabel(new ImageIcon("L4.png"));
			dtxt4.setBounds(100,450,535,73);
			add(dtxt4);

			dtxt5=new JLabel(new ImageIcon("L5.png"));
			dtxt5.setBounds(100,550,546,73);
			add(dtxt5);

			dtxt6=new JLabel(new ImageIcon("L6.png"));
			dtxt6.setBounds(100,650,595,73);
			add(dtxt6);

		}
	}

	Description()
	{
		JLabel title,background;
		JButton exit,back;
		//declaration
		setSize(1570,840);
		setLayout(null);
		//background image
		setContentPane(new JLabel(new ImageIcon("BImage.png")));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		back=new JButton(new ImageIcon("backbtn.png"));
		back.setBounds(0,0,100,100);
		back.setBackground(Color.BLACK);
		add(back);

		exit=new JButton(new ImageIcon("Exit.png"));
		exit.setBounds(1200,650,291,79);
		exit.setBackground(Color.BLACK);
		add(exit);

		//add elements
		

		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
				GameGuide g=new GameGuide();
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
	}

	public static void main(String args[])
	{
		//Description d=new Description();
	}
}