package entity;

import main.AnimatedBufferedImage;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PatrolEnemy extends Enemy {
    String resourcePath;
    public AnimatedBufferedImage imageRight, imageLeft;
    public boolean moveLeft = false;
    public int patrolSpeed = 5;

    public PatrolEnemy(String resourcePath, int x, int y) {
        this.x = x;
        this.y = y;
        this.resourcePath = resourcePath;
        getPlayerImage();
    }

    public void getPlayerImage() {
        imageRight = new AnimatedBufferedImage(resourcePath + "right");
        imageLeft = new AnimatedBufferedImage(resourcePath + "left");
        image = imageRight;
    }

    public void move()
    {
        if(moveLeft)
        {
            x -= patrolSpeed;
            image = imageLeft;
        }
        else
        {
            x += patrolSpeed;
            image = imageRight;
        }
    }
}
