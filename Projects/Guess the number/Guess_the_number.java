import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuessTheNumberGame extends Application {
    private int targetNumber = (int) (Math.random() * 100) + 1;
    private int numberOfTries = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Guess the Number Game");

        Label titleLabel = new Label("Guess the Number (1-100)");
        TextField guessInput = new TextField();
        Label messageLabel = new Label();
        VBox vbox = new VBox(titleLabel, guessInput, messageLabel);

        guessInput.setOnAction(e -> {
            try {
                int userGuess = Integer.parseInt(guessInput.getText());
                numberOfTries++;
                if (userGuess < targetNumber) {
                    messageLabel.setText("Try higher.");
                } else if (userGuess > targetNumber) {
                    messageLabel.setText("Try lower.");
                } else {
                    messageLabel.setText("Congratulations! You guessed the number in " + numberOfTries + " tries.");
                }
                guessInput.clear();
            } catch (NumberFormatException ex) {
                messageLabel.setText("Invalid input. Enter a number.");
            }
        });

        Scene scene = new Scene(vbox, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
  }
              
