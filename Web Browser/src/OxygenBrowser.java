import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class OxygenBrowser extends JFrame{
    JTextField t1;
    JEditorPane display;
    
    public OxygenBrowser(){
        super("Ram Ji Ka Browser");
        t1=new JTextField();
        t1.setText("Enter Host..!");
        t1.setFont(new Font("Berlin Sans FB",Font.PLAIN,15));
        t1.setForeground(Color.BLUE);
        t1.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){
        t1.setText("");    
        }
    });
        
        t1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                loadCrap(e.getActionCommand());
            }
        });
        
        add(t1,BorderLayout.NORTH);
        display=new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(new HyperlinkListener(){
        public void hyperlinkUpdate(HyperlinkEvent event){
         if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED)
         {
          loadCrap(event.getURL().toString());   
         }
        }
    });
        
       add(new JScrollPane(display), BorderLayout.CENTER);
       setSize(700,600);
       setLocation(300,100);
       setVisible(true);
    }   
public void loadCrap(String userText)
{
try{
display.setPage(userText);
t1.setText(userText);
}
catch(Exception e){
System.out.println("Crap..!");
String dialogmessage="Error";
String dialogtittle="Type valid Host( \n Ex. - (http://www.google.com)    \n Or Cheak Internet Connection";
int dialogtype=JOptionPane.WARNING_MESSAGE;
JOptionPane.showMessageDialog((Component)null, dialogtittle,dialogmessage,dialogtype);
}
}
}