import java.awt.*;  
import java.awt.event.*;  
import java.io.InputStream;  
import java.net.*;  
public class SourceGetter extends Frame implements ActionListener{  
    TextField tf;  
    TextArea ta;  
    Button b;  
    Label l;  
    SourceGetter(){  
        super("Source Getter Tool - Javatpoint");  
        l=new Label("Enter URL:");  
        l.setBounds(50,50,50,20);  
          
        tf=new TextField();  
        tf.setBounds(120,50,250,20);  
          
        b=new Button("Get Source Code");  
        b.setBounds(120, 100,120,30);  
        b.addActionListener(this);  
          
        ta=new TextArea();  
        ta.setBounds(120,150,250,150);  
          
        add(l);add(tf);add(b);add(ta);  
        setSize(400,400);  
        setLayout(null);  
        setVisible(true);  
    }  
    public void actionPerformed(ActionEvent e){  
        String s=tf.getText();  
        if(s==null){}  
        else{  
            try{  
            URL u=new URL(s);  
            URLConnection uc=u.openConnection();  
          
            InputStream is=uc.getInputStream();  
            int i;  
            StringBuilder sb=new StringBuilder();  
            while((i=is.read())!=-1){  
                sb.append((char)i);  
            }  
            String source=sb.toString();  
            ta.setText(source);  
            }catch(Exception ex){System.out.println(e);}  
        }  
    }  
    public static void main(String[] args) {  
        new SourceGetter();  
    }  
}  
