import java.awt.*;  
import javax.swing.JFrame;  
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class Fight extends JFrame  
{
	JLabel ac,vc,background,avgimg,villimg,fghtnm,versus,logo;
	JLabel result,resulticon,points,resultgreet;
	JButton bav1,bav2,bav3,bav4,bv1,bv2,exit,back;
	JButton a1,a2,a3,a4,v1,v2,v3,v4;
	JProgressBar healtha,healthv;
	JPanel ahpanel,vhpanel;
	String fightname,avgname,villname,resulttxt,rtxt1,rtxt2;
	int hpa,hpv,deathflag=1,ohpv;
	public int choosea,choosev;
	Fight()
	{
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
		ac=new JLabel(new ImageIcon("ac.png"));
		ac.setBounds(620,50,343,79);
		background.add(ac);

		vc=new JLabel(new ImageIcon("vc.png"));
		vc.setBounds(620,50,343,79);
		background.add(vc);
		vc.setVisible(false);

		//mmbutton
		bav1=new JButton(new ImageIcon("IMbtn.png"));
		bav1.setBounds(150,250,444,79);
		bav1.setBackground(Color.BLACK);
		background.add(bav1);

		bav2=new JButton(new ImageIcon("Hbtn.png"));
		bav2.setBounds(995,250,444,79);
		bav2.setBackground(Color.BLACK);
		background.add(bav2);

		bav3=new JButton(new ImageIcon("Tbtn.png"));
		bav3.setBounds(150,500,444,79);
		bav3.setBackground(Color.BLACK);
		background.add(bav3);	

		bav4=new JButton(new ImageIcon("CAbtn.png"));
		bav4.setBounds(995,500,444,79);
		bav4.setBackground(Color.BLACK);
		background.add(bav4);


		bv1=new JButton(new ImageIcon("Thanosbtn.png"));
		bv1.setBounds(150,350,445,79);
		bv1.setBackground(Color.BLACK);
		background.add(bv1);
		bv1.setVisible(false);

		bv2=new JButton(new ImageIcon("Lokibtn.png"));
		bv2.setBounds(950,350,444,79);
		bv2.setBackground(Color.BLACK);
		background.add(bv2);
		bv2.setVisible(false);

		exit=new JButton(new ImageIcon("Exit.png"));
		exit.setBounds(1200,650,291,79);
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
				MainMenu m=new MainMenu();
			}
		});
		bav1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				choosea=1;
				panel1close();
			}
		});
		bav2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				choosea=2;
				panel1close();
			}
		});
		bav3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				choosea=3;
				panel1close();
			}
		});
		bav4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				choosea=4;
				panel1close();
			}
		});
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				panel1close();
				setVisible(false);
				System.out.println("Game Ended");
				System.exit(0);
			}
		});
		setVisible(true);
	}

	public void panel1close()
	{
		bav1.setVisible(false);
		bav2.setVisible(false);
		bav3.setVisible(false);
		bav4.setVisible(false);
		ac.setVisible(false);
		panel2open();
	}

	public void panel2open()
	{
		bv1.setVisible(true);
		bv2.setVisible(true);
		vc.setVisible(true);
		panel2Listeners();
	}

	public void panel2Listeners()
	{
		bv1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				choosev=5;
				panel2close();
			}
		});	
		bv2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				choosev=6;
				panel2close();
			}
		});	
	}

	public void panel2close()
	{
		bv1.setVisible(false);
		bv2.setVisible(false);
		vc.setVisible(false);
		exit.setVisible(false);
		setmainFight();
	}

	public void setmainFight()
	{
		if(choosea==1)
		{
			hpa=440;
			fightname="IRON MAN v/s ";
			avgname="IRON MAN";
			avgimg=new JLabel(new ImageIcon("IMimage.png"));
			avgimg.setBounds(300,150,300,336);
			background.add(avgimg);

			a1=new JButton(new ImageIcon("IMa1.png"));
			a1.setBounds(150,525,444,93);
			a1.setBackground(Color.BLACK);
			background.add(a1);	

			a2=new JButton(new ImageIcon("IMa2.png"));
			a2.setBounds(950,525,444,93);
			a2.setBackground(Color.BLACK);
			background.add(a2);	

			a3=new JButton(new ImageIcon("IMa3.png"));
			a3.setBounds(150,650,444,93);
			a3.setBackground(Color.BLACK);
			background.add(a3);	

			a4=new JButton(new ImageIcon("IMa4.png"));
			a4.setBounds(950,650,444,93);
			a4.setBackground(Color.BLACK);
			background.add(a4);		
		}
		else if(choosea==2)
		{
			hpa=600;
			fightname="HULK v/s ";
			avgname="HULK";
			avgimg=new JLabel(new ImageIcon("Himage.png"));
			avgimg.setBounds(300,150,300,336);
			background.add(avgimg);

			a1=new JButton(new ImageIcon("Ha1.png"));
			a1.setBounds(150,525,444,93);
			a1.setBackground(Color.BLACK);
			background.add(a1);	

			a2=new JButton(new ImageIcon("Ha2.png"));
			a2.setBounds(950,525,444,93);
			a2.setBackground(Color.BLACK);
			background.add(a2);	

			a3=new JButton(new ImageIcon("Ha3.png"));
			a3.setBounds(150,650,444,93);
			a3.setBackground(Color.BLACK);
			background.add(a3);	

			a4=new JButton(new ImageIcon("Ha4.png"));
			a4.setBounds(950,650,444,93);
			a4.setBackground(Color.BLACK);
			background.add(a4);	
		}
		else if(choosea==3)
		{
			hpa=400;
			fightname="THOR v/s ";
			avgname="THOR";
			avgimg=new JLabel(new ImageIcon("Timage.png"));
			avgimg.setBounds(300,150,300,336);
			background.add(avgimg);

			a1=new JButton(new ImageIcon("Ta1.png"));
			a1.setBounds(150,525,444,93);
			a1.setBackground(Color.BLACK);
			background.add(a1);	

			a2=new JButton(new ImageIcon("Ta2.png"));
			a2.setBounds(950,525,444,93);
			a2.setBackground(Color.BLACK);
			background.add(a2);	

			a3=new JButton(new ImageIcon("Ta3.png"));
			a3.setBounds(150,650,444,93);
			a3.setBackground(Color.BLACK);
			background.add(a3);	

			a4=new JButton(new ImageIcon("Ta4.png"));
			a4.setBounds(950,650,444,93);
			a4.setBackground(Color.BLACK);
			background.add(a4);	
		}
		else if(choosea==4)
		{
			hpa=520;
			fightname="CAPTAIN AMERICA v/s ";
			avgname="CAPTAIN AMERICA";
			avgimg=new JLabel(new ImageIcon("CAimage.png"));
			avgimg.setBounds(300,150,300,336);
			background.add(avgimg);

			a1=new JButton(new ImageIcon("CAa1.png"));
			a1.setBounds(150,525,444,93);
			a1.setBackground(Color.BLACK);
			background.add(a1);	

			a2=new JButton(new ImageIcon("CAa2.png"));
			a2.setBounds(950,525,444,93);
			a2.setBackground(Color.BLACK);
			background.add(a2);	

			a3=new JButton(new ImageIcon("CAa3.png"));
			a3.setBounds(150,650,444,93);
			a3.setBackground(Color.BLACK);
			background.add(a3);	

			a4=new JButton(new ImageIcon("CAa4.png"));
			a4.setBounds(950,650,444,93);
			a4.setBackground(Color.BLACK);
			background.add(a4);	
		}
		//
		if(choosev==5)
		{
			ohpv=960;
			hpv=960;
			fightname=fightname+"THANOS";
			villname="THANOS";
			villimg=new JLabel(new ImageIcon("Thimage.png"));
			villimg.setBounds(950,120,300,412);
			background.add(villimg);
		}
		else if(choosev==6)
		{
			ohpv=480;
			hpv=480;
			fightname=fightname+"LOKI";
			villname="LOKI";
			villimg=new JLabel(new ImageIcon("Limage.png"));
			villimg.setBounds(950,100,300,412);
			background.add(villimg);
		}

		fghtnm=new JLabel(fightname,JLabel.CENTER);
		fghtnm.setBounds(0,25,1560,79);
		fghtnm.setForeground(Color.yellow);
		fghtnm.setFont(new Font("Verdana", Font.PLAIN, 40));
		//fghtnm.setSize(300,300);
		background.add(fghtnm);
		System.out.println(fightname);

		//health bars
		ahpanel=new JPanel();
		ahpanel.setBounds(200,150,30,300);
		ahpanel.setBackground(Color.white);
		background.add(ahpanel);
		mainFightBtnListeners();

		vhpanel=new JPanel();
		vhpanel.setBounds(1350,150,30,300);
		vhpanel.setBackground(Color.white);
		background.add(vhpanel);

		healtha=new JProgressBar(JProgressBar.VERTICAL,0,hpa);
		healtha.setPreferredSize(new Dimension(30,300));
		healtha.setStringPainted(true);
		healtha.setForeground(Color.green);
		healtha.setValue(hpa);
		ahpanel.add(healtha);

		healthv=new JProgressBar(JProgressBar.VERTICAL,0,hpv);
		healthv.setPreferredSize(new Dimension(30,300));
		healtha.setStringPainted(true);
		healthv.setForeground(Color.green);
		healthv.setValue(hpv);
		vhpanel.add(healthv);

		versus=new JLabel(new ImageIcon("Versus.png"),JLabel.CENTER);
		versus.setBounds(0,100,1560,400);
		background.add(versus);

		logo=new JLabel(new ImageIcon("alogo.png"));
		logo.setBounds(675,500,214,236);
		background.add(logo);

		mainFightBtnListeners();
	}

	public void mainFightBtnListeners()
	{
		if(choosea==1)
		{
			a1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					hpv=hpv-80;
					healthv.setValue(hpv);
					if(choosev==5)
					{
						hpa=hpa-30;
					}
					else if(choosev==6)
					{
						hpa=hpa-50;
					}
					healtha.setValue(hpa);
					deathCheck();
				}
			});	
			a2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					hpv=hpv-60;
					healthv.setValue(hpv);
					if(choosev==5)
					{
						hpa=hpa-10;
					}
					else if(choosev==6)
					{
						hpa=hpa-30;
					}
					healtha.setValue(hpa);
					deathCheck();
				}
			});	
			a3.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					hpv=hpv-40;
					healthv.setValue(hpv);
					if(choosev==5)
					{
						hpa=hpa-20;
					}
					else if(choosev==6)
					{
						hpa=hpa-20;
					}
					healtha.setValue(hpa);
					deathCheck();
				}
			});	
			a4.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					hpv=hpv-20;
					healthv.setValue(hpv);
					if(choosev==5)
					{
						hpa=hpa-15;
					}
					else if(choosev==6)
					{
						hpa=hpa-35;
					}
					healtha.setValue(hpa);
					deathCheck();
				}
			});	
		}
		else if(choosea==2)
		{
			a1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					hpv=hpv-20;
					healthv.setValue(hpv);
					if(choosev==5)
					{
						hpa=hpa-30;
					}
					else if(choosev==6)
					{
						hpa=hpa-50;
					}
					healtha.setValue(hpa);
					deathCheck();
				}
			});	
			a2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					hpv=hpv-80;
					healthv.setValue(hpv);
					if(choosev==5)
					{
						hpa=hpa-10;
					}
					else if(choosev==6)
					{
						hpa=hpa-30;
					}
					healtha.setValue(hpa);
					deathCheck();
				}
			});	
			a3.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					hpv=hpv-40;
					healthv.setValue(hpv);
					if(choosev==5)
					{
						hpa=hpa-20;
					}
					else if(choosev==6)
					{
						hpa=hpa-20;
					}
					healtha.setValue(hpa);
					deathCheck();
				}
			});	
			a4.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					hpv=hpv-60;
					healthv.setValue(hpv);
					if(choosev==5)
					{
						hpa=hpa-15;
					}
					else if(choosev==6)
					{
						hpa=hpa-35;
					}
					healtha.setValue(hpa);
					deathCheck();
				}
			});	
		}
		else if(choosea==3)
		{
			a1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					hpv=hpv-60;
					healthv.setValue(hpv);
					if(choosev==5)
					{
						hpa=hpa-30;
					}
					else if(choosev==6)
					{
						hpa=hpa-50;
					}
					healtha.setValue(hpa);
					deathCheck();
				}
			});	
			a2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					hpv=hpv-80;
					healthv.setValue(hpv);
					if(choosev==5)
					{
						hpa=hpa-10;
					}
					else if(choosev==6)
					{
						hpa=hpa-30;
					}
					healtha.setValue(hpa);
					deathCheck();
				}
			});	
			a3.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					hpv=hpv-20;
					healthv.setValue(hpv);
					if(choosev==5)
					{
						hpa=hpa-20;
					}
					else if(choosev==6)
					{
						hpa=hpa-20;
					}
					healtha.setValue(hpa);
					deathCheck();
				}
			});	
			a4.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					hpv=hpv-40;
					healthv.setValue(hpv);
					if(choosev==5)
					{
						hpa=hpa-15;
					}
					else if(choosev==6)
					{
						hpa=hpa-35;
					}
					healtha.setValue(hpa);
					deathCheck();
				}
			});	
		}
		else if(choosea==4)
		{
			a1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					hpv=hpv-80;
					healthv.setValue(hpv);
					if(choosev==5)
					{
						hpa=hpa-30;
					}
					else if(choosev==6)
					{
						hpa=hpa-50;
					}
					healtha.setValue(hpa);
					deathCheck();
				}
			});	
			a2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					hpv=hpv-40;
					healthv.setValue(hpv);
					if(choosev==5)
					{
						hpa=hpa-10;
					}
					else if(choosev==6)
					{
						hpa=hpa-30;
					}
					healtha.setValue(hpa);
					deathCheck();
				}
			});	
			a3.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					hpv=hpv-20;
					healthv.setValue(hpv);
					if(choosev==5)
					{
						hpa=hpa-20;
					}
					else if(choosev==6)
					{
						hpa=hpa-20;
					}
					healtha.setValue(hpa);
					deathCheck();
				}
			});	
			a4.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					hpv=hpv-60;
					healthv.setValue(hpv);
					if(choosev==5)
					{
						hpa=hpa-15;
					}
					else if(choosev==6)
					{
						hpa=hpa-35;
					}
					healtha.setValue(hpa);
					deathCheck();
				}
			});	
		}
	}
	public void deathCheck()
	{
		if(hpa<0&&hpv<0)
		{
			resulttxt=avgname+" and "+villname+" Killed Each Other";
			rtxt1="It's A Tie";
			rtxt2="Points Scored  : "+ohpv;
			mainFightPanelClose();
		}
		else if(hpa<=0&&hpv>0)
		{
			resulttxt=villname+" Killed "+avgname;
			rtxt1="Sorry You Lost!!!";
			rtxt2="Points Scored : 0";	
			mainFightPanelClose();
		}
		else if(hpv<=0&&hpa>0)
		{
			resulttxt=avgname+" Killed "+villname;
			rtxt1="Congratulations You Won!!!";
			rtxt2="Points Scored : "+ohpv;	
			mainFightPanelClose();
		}
	}
	public void mainFightPanelClose()
	{
		avgimg.setVisible(false);
		villimg.setVisible(false);
		a1.setVisible(false);
		a2.setVisible(false);
		a3.setVisible(false);
		a4.setVisible(false);
		fghtnm.setVisible(false);
		vhpanel.setVisible(false);
		ahpanel.setVisible(false);
		versus.setVisible(false);
		logo.setVisible(false);

		resultScreen();
	}
	public void resultScreen()
	{
		exit.setVisible(true);
		resulticon=new JLabel(new ImageIcon("Result.png"));
		resulticon.setBounds(620,50,287,74);
		background.add(resulticon);

		result=new JLabel(resulttxt,JLabel.CENTER);
		result.setBounds(0,200,1560,79);
		result.setForeground(Color.yellow);
		result.setFont(new Font("Verdana", Font.PLAIN, 40));
		background.add(result);

		resultgreet=new JLabel(rtxt1,JLabel.CENTER);
		resultgreet.setBounds(0,300,1560,79);
		resultgreet.setForeground(Color.yellow);
		resultgreet.setFont(new Font("Verdana", Font.PLAIN, 40));
		background.add(resultgreet);

		points=new JLabel(rtxt2,JLabel.CENTER);
		points.setBounds(0,400,1560,79);
		points.setForeground(Color.yellow);
		points.setFont(new Font("Verdana", Font.PLAIN, 40));
		background.add(points);

		try
		{
			String fileresult=fightname+"\t\t\t"+resulttxt+"\t\t\t"+rtxt2+"\n";
			char rtext[]=fileresult.toCharArray();
			FileWriter f1 = new FileWriter("(((((Battle Log.txt",true);
			f1.write(rtext);
			f1.close();
		}
		catch(IOException io)
		{
			System.out.println("IOException caught");
		}
	}

	public static void main (String args[])
	{
		Fight f=new Fight();
	}
}