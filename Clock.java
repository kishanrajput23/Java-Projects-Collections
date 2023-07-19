import java.awt.Color;  
import java.awt.Font;  
import java.awt.Graphics;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Locale;  
import javax.swing.JFrame;  
import javax.swing.JPanel;  
public class Clock extends JPanel implements Runnable  
{  
 Thread thread = null;  
 SimpleDateFormat formatter = new SimpleDateFormat("s", Locale.getDefault());  
 Date currentDate;  
 int xcenter = 175, ycenter = 175, lastxs = 0, lastys = 0, lastxm = 0, lastym = 0, lastxh = 0, lastyh = 0;  
 private void drawStructure(Graphics g) {  
  g.setFont(new Font("TimesRoman", Font.BOLD, 20));  
  g.setColor(Color.black);  
  g.fillOval(xcenter - 150, ycenter - 150, 300, 300);  
  g.setColor(Color.blue);  
  g.drawString("abhishek dubey", 113, 300);  
  g.setColor(Color.green);  
  g.drawString("9", xcenter - 145, ycenter + 0);  
  g.drawString("3", xcenter + 135, ycenter + 0);  
  g.drawString("12", xcenter - 10, ycenter - 130);  
  g.drawString("6", xcenter - 10, ycenter + 145);  
 }  
 public void paint(Graphics g)   
 {  
  int xhour, yhour, xminute, yminute, xsecond, ysecond, second, minute, hour;  
  drawStructure(g);  
  currentDate = new Date();  
  formatter.applyPattern("s");  
  second = Integer.parseInt(formatter.format(currentDate));  
  formatter.applyPattern("m");  
  minute = Integer.parseInt(formatter.format(currentDate));  
  formatter.applyPattern("h");  
  hour = Integer.parseInt(formatter.format(currentDate));  
  xsecond = (int)(Math.cos(second * 3.14 f / 30 - 3.14 f / 2) * 120 + xcenter);  
  ysecond = (int)(Math.sin(second * 3.14 f / 30 - 3.14 f / 2) * 120 + ycenter);  
  xminute = (int)(Math.cos(minute * 3.14 f / 30 - 3.14 f / 2) * 100 + xcenter);  
  yminute = (int)(Math.sin(minute * 3.14 f / 30 - 3.14 f / 2) * 100 + ycenter);  
  xhour = (int)(Math.cos((hour * 30 + minute / 2) * 3.14 f / 180 - 3.14 f / 2) * 80 + xcenter);  
  yhour = (int)(Math.sin((hour * 30 + minute / 2) * 3.14 f / 180 - 3.14 f / 2) * 80 + ycenter);  
  // Erase if necessary, and redraw    
  g.setColor(Color.magenta);  
  if (xsecond != lastxs || ysecond != lastys)   
  {  
   g.drawLine(xcenter, ycenter, lastxs, lastys);  
  }  
  if (xminute != lastxm || yminute != lastym)   
  {  
   g.drawLine(xcenter, ycenter - 1, lastxm, lastym);  
   g.drawLine(xcenter - 1, ycenter, lastxm, lastym);  
  }  
  if (xhour != lastxh || yhour != lastyh)   
  {  
   g.drawLine(xcenter, ycenter - 1, lastxh, lastyh);  
   g.drawLine(xcenter - 1, ycenter, lastxh, lastyh);  
  }  
  g.setColor(Color.magenta);  
  g.drawLine(xcenter, ycenter, xsecond, ysecond);  
  g.setColor(Color.red);  
  g.drawLine(xcenter, ycenter - 1, xminute, yminute);  
  g.drawLine(xcenter - 1, ycenter, xminute, yminute);  
  g.setColor(Color.green);  
  g.drawLine(xcenter, ycenter - 1, xhour, yhour);  
  g.drawLine(xcenter - 1, ycenter, xhour, yhour);  
  lastxs = xsecond;  
  lastys = ysecond;  
  lastxm = xminute;  
  lastym = yminute;  
  lastxh = xhour;  
  lastyh = yhour;  
 }  
 public void start()   
 {  
  if (thread == null)   
  {  
   thread = new Thread(this);  
   thread.start();  
  }  
 }  
 public void stop()   
 {  
  thread = null;  
 }  
 public void run()   
 {  
  while (thread != null)   
  {  
   try   
   {  
    Thread.sleep(100);  
   }   
   catch (InterruptedException e) {}  
   repaint();  
  }  
  thread = null;  
 }  
 public void update(Graphics g)   
 {  
  paint(g);  
 }  
 public static void main(String args[])   
 {  
  JFrame window = new JFrame();  
  Color c = new Color(118, 73, 190);  
  window.setBackground(c);  
  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  window.setBounds(0, 0, 400, 400);  
  Clock clock = new Clock();  
  window.getContentPane().add(clock);  
  window.setVisible(true);  
  clock.start();  
 }  
}  
