package ui;

import gamestates.GameState;
import gamestates.Playing;
import main.Game;
import utils.Constants;
import utils.LoadSave;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static utils.Constants.UI.PauseButtons.SOUND_SIZE;
import static utils.Constants.UI.URMButtons.URM_SIZE;
import static utils.Constants.UI.VolumeButtons.*;

public class PauseOverlay {
    private BufferedImage backgroundImg;
    private int backgroundX, backgroundY, backgroundWidth, backgroundHeight;
    private SoundButton musicButton, soundEffectsButton;
    private UrmButton menuB, replyB, unpauseB;
    private Playing playing;
    private VolumeButton volumeButton;

    public PauseOverlay(Playing playing) {
        this.playing = playing;
        loadBackground();
        createSoundButtons();
        createUrmButtons();
        createVolumeButton();
    }

    private void createVolumeButton() {
        int vX = (int) (309 * Game.SCALE);
        int vY = (int) (278 * Game.SCALE);
        volumeButton = new VolumeButton(vX, vY, SLIDER_WIDTH, VOLUME_HEIGHT);
    }

    private void createUrmButtons() {
        int menuX = (int) (313 * Game.SCALE);
        int replyX = (int) (387 * Game.SCALE);
        int unpauseX = (int) (462 * Game.SCALE);
        int bY = (int) (325 * Game.SCALE);
        menuB = new UrmButton(menuX, bY, URM_SIZE, URM_SIZE, 2);
        replyB = new UrmButton(replyX, bY, URM_SIZE, URM_SIZE, 1);
        unpauseB = new UrmButton(unpauseX, bY, URM_SIZE, URM_SIZE, 0);

    }

    private void createSoundButtons() {
        int soundX = (int) (450 * Game.SCALE);
        int musicY = (int) (140 * Game.SCALE);
        int soundEffectsY = (int) (186 * Game.SCALE);
        musicButton = new SoundButton(soundX, musicY, SOUND_SIZE, SOUND_SIZE);
        soundEffectsButton = new SoundButton(soundX, soundEffectsY, SOUND_SIZE, SOUND_SIZE);

    }

    private void loadBackground() {
        backgroundImg = LoadSave.getPositionsAtlas(LoadSave.PAUSE_BACKGROUND);
        backgroundWidth = (int) (backgroundImg.getWidth() * Game.SCALE);
        backgroundHeight = (int) (backgroundImg.getHeight() * Game.SCALE);
        backgroundX = Game.GAME_WIDTH / 2 - backgroundWidth / 2;
        backgroundY = (int) (25 * Game.SCALE);

    }

    public void update() {
        musicButton.update();
        soundEffectsButton.update();
        menuB.update();
        replyB.update();
        unpauseB.update();
        volumeButton.update();
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(backgroundImg, backgroundX, backgroundY, backgroundWidth, backgroundHeight, null);
        musicButton.draw(graphics);
        soundEffectsButton.draw(graphics);
        menuB.draw(graphics);
        replyB.draw(graphics);
        unpauseB.draw(graphics);
        volumeButton.draw(graphics);
    }

    public void mouseDragged(MouseEvent e) {
        if(volumeButton.isMousePressed())
            volumeButton.changeX(e.getX());
    }

    public void mousePressed(MouseEvent e) {
        if (isIn(e, musicButton))
            musicButton.setMousePressed(true);
        else if (isIn(e, soundEffectsButton))
            soundEffectsButton.setMousePressed(true);
        else if (isIn(e, menuB))
            menuB.setMousePressed(true);
        else if (isIn(e, replyB))
            replyB.setMousePressed(true);
        else if (isIn(e, unpauseB))
            unpauseB.setMousePressed(true);
        else if (isIn(e, volumeButton))
            volumeButton.setMousePressed(true);
    }

    public void mouseReleased(MouseEvent e) {
        if (isIn(e, musicButton)) {
            if (musicButton.isMousePressed())
                musicButton.setMuted(!musicButton.isMuted());
        } else if (isIn(e, soundEffectsButton)) {
            if (soundEffectsButton.isMousePressed())
                soundEffectsButton.setMuted(!soundEffectsButton.isMuted());
        } else if (isIn(e, menuB)) {
            if (menuB.isMousePressed()) {
                GameState.state = GameState.MENU;
                playing.unpauseGame();
            }
        } else if (isIn(e, replyB)) {
            if (replyB.isMousePressed())
                System.out.println("reply level!");
        } else if (isIn(e, unpauseB)) {
            if (unpauseB.isMousePressed())
                playing.unpauseGame();
        }
        musicButton.resetBools();
        soundEffectsButton.resetBools();
        menuB.resetBools();
        replyB.resetBools();
        unpauseB.resetBools();
        volumeButton.resetBools();
    }

    public void mouseMoved(MouseEvent e) {
        musicButton.setMouseOver(false);
        soundEffectsButton.setMouseOver(false);
        menuB.setMouseOver(false);
        replyB.setMouseOver(false);
        unpauseB.setMouseOver(false);
        volumeButton.setMouseOver(false);

        if (isIn(e, musicButton))
            musicButton.setMouseOver(true);
        else if (isIn(e, soundEffectsButton))
            soundEffectsButton.setMouseOver(true);
        else if (isIn(e, menuB))
            menuB.setMouseOver(true);
        else if (isIn(e, replyB))
            replyB.setMouseOver(true);
        else if (isIn(e, unpauseB))
            unpauseB.setMouseOver(true);
        else if (isIn(e, volumeButton))
            volumeButton.setMouseOver(true);
    }

    private boolean isIn(MouseEvent e, PauseButton button) {
        return button.getBounds().contains(e.getX(), e.getY());
    }
}
