package entities;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Entity {
    protected float x, y;
    protected int width, height;

    protected Rectangle2D.Float hitbox;

    public Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    protected void initHitbox(float x, float y, float width, float height) {
        hitbox = new Rectangle2D.Float(x, y, width, height);
    }


    protected void drawHitbox(Graphics graphics, int xLevelOffset) {
        graphics.setColor(Color.PINK);
        graphics.drawRect((int) hitbox.x - xLevelOffset, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);
    }

    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }
}
