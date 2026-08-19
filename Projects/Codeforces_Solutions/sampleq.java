
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sampleq extends JFrame {
    private JTextField num1, num2, result;
    public sampleq() {
        setTitle("Integer Division Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        num1 = new JTextField(10);
        num2 = new JTextField(10);
        result = new JTextField(10);
        result.setEditable(false);
        JButton divideButton = new JButton("Divide");
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performDivision();
            }
        });
        setLayout(new GridLayout(4, 2));
        add(new JLabel("Num1:"));
        add(num1);
        add(new JLabel("Num2:"));
        add(num2);
        add(new JLabel("Result:"));
        add(result);
        add(divideButton);
        setVisible(true);
    }
    private void performDivision() {
        try {
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());
            if (n2 == 0) {
                throw new ArithmeticException("Cannot divide by zero!");
            }
            int res = n1 / n2;
            result.setText(String.valueOf(res));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid integers for Num1 and Num2.",
                    "Number Format Exception", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(this, "Cannot divide by zero.",
                    "Arithmetic Exception", JOptionPane.ERROR_MESSAGE);
        } }
    public static void main(String[] args) {
                new sampleq();
    }
}
