package entity;

import main.AnimatedBufferedImage;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity{

    public int x, y;

    public AnimatedBufferedImage image = new AnimatedBufferedImage();
    public double sizeX = 1.0, sizeY = 1.0;
    public int drawPriority = 1;
    public Rectangle solidPart;
    public boolean collisionOn = false;

    public Entity()
    {

    }

    public void setAnimationSpeed(int animationSpeed)
    {

        image.animationSpeed = animationSpeed;
    }

    public void update()
    {
        image.advance();
    }

    public Entity(int x, int y, AnimatedBufferedImage image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public void setSizeX(double sizeX) {
        this.sizeX = sizeX;
    }

    public void setSizeY(double sizeY) {
        this.sizeY = sizeY;
    }

    public void setSize(double sizeX, double sizeY) {
        setSizeX(sizeX);
        setSizeY(sizeY);
    }

    public void setSize(double size)
    {
        setSize(size, size);
    }


    public void draw(Graphics2D p) {
        int finalSizeX = (int) ((double) Camera.instance.gp.tileSize * sizeX);
        int finalSizeY = (int) ((double) Camera.instance.gp.tileSize * sizeY);
        if (image != null) {
            p.drawImage(image.getImage(), x - Camera.getAbsoluteX(), y - Camera.getAbsoluteY(), finalSizeX, finalSizeY, null); //* "Malt" den Charakter an Stelle XY plus dessen "Animation"
        }
    }

}

