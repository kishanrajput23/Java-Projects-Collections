/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ViewTicket extends Frame implements ActionListener
{


	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
	Button b1,b2;
	Frame f;
public ViewTicket()
{

f=new Frame("Travel Management System - View Tickets");
f.setVisible(true);
f.setSize(410,600);
f.setLocation(440,20);
f.setLayout(null);

Label l1=new Label("Customer id");
l1.setBounds(50,50,150,30);
f.add(l1);

TextField t1=new TextField();
t1.setBounds(220,50,150,30);
f.add(t1);

Label l2=new Label("Customer Name");
l2.setBounds(50,90,150,30);
f.add(l2);

TextField t2=new TextField();
t2.setBounds(220,90,150,30);
f.add(t2);

Label l3=new Label("Destination");
l3.setBounds(50,130,150,30);
f.add(l3);

TextField t3=new TextField();
t3.setBounds(220,130,150,30);
f.add(t3);


Label l4=new Label("Flight Name");
l4.setBounds(50,170,150,30);
f.add(l4);

TextField t4=new TextField();
t4.setBounds(220,170,150,30);
f.add(t4);

Label l5=new Label("Price");
l5.setBounds(50,210,150,30);
f.add(l5);

TextField t5=new TextField();
t5.setBounds(220,210,150,30);
f.add(t5);

Label l6=new Label("Number of person");
l6.setBounds(50,250,150,30);
f.add(l6);

TextField t6=new TextField();
t6.setBounds(220,250,150,30);
f.add(t6);

Label l7=new Label("From Date");
l7.setBounds(50,290,150,30);
f.add(l7);

TextField t7=new TextField();
t7.setBounds(220,290,150,30);
f.add(t7);

Label l8=new Label("To Date");
l8.setBounds(50,330,150,30);
f.add(l8);

TextField t8=new TextField();
t8.setBounds(220,330,150,30);
f.add(t8);

Label l9=new Label("Total Price");
l9.setBounds(50,370,150,30);
f.add(l9);

TextField t9=new TextField();
t9.setBounds(220,370,150,30);
f.add(t9);

/*Label l10=new Label("Hotel Amount");
l10.setBounds(50,410,150,30);
f.add(l10);
TextField t10=new TextField();
t10.setBounds(220,410,150,30);
f.add(t10);
Label l11=new Label("Number of person");
l11.setBounds(50,450,120,30);
f.add(l11);
TextField t11=new TextField();
t11.setText("   1");
t11.setBounds(220,450,150,30);
f.add(t11);
Label l12=new Label("Total Price");
l12.setBounds(50,490,120,30);
f.add(l12);
TextField t12=new TextField();
t12.setBounds(220,490,150,30);
f.add(t12);
TextArea area=new TextArea("Welcome to javatpoint");
area.setBounds(50,530,320,120);
f.add(area);
*/
Button b1=new Button("First");
b1.setBounds(50,410,100,30);
f.add(b1);
b1.addActionListener(this);


Button b2=new Button("Next");
b2.setBounds(220,410,100,30);
f.add(b2);
b2.addActionListener(this);

Button b3=new Button("Previous");
b3.setBounds(50,450,100,30);
f.add(b3);
b3.addActionListener(this);


Button b4=new Button("Last");
b4.setBounds(220,450,100,30);
f.add(b4);
b4.addActionListener(this);

Button b5=new Button("Cancel");
b5.setBounds(140,490,100,30);
f.add(b5);
b5.addActionListener(this);






MenuBar mb=new MenuBar();
Menu p1=new Menu("Packages");
Menu p2=new Menu("Customer Information");
Menu p3=new Menu("Hotels");
Menu p4=new Menu("Tickets");
Menu p5=new Menu("Log Out");
p5.addActionListener(this);

MenuItem pcg1=new MenuItem("Add Package");
MenuItem pcg2=new MenuItem("View Package");
MenuItem pcg3=new MenuItem("Delete Package");
pcg1.addActionListener(this);
pcg2.addActionListener(this);
pcg3.addActionListener(this);


MenuItem cust1=new MenuItem("View Customer");
MenuItem cust2=new MenuItem("Delete Customer");
cust1.addActionListener(this);


MenuItem h1=new MenuItem("Book Hotels");
MenuItem h2=new MenuItem("View Bookings");
h1.addActionListener(this);
h2.addActionListener(this);


MenuItem tckt1=new MenuItem("Book Tickets");
MenuItem tckt2=new MenuItem("View Tickets");
tckt1.addActionListener(this);
tckt2.addActionListener(this);

p1.add(pcg1);
p1.add(pcg2);
p1.add(pcg3);

p2.add(cust1);
p2.add(cust2);


p3.add(h1);
p3.add(h2);

p4.add(tckt1);
p4.add(tckt2);

mb.add(p1);
mb.add(p2);
mb.add(p3);
mb.add(p4);
f.setMenuBar(mb);
f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
        {
                System.exit(0);
             }
        });
}

public void actionPerformed(ActionEvent ae)
{
//			String str=ae.getActionCommand();
//			if(str.equals("Add Package"))
//			{
//			Addpckg ap=new Addpckg();
//			f.setVisible(false);
//			}
//			else if(str.equals("View Package"))
//			{
//			Viewpckg vp=new Viewpckg();
//			f.setVisible(false);
//			}
//			else if(str.equals("Delete Package"))
//			{
//			Deletepckg dp=new Deletepckg();
//			f.setVisible(false);
//			}
//			else if(str.equals("Add Customer"))
//			{
//			Addcustomer ac=new Addcustomer();
//			f.setVisible(false);
//			}
//			else if(str.equals("View Customer"))
//			{
//			Viewcustomer vc=new Viewcustomer();
//			f.setVisible(false);
//			}
//			else if(str.equals("Delete Customer"))
//			{
//			Deletecustomer dc=new Deletecustomer();
//			f.setVisible(false);
//			}
//			else if(str.equals("Book Hotels"))
//			{
//			Bookhotels bh=new Bookhotels();
//			f.setVisible(false);
//			}
//			else if(str.equals("View Bookings"))
//			{
//			Viewhotels vh=new Viewhotels();
//			f.setVisible(false);
//			}
//			else if(str.equals("Book Tickets"))
//			{
//			Booktickets bt=new Booktickets();
//			f.setVisible(false);
//			}
//			/*else if(str.equals("View Tickets"))
//			{
//			Viewtickets vt=new Viewtickets();
//			f.setVisible(false);
//			}*/
//			else if(str.equals("Log Out"))
//			{
//			Login l=new Login();
//			f.setVisible(false);
//}
//else if(str.equals("First"))
//	{
//
//}
//else if(str.equals("Next"))
//	{
//
//}
//else if(str.equals("Previous"))
//	{
//
//}
//else if(str.equals("Last"))
//	{
//
//}
//else if(str.equals("Cancel"))
//{
//Home h=new Home();
//f.setVisible(false);
//}

}

public static void main(String args[])
{
ViewTicket vt=new ViewTicket();
}
}