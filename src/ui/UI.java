package ui;

import scene.LevelStatus;
import scene.Scene;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class UI {

    public static UI instance;
    public Scene gp;

    public Graphics2D graphics;
    public Font arial_30;

    private String currentMessage = "";
    private int messageTimer = 0;

    private boolean closing = true;
    private boolean opening = false;
    private int sceneChangeTimer = 0;
    private int sceneChangeTimerTarget = 60;

    private LevelStatus statusToSet; // Set this status after finished closing

    public UI(Scene gp) {

        instance = this;
        this.gp = gp;
        arial_30 = new Font("Monospaced", Font.BOLD, 30);

    }

    public void showMessage(String text, int duration) {
        currentMessage = text;
        messageTimer = duration;
    }


    public void drawUI() {
        graphics.setFont(arial_30);
        graphics.setColor(Color.white);

        if (messageTimer <= 0)
            currentMessage = "";
        graphics.drawString(currentMessage, 20, 80);
        messageTimer--;

        if (closing)
        {
            closeScene();
        }
        if (opening)
        {
            openScene();
        }
    }

    public void startClosing(int duration, LevelStatus status)
    {
        sceneChangeTimer = 0;
        sceneChangeTimerTarget = duration;
        closing = true;
        opening = false;
        statusToSet = status;
    }

    public void startOpening(int duration)
    {
        sceneChangeTimer = duration;
        sceneChangeTimerTarget = duration;
        closing = false;
        opening = true;
    }

    private void closeScene()
    {
        BufferedImage curtain;
        try {
            curtain = ImageIO.read(getClass().getResourceAsStream("/objects/black_tile.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int sizeX, sizeY;
        double percentage = (double) sceneChangeTimer / (double) sceneChangeTimerTarget;
        sizeX = (int) (percentage * (gp.getScreenWidth() / 2));
        sizeY = (int) (percentage * (gp.getScreenHeight() / 2));
        // Screen: 1280x768

        graphics.drawImage(curtain, 0, 0, sizeX, gp.getScreenHeight(), null); //Left
        graphics.drawImage(curtain, gp.getScreenWidth() - sizeX, 0, gp.getScreenWidth(), gp.getScreenHeight(), null); //Right
        graphics.drawImage(curtain, 0, 0, gp.getScreenWidth(), sizeY, null); //Top
        graphics.drawImage(curtain, 0, gp.getScreenHeight() - sizeY, gp.getScreenWidth(), gp.getScreenHeight(), null); //Bottom

        sceneChangeTimer++;

        if (sceneChangeTimer == sceneChangeTimerTarget)
        {
            gp.setLevelStatus(statusToSet);
            closing = false;
        }
    }

    private void openScene()
    {
        // Analog to closeScene()
        BufferedImage curtain;
        try {
            curtain = ImageIO.read(getClass().getResourceAsStream("/objects/black_tile.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int sizeX, sizeY;
        double percentage = (double) sceneChangeTimer / (double) sceneChangeTimerTarget;
        sizeX = (int) (percentage * (gp.getScreenWidth() / 2));
        sizeY = (int) (percentage * (gp.getScreenHeight() / 2));
        // Screen: 1280x768

        graphics.drawImage(curtain, 0, 0, sizeX, gp.getScreenHeight(), null); //Left
        graphics.drawImage(curtain, gp.getScreenWidth() - sizeX, 0, gp.getScreenWidth(), gp.getScreenHeight(), null); //Right
        graphics.drawImage(curtain, 0, 0, gp.getScreenWidth(), sizeY, null); //Top
        graphics.drawImage(curtain, 0, gp.getScreenHeight() - sizeY, gp.getScreenWidth(), gp.getScreenHeight(), null); //Bottom

        sceneChangeTimer--;
    }

}
