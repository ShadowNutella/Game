package entity;

import main.AnimatedBufferedImage;
import main.Camera;
import main.ItemHolder;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HealthBar extends Entity {

    public ItemHolder inventory;
    public HealthBar() {

        super();

    }

    public HealthBar(String resourcePath) {

        super(resourcePath);
    }

    public HealthBar(String resourcePath, int x, int y) {

        super(resourcePath, x, y);
    }

    public void loadImages() {

        image = new AnimatedBufferedImage(resourcePath, 0);
    }


    public void updateEntity() {

    }


    public void draw(Graphics2D h) {

        BufferedImage img = image.getFrame(inventory.HP);
        int finalSizeX = (int) ((double) Camera.instance.gp.getTileSize() * sizeX);
        int finalSizeY = (int) ((double) Camera.instance.gp.getTileSize() * sizeY);
        if (image != null) {
            h.drawImage(img, x, y, finalSizeX, finalSizeY, null);
        }
    }

}
