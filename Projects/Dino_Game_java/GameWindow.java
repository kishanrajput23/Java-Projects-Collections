package Dino_Game_java;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame; // More common to use JFrame for Swing apps

// Sets up the main game window and wires components together
public class GameWindow extends JFrame {
    public static final int D_W = 1200; // Window width
    public static final int D_H = 550;  // Window height

    private GameManager gameManager;
    private GamePanel gamePanel;
    private InputHandler inputHandler;

    public GameWindow() {
        super("Run Dino Run Refactored");

        gamePanel = new GamePanel(null); // Panel created, GameManager will be set later
        gameManager = new GameManager(gamePanel); // Pass panel for repaint calls
        gamePanel.setGameManager(gameManager); // Now set manager for panel to use

        inputHandler = new InputHandler(gameManager);

        this.add(gamePanel);
        this.addKeyListener(inputHandler); // Add input handler to the frame

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(D_W, D_H);
        this.pack(); // Adjusts window size to preferred size of components
        this.setLocationRelativeTo(null); // Center on screen
        this.setResizable(false);
        this.setVisible(true);

        gameManager.startGame(); // Start the game logic
    }
    
    // Setter in GamePanel to avoid chicken-and-egg problem with GameManager needing GamePanel for repaint
    // and GamePanel needing GameManager for data.
    // GamePanel.java needs:
    // public void setGameManager(GameManager manager) { this.gameManager = manager; }


    public static void main(String[] args) {
        // Ensures Swing components are created on the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GameWindow();
            }
        });
    }
}
