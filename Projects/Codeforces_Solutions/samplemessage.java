/* import java.applet.Applet; */
import java.awt.Graphics;

import javax.swing.JFrame;

public class samplemessage extends JFrame
{
    @Override
    public void paint(Graphics g)
    {
        g.drawString("Hello, World!", 50, 20);
    }
}
