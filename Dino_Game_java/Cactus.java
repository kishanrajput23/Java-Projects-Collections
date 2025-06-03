package Dino_Game_java;

import java.awt.Rectangle;

// Represents a Cactus entity
class Cactus {
    private int x, y, h, p; // x, y position, height, thickness parameter
    // Assuming p relates to width calculation. Need a clear definition.
    // For simplicity, let's define a width.
    private int width; 

    public Cactus(int x, int y, int h, int p) {
        this.x = x;
        this.y = y; // y is typically the top-left corner for rendering
        this.h = h;
        this.p = p;
        // Approximate width based on draw() method in original code (p*2 for central part)
        // and draw2() which adds more parts. This needs refinement based on exact drawing.
        this.width = p * 6; // A rough estimate for collision
    }

    public void move(int deltaX) {
        this.x += deltaX;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getH() { return h; }
    public int getP() { return p; }
    public int getWidth() { return width; } // For collision detection

    public Rectangle getBounds() {
        // Bounds for collision. Assuming x,y is top-left of the main central pillar.
        // The actual drawn shape is more complex. This is a simplification.
        return new Rectangle(x, y, p * 2, h); // Central part of main cactus segment
    }
}