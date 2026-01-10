import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;



public class eps {

  private JFrame frame;
  private JLabel z1;
  private JLabel y1;
  private JLabel y2;
  private JLabel y3;
  private JLabel y4;
  private JLabel x1;
  private JLabel x2;
  private JLabel l1;
  private JLabel l2;
  private JLabel l3;
  private JLabel l4;
  private JLabel l5;
  private JLabel l6;
  private JLabel l7;
  private JLabel l8;
  private JLabel a1;
  private JLabel a2;
  private JLabel a3;
  private JLabel a4;
  private JLabel a5;
  private JLabel a6;
  private JLabel a7;
  private JLabel a8;
  private JLabel a9;
  private JLabel a0;
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          eps window = new eps();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public eps() {
    initialize();
  }

  private void initialize() {
    frame = new JFrame();
    frame.setBounds(50, 50, 50, 50);
    
    JFrame f = new JFrame("Pet Store");
    JButton b1 = new JButton("Login");
    JButton b2 = new JButton("Register a pet");
    JButton b3 = new JButton("Rescued pets");
    JButton b4 = new JButton("Missing pets");
    z1=new JLabel(" NO.15 PET SHOP ");

    z1.setBounds(250,100,200,50);
    b1.setBounds(200,200,200,50);
    b2.setBounds(200,300,200,50);
    b3.setBounds(200,400,200,50);
    b4.setBounds(200,500,200,50);

    f.add(z1);
    f.add(b1);
    f.add(b2);
    f.add(b3);
    f.add(b4);


    f.setLayout(null);
    f.setVisible(true);
    f.setSize(800,800);
    b1.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e) {
    JFrame f2 = new JFrame("LOGIN DETAILS");
    f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JButton but1 = new JButton("Exit");
    JButton but2 = new JButton("Login");
    JTextField t1=new JTextField();
    JTextField t2=new JTextField();

    x1=new JLabel("NAME : ");
    x2=new JLabel("PASSWORD : ");

    x1.setBounds(50,100,200,50);
    t1.setBounds(300,100,200,50);
    x2.setBounds(50,200,200,50);
    t2.setBounds(300,200,200,50);

    but2.setBounds(50,500,200,45);
    but1.setBounds(300,500,200,45);
    
    f2.add(but1);
    f2.add(but2);

    f2.add(x1);
    f2.add(x2);
              
    f2.add(t1);
    f2.add(t2);

    f2.setLayout(null);
    f2.setVisible(true);
    f2.setSize(800,800);
    }
    });
    b2.addActionListener(new ActionListener() 
    {
    public void actionPerformed(ActionEvent e) {
     JFrame f3 = new JFrame("Registration");
    JButton button1 = new JButton("DOG");
    JButton button2 = new JButton("CAT");
 
    button1.setBounds(200,200,200,50);
    button2.setBounds(200,300,200,50);

    f3.add(button1);  
    f3.add(button2);  
                
    f3.setLayout(null);
    f3.setVisible(true);
    f3.setSize(800,800);
    button1.addActionListener(new ActionListener() 
    {
    public void actionPerformed(ActionEvent e) {
     JFrame g1 = new JFrame("Dog Registration");
    JButton buts1 = new JButton("Exit");
    JButton buts2 = new JButton("Submit");
    JTextField t1=new JTextField();
    JTextField t2=new JTextField();
    JTextField t3=new JTextField();
    JTextField t4=new JTextField();
    JTextField t5=new JTextField();
    JTextField t6=new JTextField();
                
    l1=new JLabel("DOG NAME : ");
    l2=new JLabel(" AGE : ");
    l3=new JLabel("BREED : ");
    l4=new JLabel(" SEX : ");
    y1=new JLabel("OWNER'S NAME : ");
    y2=new JLabel("OWNER'S LOCALITY : ");

    l1.setBounds(50,100,200,50);
    t1.setBounds(300,100,200,50);
    l2.setBounds(50,200,200,50);
    t2.setBounds(300,200,200,50);
    l3.setBounds(50,300,200,50);
    t3.setBounds(300,300,200,50);
    l4.setBounds(50,400,200,50);
    t4.setBounds(300,400,200,50);
    y1.setBounds(50,500,200,50);
    t5.setBounds(300,500,200,50);
    y2.setBounds(50,600,200,50);
    t6.setBounds(300,600,200,50);
               

    buts2.setBounds(50,700,200,45);
    buts1.setBounds(300,700,200,45);

    g1.add(buts1);  
    g1.add(buts2);  
    g1.add(l1);
    g1.add(l2);
    g1.add(l3);
    g1.add(l4);
    g1.add(y1);
    g1.add(y2);
              
    g1.add(t1);
    g1.add(t2);
    g1.add(t3);
    g1.add(t4);
    g1.add(t5);
    g1.add(t6);
                
    g1.setLayout(null);
    g1.setVisible(true);
    g1.setSize(1200,1200);
    
    buts2.addActionListener(new ActionListener() 
    {
    public void actionPerformed(ActionEvent e) {
    JOptionPane.showMessageDialog(frame.getComponent(0), "Sussesfully Submitted");
    }
    });
    }
    });
    button2.addActionListener(new ActionListener() 
    {
    public void actionPerformed(ActionEvent e) {
     JFrame g2 = new JFrame("Cat Registration");
    JButton butts1 = new JButton("Exit");
    JButton butts2 = new JButton("Submit");
    JTextField t1=new JTextField();
    JTextField t2=new JTextField();
    JTextField t3=new JTextField();
    JTextField t4=new JTextField();
    JTextField t5=new JTextField();
    JTextField t6=new JTextField();            


    l1=new JLabel("CAT NAME : ");
    l2=new JLabel(" AGE : ");
    l3=new JLabel("COLOUR : ");
    l4=new JLabel(" SEX : ");
    y3=new JLabel("OWNER'S NAME : ");
    y4=new JLabel("OWNER'S LOCALITY : ");

    l1.setBounds(50,100,200,50);
    t1.setBounds(300,100,200,50);
    l2.setBounds(50,200,200,50);
    t2.setBounds(300,200,200,50);
    l3.setBounds(50,300,200,50);
    t3.setBounds(300,300,200,50);
    l4.setBounds(50,400,200,50);
    t4.setBounds(300,400,200,50);
    y3.setBounds(50,500,200,50);
    t5.setBounds(300,500,200,50);
    y4.setBounds(50,600,200,50);
    t6.setBounds(300,600,200,50);
               

    butts2.setBounds(50,700,200,45);
    butts1.setBounds(300,700,200,45);

    g2.add(butts1);  
    g2.add(butts2);  
    g2.add(l1);
    g2.add(l2);
    g2.add(l3);
    g2.add(l4);
    g2.add(y3);
    g2.add(y4);
              
    g2.add(t1);
    g2.add(t2);
    g2.add(t3);
    g2.add(t4);
    g2.add(t5);
    g2.add(t6);

                
    g2.setLayout(null);
    g2.setVisible(true);
    g2.setSize(1200,1200);

    butts2.addActionListener(new ActionListener() 
    {
    public void actionPerformed(ActionEvent e) {
    JOptionPane.showMessageDialog(frame.getComponent(0), "Sussesfully Submitted");
    }
    });
    }
    });
    }
    });
    b3.addActionListener(new ActionListener() 
    {
    public void actionPerformed(ActionEvent e) {
     JFrame f4 = new JFrame("RESCUED PETS");
     ImageIcon ii = new ImageIcon("C:/java/jimmy2.gif");
     ImageIcon ij = new ImageIcon("C:/java/ramu2.gif");
    a1=new JLabel("RESCUED PETS DETAILS :");
    a2=new JLabel(" (1) Jimmy(cat) is one of the pets rescued by our NGOs.It is 22 months old and black in colour.");
    a3=new JLabel(ii);
    a4=new JLabel(" (2) Ramu(dog) is one of the pets rescued by our NGOs.It is 38 months old.It belongs to German Shepherd breed.It is a highly inteligent dog.");
    a5=new JLabel(ij);
    a1.setBounds(50,30,200,50);
    a2.setBounds(50,60,800,50);
    a3.setBounds(50,80,350,300);
    a4.setBounds(50,360,900,50);
    a5.setBounds(50,390,500,400);
     f4.add(a1);
     f4.add(a2);
     f4.add(a3);
     f4.add(a4);
     f4.add(a5);
    f4.setLayout(null);
    f4.setVisible(true);
    f4.setSize(1200,1200);
   }
   });
   b4.addActionListener(new ActionListener() 
    {
    public void actionPerformed(ActionEvent e) {
     JFrame f5 = new JFrame("Missing pets");
     ImageIcon ik = new ImageIcon("C:/java/peter2.gif");
     ImageIcon il = new ImageIcon("C:/java/Roni2.gif");
    a6=new JLabel("MISSING PETS DETAILS :");
    a7=new JLabel(" (1) Peter(dog) is missing since last month.It belongs to Golden Retriever breed.The image of missing dog is shown below.If found please contact pet owner , 9413299638.");
    a8=new JLabel(ik);
    a9=new JLabel(" (2) Roni(cat) is missing since last week.It is orange in colour.The image of missing cat is shown below.If found please contact pet owner , 9413299638.");
    a0=new JLabel(il);
    a6.setBounds(50,30,200,50);
    a7.setBounds(50,60,960,50);
    a8.setBounds(50,80,350,300);
    a9.setBounds(50,360,950,50);
    a0.setBounds(50,390,450,250);
     f5.add(a6);
     f5.add(a7);
     f5.add(a8);
     f5.add(a9);
     f5.add(a0);
    f5.setLayout(null);
    f5.setVisible(true);
    f5.setSize(1200,1200);
   }
   });
}
}