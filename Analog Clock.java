import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AnalogClock extends JPanel {
    private int radius;
    private int centerX;
    private int centerY;

    public AnalogClock(int radius) {
        this.radius = radius;
        this.setPreferredSize(new Dimension(2 * radius, 2 * radius));
        Timer timer = new Timer(1000, new ClockListener());
        timer.start();
    }

    private class ClockListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }

    private void drawClockHand(Graphics g, int handLength, int angle, int value) {
        int x = (int) (centerX + handLength * Math.sin(Math.toRadians(angle)));
        int y = (int) (centerY - handLength * Math.cos(Math.toRadians(angle)));
        g.drawLine(centerX, centerY, x, y);
        if (value != -1) {
            g.drawString(Integer.toString(value), x, y);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;

        Calendar now = new GregorianCalendar();
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);

        g.setColor(Color.BLACK);
        g.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        g.drawString("12", centerX - 5, centerY - radius + 15);
        g.drawString("3", centerX + radius - 10, centerY + 5);
        g.drawString("6", centerX - 5, centerY + radius - 5);
        g.drawString("9", centerX - radius + 5, centerY + 5);

        int hourAngle = (360 / 12) * (hour % 12) - 90;
        int minuteAngle = (360 / 60) * minute - 90;
        int secondAngle = (360 / 60) * second - 90;

        g.setColor(Color.BLUE);
        drawClockHand(g, (int) (0.5 * radius), hourAngle, hour);
        g.setColor(Color.GREEN);
        drawClockHand(g, (int) (0.8 * radius), minuteAngle, minute);
        g.setColor(Color.RED);
        drawClockHand(g, (int) (0.9 * radius), secondAngle, second);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Analog Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new AnalogClock(200));
        frame.pack();
        frame.setVisible(true);
    }
}
