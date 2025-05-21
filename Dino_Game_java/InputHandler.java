package Dino_Game_java;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
// Can also use AbstractAction for more complex input mapping like in original DrawPanel

// Handles keyboard input
class InputHandler extends KeyAdapter {
    private GameManager gameManager;

    public InputHandler(GameManager manager) {
        this.gameManager = manager;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_SPACE && !gameManager.isGameOver()) {
            // For jump action, SPACE or UP is more common than ENTER in such games
            gameManager.dinoJump();
        } else if (keyCode == KeyEvent.VK_SPACE) { // Use SPACE specifically for restart if game is over
            if (gameManager.isGameOver()) {
                gameManager.restartGame();
            }
        }
        // Add other key bindings if needed, e.g., duck
    }
}