package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class UI {

    public static UI instance;
    GamePanel gp;

    Graphics2D graphics;
    public Font arial_30;

    private String currentMessage = "";
    private int messageTimer = 0;

    private boolean closing = true;
    private boolean opening = false;
    private int sceneChangeTimer = 0;
    private int sceneChangeTimerTarget = 60;


    AnimatedBufferedImage keyImage = new AnimatedBufferedImage("/objects/key_blau");


    public UI(GamePanel gp) {

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
        graphics.drawImage(keyImage.getImage(), 0, 0, gp.tileSize, gp.tileSize, null);
        graphics.drawString("x " + gp.playerOne.inventory.getKeyCount(), 65, 40);

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

    public void startClosing(int duration)
    {
        sceneChangeTimer = 0;
        sceneChangeTimerTarget = duration;
        closing = true;
        opening = false;
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
        sizeX = (int) (percentage * (gp.screenWidth / 2));
        sizeY = (int) (percentage * (gp.screenHeight / 2));
        // Screen: 1280x768

        graphics.drawImage(curtain, 0, 0, sizeX, gp.screenHeight, null); //Left
        graphics.drawImage(curtain, gp.screenWidth - sizeX, 0, gp.screenWidth, gp.screenHeight, null); //Right
        graphics.drawImage(curtain, 0, 0, gp.screenWidth, sizeY, null); //Top
        graphics.drawImage(curtain, 0, gp.screenHeight - sizeY, gp.screenWidth, gp.screenHeight, null); //Bottom

        sceneChangeTimer++;
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
        sizeX = (int) (percentage * (gp.screenWidth / 2));
        sizeY = (int) (percentage * (gp.screenHeight / 2));
        // Screen: 1280x768

        graphics.drawImage(curtain, 0, 0, sizeX, gp.screenHeight, null); //Left
        graphics.drawImage(curtain, gp.screenWidth - sizeX, 0, gp.screenWidth, gp.screenHeight, null); //Right
        graphics.drawImage(curtain, 0, 0, gp.screenWidth, sizeY, null); //Top
        graphics.drawImage(curtain, 0, gp.screenHeight - sizeY, gp.screenWidth, gp.screenHeight, null); //Bottom

        sceneChangeTimer--;
    }

}
