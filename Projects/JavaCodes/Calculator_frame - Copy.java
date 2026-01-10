import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class Calculator_frame extends Frame implements ActionListener
{
	TextField tf;
        Label l1,l2;
	Button b1, b2, b3, b4, b5, b6, b7,b8, b9, b0, bA, bM, c, eq, bD, bS;
	String s = "";
	
	public Calculator_frame() {
                l1=new Label("Calculator X");
                l1.setBounds(100,30,100,30);
                l1.setFont(new Font("Verdana", Font.BOLD, 15));
		tf = new TextField();
		setSize(300,350);
		
		tf.setBounds(10, 60, 200, 30);
		tf.setText("0");
		tf.setEditable(false);
		
		b9 = new Button("9");
		b9.setBounds(10,90, 40, 40);
		b9.setActionCommand("b9");
		b9.addActionListener(this);
		b9.setBackground(Color.LIGHT_GRAY);
		
		b8 = new Button("8");
		b8.setBounds(50,90, 40, 40);
		b8.setActionCommand("b8");
		b8.addActionListener(this);
		
		b7 = new Button("7");
		b7.setBounds(90,90, 40, 40);
		b7.setActionCommand("b7");
		b7.addActionListener(this);
		
		b6 = new Button("6");
		b6.setBounds(10,130, 40, 40);
		b6.setActionCommand("b6");
		b6.addActionListener(this);
		
		b5 = new Button("5");
		b5.setBounds(50,130, 40, 40);
		b5.setActionCommand("b5");
		b5.addActionListener(this);
		
		b4 = new Button("4");
		b4.setBounds(90,130, 40, 40);
		b4.setActionCommand("b4");
		b4.addActionListener(this);
		
		b3 = new Button("3");
		b3.setBounds(10,170, 40, 40);
		b3.setActionCommand("b3");
		b3.addActionListener(this);
		
		b2 = new Button("2");
		b2.setBounds(50,170, 40, 40);
		b2.setActionCommand("b2");
		b2.addActionListener(this);
		
		b1 = new Button("1");
		b1.setBounds(90,170, 40, 40);
		b1.setActionCommand("b1");
		b1.addActionListener(this);
		
		b0 = new Button("0");
		b0.setBounds(10,210, 40, 40);
		b0.setActionCommand("b0");
		b0.addActionListener(this);
		
		eq = new Button("=");
		eq.setBounds(50,210, 80, 40);
		eq.setActionCommand("eq");
		eq.addActionListener(this);
		
		c = new Button("C");
		c.setBounds(130,90, 80, 40);
		c.setActionCommand("c");
		c.addActionListener(this);
		
		bA = new Button("+");
		bA.setBounds(130,130, 40, 40);
		bA.setActionCommand("bA");
		bA.addActionListener(this);
		
		bS = new Button("-");
		bS.setBounds(170,130, 40, 40);
		bS.setActionCommand("bS");
		bS.addActionListener(this);
		
		bM = new Button("X");
		bM.setBounds(130,170, 40, 40);
		bM.setActionCommand("bM");
		bM.addActionListener(this);
		
		bD = new Button("/");
		bD.setBounds(170,170, 40, 40);
		bD.setActionCommand("bD");
		bD.addActionListener(this);
                l2=new Label("Made By: Rajesh");
                l2.setBounds(10,250,250,40);
		add(l1);add(tf);add(b9);add(b8);add(b7);add(b6);add(b5);add(b4);add(b3);add(b2);add(b1);add(b0);add(eq);
		add(c);add(bA);add(bS);add(bM);add(bD);add(l2);
		
		addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
			public void windowClosing(WindowEvent e) { dispose();}
			public void windowClosed(WindowEvent e) {}
			public void windowActivated(WindowEvent e) {}
		});
		
		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				switch(c)
				{
				case '1': s=s.concat("1");tf.setText(s);
				break;
				}
			}
			public void keyReleased(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
			
		});
		setLayout(null);
		setVisible(true);
		
	}
	public int calcString(String a){
		String operators[]=a.split("[0-9]+");
    String operands[]=a.split("\\+|\\-|x|\\/",0);
	
	/*StringBuffer sb = new StringBuffer();
      for(int i = 0; i < operands.length; i++) {
         sb.append(operands[i]);
      }
      String str = sb.toString();
      System.out.println(str);*/
	
    int agregate = Integer.parseInt(operands[0]);
    for(int i=1;i<operands.length;i++){
        if(operators[i].equals("+"))
            agregate += Integer.parseInt(operands[i]);
		if(operators[i].equals("-"))
            agregate -= Integer.parseInt(operands[i]);
		if(operators[i].equals("x"))
            agregate *= Integer.parseInt(operands[i]);
        if(operators[i].equals("/"))
            agregate /= Integer.parseInt(operands[i]);
    }
	return agregate;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String c=e.getActionCommand();
		switch(c)
		{
			case "b0" :s=s.concat("0");tf.setText(s);
			break;
			case "b1" :s=s.concat("1");tf.setText(s);
			break;
			case "b2" :s=s.concat("2");tf.setText(s);
			break;
			case "b3" : s+="3";tf.setText(s);
			break;
			case "b4" : s=s.concat("4");tf.setText(s);
			break;
			case "b5" : s=s.concat("5");tf.setText(s);
			break;
			case "b6" : s=s.concat("6");tf.setText(s);
			break;
			case "b7" : s=s.concat("7");tf.setText(s);
			break;
			case "b8" : s=s.concat("8");tf.setText(s);
			break;
			case "b9" : s=s.concat("9");tf.setText(s);
			break;
			case "c" :  tf.setText("0");s=new String("");
			break;
			case "eq" : s=Integer.toString(calcString(s));tf.setText(s);s=new String("");
			break;
			case "bA" : s=s.concat("+");tf.setText(s);
			break;
			case "bS" : s=s.concat("-");tf.setText(s);
			break;
			case "bD" : s=s.concat("/");tf.setText(s);
			break;
			case "bM" : s=s.concat("x");tf.setText(s);
		}
			
	}
	public static void main(String[] args)
	{
		new Calculator_frame();
	}

}
