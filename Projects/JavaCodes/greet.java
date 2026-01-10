import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class OwlGreeting extends JFrame implements ActionListener{
   JLabel labelQuestion, labelGreeting;
   JTextField textAnswer;
   ImageIcon owl;
   public OwlGreeting(){
     setLayout(new FlowLayout());
     labelQuestion = new JLabel("Whooooo's there?");
     textAnswer = new JTextField(10);
     labelGreeting = new JLabel();
     owl = new ImageIcon("animal39-2.png");
     textAnswer.addActionListener(this);
     add(labelQuestion);
     add(textAnswer);
     add(labelGreeting);
   }
   public static void main(String args[]){
     OwlGreeting window = new OwlGreeting();
     window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     window.setSize(275, 100);
     window.setTitle("Owl Greeting");
     window.setVisible(true);
   }
   public void actionPerformed(ActionEvent e){
     String name = textAnswer.getText();
     labelGreeting.setText("Hoot for " + name + "!");
     labelGreeting.setIcon(owl);
   }
}