import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculatorApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Age Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel birthDateLabel = new JLabel("Enter Birthdate (yyyy-mm-dd): ");
        JTextField birthDateField = new JTextField();
        JLabel ageLabel = new JLabel("Your Age: ");
        JLabel ageResult = new JLabel("");
        JLabel remainingDaysLabel = new JLabel("Remaining Days Until Next Birthday: ");
        JLabel remainingDaysResult = new JLabel("");

        JButton calculateButton = new JButton("Calculate");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String birthDateText = birthDateField.getText();
                LocalDate birthDate = LocalDate.parse(birthDateText);
                LocalDate currentDate = LocalDate.now();

                Period age = Period.between(birthDate, currentDate);
                ageResult.setText(age.getYears() + " years, " + age.getMonths() + " months, " + age.getDays() + " days");

                LocalDate nextBirthday = birthDate.withYear(currentDate.getYear());
                if (nextBirthday.isBefore(currentDate) || nextBirthday.isEqual(currentDate)) {
                    nextBirthday = nextBirthday.plusYears(1);
                }

                Period remainingDays = Period.between(currentDate, nextBirthday);
                remainingDaysResult.setText(remainingDays.getDays() + " days");
            }
        });

        panel.add(birthDateLabel);
        panel.add(birthDateField);
        panel.add(ageLabel);
        panel.add(ageResult);
        panel.add(remainingDaysLabel);
        panel.add(remainingDaysResult);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.getContentPane().add(calculateButton, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
