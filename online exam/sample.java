import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class sample extends Frame implements WindowListener,ActionListener
{
public void windowActivated(WindowEvent e) {  }
public void windowDeactivated(WindowEvent e) {  }
public void windowIconified(WindowEvent e) {  }
public void windowDeiconified(WindowEvent e) {  }
public void windowClosing(WindowEvent e) {   System.exit(0); }
public void windowClosed(WindowEvent e) {  }
public void windowOpened(WindowEvent e) {  }
TextArea t1;
Checkbox c1,c2,c3;
CheckboxGroup g;
Button b1,b2;
Connection c;
Statement s;
ResultSet rs;
int i=0;
int marks=0;
int j=0;

public static void main(String args[]) throws Exception 
{
sample s= new sample();	// Create a new frame 



}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()== b2)		// Start
{
try{
rs.next();
t1.setText(rs.getString(1));
c1.setLabel(rs.getString(2));
c2.setLabel(rs.getString(3));
c3.setLabel(rs.getString(4));
}catch(Exception e) { System.out.println(e); } 
}
if(ae.getSource()== b1)		// Submit
{
try{
t1.setText(rs.getString(1));
c1.setLabel(rs.getString(2));
c2.setLabel(rs.getString(3));
c3.setLabel(rs.getString(4));
if(c1.getState()==true)  j=1;
if(c2.getState()==true)  j=2;
if(c3.getState()==true)  j=3;
String ans=rs.getString(5);
int k=Integer.parseInt(ans);
if(j==k)
marks=marks+2;
else
marks=marks-1;
System.out.println("ANS IS " + k);
System.out.println("J IS " + j);
System.out.println(marks);
rs.next();
}catch(Exception e) { System.out.println(e); } 




}


}
sample()
{
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
c= DriverManager.getConnection( "jdbc:odbc:abc","root","root");
s=c.createStatement();
rs= s.executeQuery("select * from exam");
}catch(Exception e) { System.out.println(e); }
b1= new Button("Submit");
b2= new Button("Start");
b1.addActionListener(this);
b2.addActionListener(this);
t1= new TextArea(100,100);
g= new CheckboxGroup();
c1= new Checkbox("Option1",g, true);
c2= new Checkbox("Option2",g, false);
c3= new Checkbox("Option3",g, false);
add(t1);
add(c1);
add(c2);
add(c3);
add(b1);
add(b2);

setLayout( new GridLayout(4,4));
addWindowListener(this);
setVisible(true);
setSize(400,400);
setLocation(0,0);
}



}


 