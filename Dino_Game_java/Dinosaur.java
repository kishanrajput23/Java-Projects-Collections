package Dino_Game_java;

import java.awt.Rectangle;

// Represents the Dinosaur entity
class Dinosaur {
    private int x, y; // Current position
    private int initialY;
    private int jumpHeight = 280; // Max height of jump from initialY
    private int jumpSpeed = 20;
    private boolean jumping = false;
    private boolean jumpAscending = false; // True if going up, false if going down
    private int width = 5 * Game.unit; // Approximate width
    private int height = 10 * Game.unit; // Approximate height (can be more precise)

    public Dinosaur(int x, int y) {
        this.x = x;
        this.y = y;
        this.initialY = y;
    }

    // Initiates the jump sequence
    public void startJump() {
        if (!jumping) {
            jumping = true;
            jumpAscending = true;
        }
    }

    // Updates the dinosaur's Y position during a jump
    public void updateJump() {
        if (jumping) {
            if (jumpAscending) {
                y -= jumpSpeed; // Move up
                if (y <= initialY - jumpHeight) { // Reached peak
                    y = initialY - jumpHeight;
                    jumpAscending = false; // Start descending
                }
            } else {
                y += jumpSpeed; // Move down
                if (y >= initialY) { // Landed
                    y = initialY;
                    jumping = false; // Jump finished
                }
            }
        }
    }
    
    public boolean canJump() {
        return !jumping;
    }

    public boolean isJumping() {
        return jumping;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Rectangle getBounds() {
        // More accurate bounds needed based on actual drawing
        // This is a placeholder
        return new Rectangle(x - 2 * Game.unit, y - 16 * Game.unit, 11 * Game.unit, 17 * Game.unit); 
    }
}