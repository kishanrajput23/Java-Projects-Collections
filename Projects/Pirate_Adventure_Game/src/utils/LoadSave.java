package utils;

import entities.Crabby;
import main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static utils.Constants.EnemyConstants.CRABBY;

public class LoadSave {
    public static final String PLAYER_ATLAS = "images/pirate_positions.png";
    public static final String LEVEL_ATLAS = "images/background_elements.png";
    //public static final String LEVEL_ONE_DATA = "images/level_one_data.png";
    public static final String LEVEL_ONE_DATA = "images/level_one_data_long.png";
    public static final String MENU_BUTTONS = "images/button_templates.png";
    public static final String MENU_BOARD = "images/menu_board.png";
    public static final String PAUSE_BACKGROUND = "images/pause_menu.png";
    public static final String SOUND_BUTTONS = "images/sound_button.png";
    public static final String URM_BUTTONS = "images/urm_buttons.png";
    public static final String VOLUME_BUTTONS = "images/volume_buttons.png";
    public static final String MENU_BACKGROUND_IMG = "images/menu_background.png";
    public static final String PLAYING_BACKGROUND_IMG = "images/playing_bg_img.png";
    public static final String BIG_CLOUDS = "images/big_clouds.png";
    public static final String SMALL_CLOUDS = "images/small_clouds.png";
    public static final String CRABBY_ATLAS = "images/crabby_positions.png";
    public static final String STATUS_BAR = "images/health_power_bar.png";



    public static BufferedImage getPositionsAtlas(String fileName) {
        BufferedImage img = null;
        InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);
        try {
            img = ImageIO.read(is);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }

    public static ArrayList<Crabby> getCrabs() {
        BufferedImage img = getPositionsAtlas(LEVEL_ONE_DATA);
        ArrayList<Crabby> list = new ArrayList<Crabby>();
        for (int i = 0; i < img.getHeight(); i++)
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = new Color(img.getRGB(j, i));
                int value = color.getGreen();
                if (value == CRABBY)
                    list.add(new Crabby(j * Game.TILES_SIZE, i * Game.TILES_SIZE));
            }
        return list;
    }

    public static int[][] getLevelData() {
        BufferedImage img = getPositionsAtlas(LEVEL_ONE_DATA);
        int[][] levelData = new int[img.getHeight()][img.getWidth()];
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = new Color(img.getRGB(j, i));
                int value = color.getRed();
                if (value >= 12 * 4)
                    value = 0;
                levelData[i][j] = value;
            }
        }
        return levelData;
    }
}
