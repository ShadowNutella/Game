package entity.item;

import entity.Entity;
import main.AnimatedBufferedImage;
import main.Camera;
import main.ItemHolder;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HealthBar extends Entity {

    public ItemHolder inventory;

    public HealthBar(String resourcePath, int x, int y) {

        super(resourcePath, x, y);
    }

    public void loadImages() {

        image = new AnimatedBufferedImage(resourcePath,0, false);
    }


    public void updateEntity() {

    }


    public void draw(Graphics2D h) {

        /* Numbers of Frames of the different states of the HP-Bar Texture are linked to the Players HP, so depending on
           how much HP the Player has, it shows the right Texture of the HP-Bar. */
        BufferedImage img = image.getFrame(inventory.HP);
        int finalSizeX = (int) ((double) Camera.instance.gp.getTileSize() * 2);
        int finalSizeY = (int) ((double) Camera.instance.gp.getTileSize() * 2);
        if (image != null) {
            h.drawImage(img, x, y, finalSizeX, finalSizeY, null);
        }
    }

}
