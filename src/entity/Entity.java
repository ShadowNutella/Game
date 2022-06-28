package entity;

import main.AnimatedBufferedImage;
import main.Camera;

import java.awt.*;

// Base class for all entities in the game, characters, items etc.
public class Entity {

    // Coordinates of entity, measured on top left corner
    public int x, y;

    public AnimatedBufferedImage image; // Image of entity
    public String resourcePath; // path to the image file
    public double sizeX = 1.0, sizeY = 1.0; // x and y size modifier
    public int drawPriority = 1; // Priority of drawing, the higher the priority the later it will be drawn (useful for stacking)
    public Rectangle solidPart;// Hitbox of entity, measured on top left corner
    public boolean collisionOn = false;
    public boolean alive = true;

    public Entity() {

        image = new AnimatedBufferedImage();
    }

    public Entity(String resourcePath) {
        this.resourcePath = resourcePath;
        loadImages();
    }

    public Entity(String resourcePath, int x, int y) {
        this.resourcePath = resourcePath;
        this.x = x;
        this.y = y;
        loadImages();
    }

    // Loads all needed images from resource path
    public void loadImages() {

        image = new AnimatedBufferedImage(resourcePath);
    }

    public void setAnimationSpeed(int animationSpeed) {

        image.animationSpeed = animationSpeed;
    }

    public void updateEntity() {

            image.advance();
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

    public void setSize(double size) {
        setSize(size, size);
    }


    public void draw(Graphics2D p) {
        int finalSizeX = (int) ((double) Camera.instance.gp.getTileSize() * sizeX);
        int finalSizeY = (int) ((double) Camera.instance.gp.getTileSize() * sizeY);
        if (image != null) {
            p.drawImage(image.getImage(), x - Camera.getAbsoluteX(), y - Camera.getAbsoluteY(), finalSizeX, finalSizeY, null); //* "Malt" den Charakter an Stelle XY plus dessen "Animation"
        }
    }

}

