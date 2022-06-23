package entity;

import main.AnimatedBufferedImage;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Enemy extends Entity {
    String resourcePath;

    public Enemy()
    {

    }
    public Enemy(String resourcePath, int x, int y) {

        this.x = x;
        this.y = y;
        this.resourcePath = resourcePath;
        getPlayerImage();
    }

    public void getPlayerImage() {
        image = new AnimatedBufferedImage(resourcePath);
    }
}
