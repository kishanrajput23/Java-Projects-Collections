package ui;

import gamestates.GameState;
import gamestates.Playing;
import main.Game;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameOverlay {

    private Playing playing;

    public GameOverlay(Playing playing) {
        this.playing = playing;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 200));
        graphics.fillRect(0, 0, Game.GAME_HEIGHT, Game.GAME_HEIGHT);
        graphics.setColor(Color.white);
        graphics.drawString("Game Over", Game.GAME_WIDTH / 2, 150);
        graphics.drawString("Press esc to enter Main Menu!", Game.GAME_WIDTH / 2, 300);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            playing.resetAll();
            GameState.state = GameState.MENU;
        }
    }
}
