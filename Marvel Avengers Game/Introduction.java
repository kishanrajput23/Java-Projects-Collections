import java.awt.*;  
import javax.swing.JFrame;  
import java.awt.event.*;
import javax.swing.*;

class Introduction extends JFrame
{  
	Introduction()
	{	
		JLabel background;
		JButton play;
		setSize(1570,840);
		setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon img=new ImageIcon("BackGround.jpg");
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,1570,770);
		add(background);
		play=new JButton(new ImageIcon("PlayGame.png"));
		play.setBounds(200,500,361,79);
		play.setBackground(Color.BLACK);
		background.add(play);
		play.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
				MainMenu m=new MainMenu();
			}
		});
		setVisible(true);
	}
    public static void main(String[] args) 
    {  
        Introduction i=new Introduction();
    }  
}  
