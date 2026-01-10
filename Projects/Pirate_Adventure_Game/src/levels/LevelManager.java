package levels;

import main.Game;
import utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static main.Game.TILES_SIZE;

public class LevelManager {
    private Game game;
    private BufferedImage[] levelElement;
    private Level levelOne;

    public LevelManager(Game game) {
        this.game = game;
        //   levelElement= LoadSave.getPositionsAtlas(LoadSave.LEVEL_ATLAS);
        importBackgroundElements();
        levelOne = new Level(LoadSave.getLevelData());
    }

    private void importBackgroundElements() {
        BufferedImage img = LoadSave.getPositionsAtlas(LoadSave.LEVEL_ATLAS);
        levelElement = new BufferedImage[12 * 4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 12; j++) {
                int index = i * 12 + j;
                levelElement[index] = img.getSubimage(j * 32, i * 32, 32, 32);
            }
        }
    }

    public void draw(Graphics graphics, int levelOffset) {
        for (int i = 0; i < Game.TILES_IN_HEIGHT; i++) {
            for (int j = 0; j < levelOne.getLevelData()[0].length; j++) {
                int index = levelOne.getComponentIndex(j, i);
                graphics.drawImage(levelElement[index], TILES_SIZE * j - levelOffset, TILES_SIZE * i, TILES_SIZE, TILES_SIZE, null);
            }
        }
    }

    public void update() {

    }

    public Level getCurrentLevel() {
        return levelOne;
    }

}
