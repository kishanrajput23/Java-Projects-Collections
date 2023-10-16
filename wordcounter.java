import java.awt.event.*;  
import javax.swing.*;  
public class WCC extends JFrame implements ActionListener{  
JTextArea ta;  
JButton b1,b2;  
WCC(){  
    super("Word Character Counter - JavaTpoint");  
    ta=new JTextArea();  
    ta.setBounds(50,50,300,200);  
      
    b1=new JButton("Word");  
    b1.setBounds(50,300,100,30);  
      
    b2=new JButton("Character");  
    b2.setBounds(180,300,100,30);  
      
    b1.addActionListener(this);  
    b2.addActionListener(this);  
    add(b1);add(b2);add(ta);  
    setSize(400,400);  
    setLayout(null);  
    setVisible(true);  
}  
public void actionPerformed(ActionEvent e){  
    String text=ta.getText();  
    if(e.getSource()==b1){  
        String words[]=text.split("\\s");  
        JOptionPane.showMessageDialog(this,"Total words: "+words.length);  
    }  
    if(e.getSource()==b2){  
        JOptionPane.showMessageDialog(this,"Total Characters with space: "+text.length());  
    }  
}  
public static void main(String[] args) {  
    new WCC();  
}  
}  
Word Count Example with Pad and Text Color
import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;  
public class CharCount extends JFrame implements ActionListener{  
    JLabel lb1,lb2;  
    JTextArea ta;  
    JButton b;  
    JButton pad,text;  
    CharCount(){  
        super("Char Word Count Tool - JTP");  
        lb1=new JLabel("Characters: ");  
        lb1.setBounds(50,50,100,20);  
        lb2=new JLabel("Words: ");  
        lb2.setBounds(50,80,100,20);  
          
        ta=new JTextArea();  
        ta.setBounds(50,110,300,200);  
          
        b=new JButton("click");  
        b.setBounds(50,320, 80,30);//x,y,w,h  
        b.addActionListener(this);  
      
        pad=new JButton("Pad Color");  
        pad.setBounds(140,320, 110,30);//x,y,w,h  
        pad.addActionListener(this);  
  
        text=new JButton("Text Color");  
        text.setBounds(260,320, 110,30);//x,y,w,h  
        text.addActionListener(this);  
  
        add(lb1);add(lb2);add(ta);add(b);add(pad);add(text);  
          
        setSize(400,400);  
        setLayout(null);//using no layout manager  
        setVisible(true);  
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
    }  
    public void actionPerformed(ActionEvent e){  
        if(e.getSource()==b){  
        String text=ta.getText();  
        lb1.setText("Characters: "+text.length());  
        String words[]=text.split("\\s");  
        lb2.setText("Words: "+words.length);  
        }else if(e.getSource()==pad){  
            Color c=JColorChooser.showDialog(this,"Choose Color",Color.BLACK);  
            ta.setBackground(c);  
        }else if(e.getSource()==text){  
            Color c=JColorChooser.showDialog(this,"Choose Color",Color.BLACK);  
            ta.setForeground(c);  
        }  
    }  
public static void main(String[] args) {  
    new CharCount();  
}}  
