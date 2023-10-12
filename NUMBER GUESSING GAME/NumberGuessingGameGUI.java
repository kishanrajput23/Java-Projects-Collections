import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGameGUI extends JFrame implements ActionListener {
    private JTextField guessField;
    private JButton guessButton;
    private JTextArea infoArea;
    private int randomNumber;
    private int maxAttempts = 10;
    private int attemptsLeft;

    public NumberGuessingGameGUI() {
        setTitle("Number Guessing Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        guessField = new JTextField(10);
        guessButton = new JButton("Guess");
        guessButton.addActionListener(this);
        infoArea = new JTextArea();
        infoArea.setEditable(false);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter your guess: "));
        inputPanel.add(guessField);
        inputPanel.add(guessButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(infoArea), BorderLayout.CENTER);

        initGame();
    }

    private void initGame() {
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;
        attemptsLeft = maxAttempts;
        infoArea.setText("I've selected a number between 1 and 100.\nTry to guess it in " +
                maxAttempts + " attempts or less.\n");
        guessField.setText("");
        guessButton.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (attemptsLeft > 0) {
            try {
                int userGuess = Integer.parseInt(guessField.getText());
                attemptsLeft--;

                if (userGuess == randomNumber) {
                    infoArea.append("Congratulations! You guessed the number " + randomNumber +
                            " in " + (maxAttempts - attemptsLeft) + " attempts.\n");
                    infoArea.append("YOUR SCORE IS " + attemptsLeft);
                    guessButton.setVisible(false);
                } else if (userGuess < randomNumber) {
                    infoArea.append("Try a higher number. Attempts left: " + attemptsLeft + "\n");
                } else {
                    infoArea.append("Try a lower number. Attempts left: " + attemptsLeft + "\n");
                }

                if (attemptsLeft == 0) {
                    infoArea.append("Game Over! The number was " + randomNumber + ".\n");
                    guessButton.setEnabled(false);
                }
            } catch (NumberFormatException ex) {
                infoArea.append("Invalid input. Please enter a valid number.\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NumberGuessingGameGUI game = new NumberGuessingGameGUI();
            game.setVisible(true);
        });
    }
}
