package entities;

import main.Game;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static utils.Constants.EnemyConstants.*;
import static utils.Constants.Directions.*;

public class Crabby extends Enemy {
    private Rectangle2D.Float attackBox;
    private int attackBoxOffsetX;

    public Crabby(float x, float y) {
        super(x, y, CRABBY_WIDTH, CRABBY_HEIGHT, CRABBY);
        initHitbox(x, y, (int) (22 * Game.SCALE), (int) (27 * Game.SCALE));
        initAttackBox();
    }

    private void initAttackBox() {
        attackBox = new Rectangle2D.Float(x, y, (int) (70 * Game.SCALE), (int) (25 * Game.SCALE));
        attackBoxOffsetX = (int) (Game.SCALE);
    }

    public void update(int[][] levelData, Player player) {
        updateMove(levelData, player);
        updateAnimationMovement();
        updateAttackBox();
    }

    private void updateAttackBox() {
        attackBox.x = hitbox.x - attackBoxOffsetX;
        attackBox.y = hitbox.y;
    }

    private void updateMove(int[][] levelData, Player player) {
        if (firstUpdate)
            firstUpdateCheck(levelData);
        if (inAir) {
            updateInAir(levelData);
        } else {
            switch (enemyState) {
                case IDLE:
                    newState(RUNNING);
                    break;
                case RUNNING:
                    if (canSeePlayer(levelData, player))
                        turnTowardsPlayer(player);
                    if (isPlayerCloseToAttack(player))
                        newState(ATTACK);
                    move(levelData);
                    break;
            }
        }
    }

    public void drawAttackBox(Graphics graphics, int xLevelOffset) {
        graphics.setColor(Color.red);
        graphics.drawRect((int) (attackBox.x - xLevelOffset), (int) attackBox.y, (int) attackBox.width, (int) attackBox.height);
    }

    public int flipX() {
        if (walkDir == RIGHT)
            return width;
        else
            return 0;
    }

    public int flipW() {
        if (walkDir == RIGHT)
            return -1;
        else
            return 1;
    }
}