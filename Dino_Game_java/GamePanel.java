package Dino_Game_java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.JPanel;

// Responsible for all rendering of the game
class GamePanel extends JPanel {
    private GameManager gameManager; // Reference to game logic and state

    // Colors can be static or passed from GameManager/Config if they need to change
    private Color colorDinosaur = Color.GRAY;
    private Color colorGameOver1 = Color.black;
    private Color colorGameOver2 = Color.yellow; // Unused in original gameOver text
    private Color colorCactus1 = Color.decode("#4CAF50"); // A green color
    private Color colorCactus2 = Color.decode("#388E3C"); // A darker green
    private Color colorSun1 = new Color(255, 255, 0);
    private Color colorSun2 = new Color(255, 255, 153);
    private Color colorGround = Color.ORANGE;

    public GamePanel(GameManager manager) {
        this.gameManager = manager;
        setPreferredSize(new Dimension(GameWindow.D_W, GameWindow.D_H));
        setBackground(Color.CYAN); // Set a background color for the sky
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSun(g);
        drawGround(g, GameManager.GROUND_Y, 180); // Assuming 180 is maxH related to ground drawing

        Dinosaur dinosaur = gameManager.getDinosaur();
        if (dinosaur != null) {
            drawDinosaur(g, dinosaur.getX(), dinosaur.getY());
        }

        List<Cactus> cacti = gameManager.getCacti();
        if (cacti != null) {
            for (Cactus cactus : cacti) {
                // Original drawCactus logic was complex and intertwined with collision.
                // We'll simplify here and call the individual cactus drawing.
                // The collision logic is now in GameManager.
                drawSingleCactus(g, cactus);
            }
        }

        if (gameManager.isGameOver()) {
            drawGameOverMessage(g);
        }
        // Optionally, draw score
        // drawScore(g, gameManager.getScore());
    }

    // Draws the sun
    private void drawSun(Graphics g) {
        Graphics2D sun1 = (Graphics2D) g;
        sun1.setPaint(colorSun1);
        sun1.fillArc(900, 70, 80, 80, 90, 180);
        Graphics2D sun2 = (Graphics2D) g;
        sun2.setPaint(colorSun2);
        sun2.fillArc(900, 70, 80, 80, 270, 180);
    }

    // Draws the ground
    private void drawGround(Graphics g, int groundYPosition, int visualHeight) {
        Graphics2D sol = (Graphics2D) g;
        sol.setPaint(colorGround);
        // y + maxH - 20 from original, interpreting groundYPosition as the top of the
        // dino's standing surface
        sol.fillRect(0, groundYPosition, GameWindow.D_W, visualHeight); // visualHeight could be remaining panel height
    }

    // Draws the dinosaur (based on original drawDinausor and drawRaw)
    private void drawDinosaur(Graphics g, int dinoX, int dinoBaseY) {
        g.setColor(colorDinosaur);
        int unit = Game.unit; // Assuming Game.unit is accessible or defined elsewhere (e.g., Constants class)
        int step = 0; // step was incremented before use in original, so start at 0

        // Feet
        step = 0;
        drawRaw(g, dinoX, dinoBaseY - (step * unit), 2, 1, unit);
        drawRaw(g, dinoX + 4 * unit, dinoBaseY - (step * unit), 2, 1, unit);
        step++;
        drawRaw(g, dinoX, dinoBaseY - (step * unit), 1, 1, unit);
        drawRaw(g, dinoX + 4 * unit, dinoBaseY - (step * unit), 1, 1, unit);
        // Body
        step++;
        drawRaw(g, dinoX, dinoBaseY - step * unit, 2, 1, unit);
        drawRaw(g, dinoX + 3 * unit, dinoBaseY - step * unit, 2, 1, unit);
        step++;
        drawRaw(g, dinoX, dinoBaseY - step * unit, 5, 1, unit);
        step++;
        drawRaw(g, dinoX - unit, dinoBaseY - step * unit, 6, 1, unit);
        step++;
        drawRaw(g, dinoX - 2 * unit, dinoBaseY - step * unit, 8, 1, unit);
        step++;
        drawRaw(g, dinoX - 3 * unit, dinoBaseY - step * unit, 10, 1, unit);
        // Head and Tail start
        step++;
        drawRaw(g, dinoX - 4 * unit, dinoBaseY - step * unit, 11, 1, unit); // Main body/tail part
        drawRaw(g, dinoX + (11 + 1 - 4) * unit, dinoBaseY - step * unit, 1, 1, unit); // Eye area?
        step++;
        drawRaw(g, dinoX - 4 * unit, dinoBaseY - step * unit, 3, 1, unit);
        drawRaw(g, dinoX + (5 - 4) * unit, dinoBaseY - step * unit, 8, 1, unit);
        step++;
        drawRaw(g, dinoX - 4 * unit, dinoBaseY - step * unit, 2, 1, unit);
        drawRaw(g, dinoX + (6 - 4) * unit, dinoBaseY - step * unit, 5, 1, unit);
        step++;
        drawRaw(g, dinoX - 4 * unit, dinoBaseY - step * unit, 1, 1, unit);
        drawRaw(g, dinoX + (7 - 4) * unit, dinoBaseY - step * unit, 4, 1, unit);
        step++;
        drawRaw(g, dinoX - 4 * unit, dinoBaseY - step * unit, 1, 1, unit); // Neck
        drawRaw(g, dinoX + (8 - 4) * unit, dinoBaseY - step * unit, 7, 1, unit); // Head
        step++;
        drawRaw(g, dinoX + (8 - 4) * unit, dinoBaseY - step * unit, 4, 1, unit);
        step++;
        drawRaw(g, dinoX + (8 - 4) * unit, dinoBaseY - step * unit, 8, 1, unit);
        step++;
        drawRaw(g, dinoX + (8 - 4) * unit, dinoBaseY - step * unit, 2, 1, unit);
        drawRaw(g, dinoX + (11 - 4) * unit, dinoBaseY - step * unit, 5, 1, unit);
        step++;
        drawRaw(g, dinoX + (8 - 4) * unit, dinoBaseY - step * unit, 8, 1, unit);
        step++;
        drawRaw(g, dinoX + (9 - 4) * unit, dinoBaseY - step * unit, 6, 1, unit);
    }

    // Helper for drawing dinosaur parts
    private void drawRaw(Graphics g, int x, int y, int wMultiplier, int hMultiplier, int unit) {
        ((Graphics2D) g).fillRect(x, y, wMultiplier * unit, hMultiplier * unit);
    }

    // Draws a single cactus based on its properties
    // This combines logic from original `draw` and `drow2` methods
    private void drawSingleCactus(Graphics g, Cactus cactus) {
        int x = cactus.getX();
        int y = cactus.getY(); // Assuming y is top of cactus body
        int h = cactus.getH(); // Height of main stem
        int p = cactus.getP(); // Thickness/segment parameter

        // Main stem (from original `draw` method, simplified)
        Graphics2D gcd = (Graphics2D) g;
        gcd.setPaint(colorCactus1);
        gcd.fillRect(x, y, p, h);
        Graphics2D gsd = (Graphics2D) g;
        gsd.setPaint(colorCactus2);
        gsd.fillRect(x + p, y, p, h);

        // Arcs on top/bottom of main stem
        Graphics2D gssd = (Graphics2D) g;
        gssd.setPaint(colorCactus2);
        gssd.fillArc(x, y - p, p * 2, p * 2, 0, 90); // Corrected angle
        Graphics2D gzssd = (Graphics2D) g;
        gzssd.setPaint(colorCactus1);
        gzssd.fillArc(x, y - p, p * 2, p * 2, 90, 90);
        Graphics2D ghssd = (Graphics2D) g;
        ghssd.setPaint(colorCactus1);
        ghssd.fillArc(x, y + h - p, p * 2, p * 2, 180, 90);
        Graphics2D ghzssd = (Graphics2D) g;
        ghzssd.setPaint(colorCactus2);
        ghzssd.fillArc(x, y + h - p, p * 2, p * 2, 270, 90);

        // Additional cactus parts (from original `drow2`, assuming relative positions)
        // The original drow2 had complex x offsets (x - i - jump, etc.)
        // For a single cactus object, these become simpler offsets from cactus.getX()
        // This part needs careful re-evaluation of what i, j, y1, y2 meant
        // For simplicity, let's draw some arms based on p.
        // Left arm:
        int armHeight = h / 3;
        int armY = y + h / 4;
        Graphics2D gsds = (Graphics2D) g;
        gsds.setPaint(colorCactus1);
        gsds.fillRect(x - p, armY, p, armHeight); // Left arm base
        Graphics2D gsdds = (Graphics2D) g;
        gsdds.setPaint(colorCactus2);
        gsdds.fillRect(x - p, armY - p / 2, p, armHeight - p / 2); // Left arm detail

        // Right arm:
        Graphics2D gsd2 = (Graphics2D) g;
        gsd2.setPaint(colorCactus2);
        gsd2.fillRect(x + p * 2, armY, p, armHeight); // Right arm base
        Graphics2D gsd3 = (Graphics2D) g;
        gsd3.setPaint(colorCactus1);
        gsd3.fillRect(x + p * 2, armY - p / 2, p, armHeight - p / 2); // Right arm detail
    }

    // Draws the "Game Over" message
    private void drawGameOverMessage(Graphics g) {
        Graphics2D graph = (Graphics2D) g;
        graph.setPaint(colorGameOver1);
        graph.setFont(new Font("MV Boli", Font.BOLD, 50)); // BOLD for better visibility
        graph.drawString("Game Over", GameWindow.D_W / 2 - 150, GameWindow.D_H / 2 - 50);

        Graphics2D graph1 = (Graphics2D) g;
        graph1.setPaint(colorGameOver1); // Same color for consistency
        graph1.setFont(new Font("MV Boli", Font.PLAIN, 30)); // Smaller font for instruction
        graph1.drawString("Press Space to restart!", GameWindow.D_W / 2 - 200, GameWindow.D_H / 2 + 20);
    }

    public void setGameManager(GameManager manager) {
        this.gameManager = manager;
    }
}