import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RiddleGame extends JFrame {
    private String[] riddles = {
        "I speak without a mouth and hear without ears. I have no body, but I come alive with wind. What am I?",
        "I'm not alive, but I can grow; I don't have lungs, but I need air; I don't have a mouth, but water kills me. What am I?",
        "I have keys but can't open locks. What am I?",
        "I am taken from a mine, and shut up in a wooden case, from which I am never released, and yet I am used by almost every person. What am I?",
        "The more you take, the more you leave behind. What am I?",
        "I have cities but no houses, forests but no trees, and rivers but no water. What am I?",
        "I'm tall when I'm young and short when I'm old. What am I?"
    };
    private String[] answers = {
        "An echo",
        "A fire",
        "A piano",
        "Pencil lead (graphite)",
        "Footsteps",
        "A map",
        "A candle"
    };

    private int currentRiddleIndex = 0;
    private JLabel riddleLabel;
    private JTextField answerField;
    private JButton submitButton;

    public RiddleGame() {
        setTitle("Riddle Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        riddleLabel = new JLabel(riddles[currentRiddleIndex]);
        answerField = new JTextField(20);
        submitButton = new JButton("Submit");

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 1));
        centerPanel.add(riddleLabel);
        centerPanel.add(answerField);
        centerPanel.add(submitButton);

        add(centerPanel, BorderLayout.CENTER);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });
    }

    private void checkAnswer() {
        String userAnswer = answerField.getText().trim().toLowerCase();
        String correctAnswer = answers[currentRiddleIndex].toLowerCase();

        if (userAnswer.equals(correctAnswer)) {
            JOptionPane.showMessageDialog(this, "Correct!");
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect. Try again.");
        }

        currentRiddleIndex++;
        if (currentRiddleIndex < riddles.length) {
            riddleLabel.setText(riddles[currentRiddleIndex]);
            answerField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Congratulations! You've completed all the riddles.");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RiddleGame game = new RiddleGame();
            game.setVisible(true);
        });
    }
}
