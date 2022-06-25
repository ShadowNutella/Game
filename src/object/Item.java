package object;

import entity.Camera;
import entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Item extends Entity {

    public Item(String name, int x, int y, String farbe) {
        super("/objects/" + name + "_" + farbe, x, y);
    }
}
