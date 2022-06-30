package ui;

import main.AnimatedBufferedImage;
import scene.Scene;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class FightUILila extends UI {

    private AnimatedBufferedImage keyImage = new AnimatedBufferedImage("/objects/Leben_full");

    public FightUILila(Scene gp) {

        super(gp);

    }

    public void drawUI() {

        super.drawUI();



    }

    public void closeScene()
    {
        BufferedImage curtain;
        try {
            curtain = ImageIO.read(getClass().getResourceAsStream("/objects/black_tile.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int sizeX, sizeY;
        double percentage = (double) sceneChangeTimer / (double) sceneChangeTimerTarget;
        sizeX = (int) (percentage * 1280 / 2);
        sizeY = (int) (percentage * 768 / 2);
        // Screen: 1280x768

        graphics.drawImage(curtain, 0, 0, sizeX, 768, null); //Left
        graphics.drawImage(curtain, 1280 - sizeX, 0, 1280, 768, null); //Right
        graphics.drawImage(curtain, 0, 0, 1280, sizeY, null); //Top
        graphics.drawImage(curtain, 0, 768 - sizeY, 1280, 768, null); //Bottom

        sceneChangeTimer++;

        if (sceneChangeTimer == sceneChangeTimerTarget)
        {
            gp.setLevelStatus(statusToSet);
            closing = false;
        }
    }


    public void openScene()
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
        sizeX = (int) (percentage * 1280 / 2);
        sizeY = (int) (percentage * 768 / 2);
        // Screen: 1280x768

        graphics.drawImage(curtain, 0, 0, sizeX, 768, null); //Left
        graphics.drawImage(curtain, 1280 - sizeX, 0, 1280, 768, null); //Right
        graphics.drawImage(curtain, 0, 0, 1280, sizeY, null); //Top
        graphics.drawImage(curtain, 0, 768 - sizeY, 1280, 768, null); //Bottom

        sceneChangeTimer--;
    }

}
