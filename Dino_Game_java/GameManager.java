package Dino_Game_java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;

// Manages the game state and logic
class GameManager {
    public static final int GROUND_Y = 400; // Y position of the ground
    public static final int DINO_INITIAL_X = 180; // Initial X position of the dino

    private Dinosaur dinosaur;
    private List<Cactus> cacti;
    private boolean gameOver;
    private int score; // Or use 'jump' variable if it represents horizontal scroll/score
    private Timer gameLoopTimer;
    private Timer dinoJumpTimer;

    private GamePanel gamePanel; // Reference to GamePanel for repaint calls

    public GameManager(GamePanel panel) {
        this.gamePanel = panel;
        this.dinosaur = new Dinosaur(DINO_INITIAL_X, GROUND_Y);
        this.cacti = new ArrayList<>();
        this.gameOver = false;
        this.score = 0;
        initTimers();
        spawnInitialCacti();
    }

    private void initTimers() {
        // Game loop timer (moves cacti, checks collisions, updates score)
        gameLoopTimer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!gameOver) {
                    updateGame();
                    gamePanel.repaint(); // Request repaint from GamePanel
                }
            }
        });

        // Dinosaur jump animation timer
        dinoJumpTimer = new Timer(80, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!gameOver) {
                    dinosaur.updateJump();
                    if (!dinosaur.isJumping()) { // Stop this timer if jump is complete
                        // Potentially stop dinoJumpTimer if onEnterPresses is false
                    }
                    gamePanel.repaint(); // Request repaint
                }
            }
        });
    }

    // Spawns initial set of cacti
    private void spawnInitialCacti() {
        cacti.clear(); // Clear existing cacti
        Random rr = new Random();
        int nbr = 2; // Number of cacti
        int x_start = 600; // Initial x position for the first cactus
        int spacing = 300; // Spacing between cacti

        for (int it = 0; it < nbr; it++) {
            Random r = new Random();
            int step = r.nextInt(10) + 1; // For varied height/size
            int cactusX = x_start + it * (spacing + r.nextInt(100)); // Add some random spacing
            int h_ = 10 + (6 * step) + 2;
            int y_ = GROUND_Y - h_; // Position relative to ground
            int p_ = 8 + step / 2;
            cacti.add(new Cactus(cactusX, y_, h_, p_));
        }
    }

    // Main game update logic
    public void updateGame() {
        if (gameOver) return;

        score += 10; // Represents horizontal scroll or actual score
        
        // Move cacti and check for despawn/respawn
        List<Cactus> cactiToRemove = new ArrayList<>();
        boolean needsRespawn = false;
        for (Cactus cactus : cacti) {
            cactus.move(-10); // Move cactus to the left
            if (cactus.getX() + cactus.getWidth() < 0) { // If cactus is off-screen
                cactiToRemove.add(cactus);
                needsRespawn = true;
            }
        }
        cacti.removeAll(cactiToRemove);

        if (needsRespawn || cacti.isEmpty()) {
             // Simple respawn logic: add one new cactus far to the right
            Random r = new Random();
            int step = r.nextInt(10) + 1;
            int h_ = 10 + (6 * step) + 2;
            // Place new cactus off-screen to the right
            cacti.add(new Cactus(GameWindow.D_W + r.nextInt(200), GROUND_Y - h_, h_, 8 + step / 2));
        }

        // Check for collisions
        for (Cactus cactus : cacti) {
            if (dinosaur.getBounds().intersects(cactus.getBounds())) {
                gameOver = true;
                // Stop timers on game over
                gameLoopTimer.stop();
                dinoJumpTimer.stop();
                break;
            }
        }
    }

    // Starts the game timers
    public void startGame() {
        if (!gameLoopTimer.isRunning()) {
            gameLoopTimer.start();
        }
        // dinoJumpTimer is started by dinosaur.jump()
    }

    // Initiates dinosaur jump
    public void dinoJump() {
        if (!gameOver && dinosaur.canJump()) {
            dinosaur.startJump();
            if (!dinoJumpTimer.isRunning()) { // Start jump timer if not already running
                dinoJumpTimer.start();
            }
        }
    }

    // Resets the game state
    public void restartGame() {
        this.gameOver = false;
        this.score = 0;
        this.dinosaur = new Dinosaur(DINO_INITIAL_X, GROUND_Y); // Reset dinosaur
        spawnInitialCacti(); // Respawn cacti
        startGame(); // Restart timers
        gamePanel.repaint(); // Request repaint
    }

    // Getters for rendering
    public Dinosaur getDinosaur() { return dinosaur; }
    public List<Cactus> getCacti() { return cacti; }
    public boolean isGameOver() { return gameOver; }
    public int getScore() { return score; }
}