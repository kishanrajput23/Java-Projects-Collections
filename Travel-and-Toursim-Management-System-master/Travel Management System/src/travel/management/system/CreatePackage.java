/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;

/**
 *
 * @author Prity
 */
class CreatePackage extends JFrame implements ActionListener{
 
    private Container c;
    private JLabel label,pid,pname,date,cost;
    private Font f;
    private JTextField tid,tname,tdate,tcost;
    private JButton back,log,save;
   //   private String UserName,Password,Status;
 
   
  
    CreatePackage() {
           initcomponents();
        
    }
    public void initcomponents()
    {
        c=this.getContentPane();
        c.setLayout(null);
        
    this.setTitle("Package Pane");
    this.setSize(400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    f=new Font("",Font.BOLD,20);
    label=new JLabel("Create Package");
    label.setBounds(150, 20, 200, 30);
    label.setFont(f);
    label.setForeground(Color.black);
    c.add(label);
    
    pid=new JLabel("PackageId");
    pid.setBounds(20, 70, 100, 30);
    c.add(pid);
    
    pname=new JLabel("PackageName");
    pname.setBounds(20, 120, 100, 30);
    c.add(pname);
    
    date=new JLabel("Date");
    date.setBounds(20, 170, 100, 30);
    c.add(date);
    
    cost=new JLabel("Cost");
    cost.setBounds(20, 220, 100, 30);
    c.add(cost);
    
    tid=new JTextField();
    tid.setBounds(120, 70, 100, 30);
    c.add(tid);
    
    tname=new JTextField();
    tname.setBounds(120, 120, 100, 30);
    c.add(tname);
    
   tdate=new JTextField();
    tdate.setBounds(120, 170, 100, 30);
    c.add(tdate); 
    
    tcost=new JTextField();
    tcost.setBounds(120, 220, 100, 30);
    c.add(tcost);
    
    back=new JButton("Main Menu");
    back.setBounds(20, 300, 100, 50);
    back.addActionListener(this);
    c.add(back);
    
    log=new JButton("Log Out");
    log.setBounds(200, 300, 100, 50);
    log.addActionListener(this);
    c.add(log);
    
    save=new JButton("Save");
    save.setBounds(230, 160, 120, 50);
    save.addActionListener(this);
    c.add(save);
    
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       String clickbutton=e.getActionCommand();
       
       if(clickbutton.equals(log.getText()))
       {
       Login l=new Login();
       l.setVisible(true);
       this.setVisible(false);
       }
       else if(clickbutton.equals(back.getText()))
       {
        //AdminHome ad=new AdminHome();
        //ad.setVisible(true);
        this.setVisible(false);
       }
       else if(clickbutton.equals(save.getText()))
       {
       createDB();
       JOptionPane.showMessageDialog(null,"New Package Saved");
       }
       else{}
    }
    
    public void createDB()
    {
    String query="INSERT INTO `package` VALUES('"+tid.getText()+"','"+tname.getText()+"','"+tdate.getText()+"','"+tcost.getText()+"')";
    System.out.println(query);
    Connection con=null;
    Statement st=null;
    
    try{
    
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
        System.out.println("Connection Established");
        st=con.createStatement();
        System.out.println("Statement Created");
        st.execute(query);
        
    }catch(Exception e)
    {
    System.out.println(e);
    }
    
    finally{
    try{
    if(con!=null)
    {
    con.close();
     System.out.println("Connection Closed");
    }
    
    if(st!=null)
    {
    st.close();
     System.out.println("Statement Closed");
    }
    
    }catch(Exception e)
    {
     System.out.println(e);
    }
    }
    }
    
    public static void main(String[] args){
        new CreatePackage().setVisible(true);
    }
    
}