package entities;

import gamestates.Playing;
import utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utils.Constants.EnemyConstants.*;

public class EnemyManager {
    private Playing playing;
    private BufferedImage[][] crabbyArr;
    private ArrayList<Crabby> crabbies = new ArrayList<Crabby>();

    public EnemyManager(Playing playing) {
        this.playing = playing;
        loadEnemyImgs();
        addEnemies();
    }

    private void addEnemies() {
        crabbies = LoadSave.getCrabs();
        System.out.println("size of crabs: " + crabbies.size());
    }

    private void loadEnemyImgs() {
        crabbyArr = new BufferedImage[5][9];
        BufferedImage temp = LoadSave.getPositionsAtlas(LoadSave.CRABBY_ATLAS);
        for (int i = 0; i < crabbyArr.length; i++)
            for (int j = 0; j < crabbyArr[i].length; j++)
                crabbyArr[i][j] = temp.getSubimage(j * CRABBY_WIDTH_DEFAULT, i * CRABBY_HEIGHT_DEFAULT, CRABBY_WIDTH_DEFAULT, CRABBY_HEIGHT_DEFAULT);
    }

    public void update(int[][] levelData, Player player) {
        for (Crabby c : crabbies)
            c.update(levelData, player);
    }

    public void draw(Graphics graphics, int xLevelOffset) {
        drawCrabs(graphics, xLevelOffset);
    }

    private void drawCrabs(Graphics graphics, int xLevelOffset) {
        for (Crabby c : crabbies) {
            graphics.drawImage(crabbyArr[c.getEnemyState()][c.getAnimationIndex()],
                    (int) c.getHitbox().x - xLevelOffset + c.flipX(),
                    (int) c.getHitbox().y, CRABBY_WIDTH * c.flipW(), CRABBY_HEIGHT, null);
            c.drawAttackBox(graphics, xLevelOffset);
        }
    }

}
