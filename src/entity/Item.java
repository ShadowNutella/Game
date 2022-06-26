package entity;

import java.awt.*;

public class Item extends Entity {

    public boolean collision = false;

    public Rectangle solidPartObject = new Rectangle(0, 0, 64, 64);

    public int solidPartX = 0;
    public int solidPartY = 0;

    public Item(String name, int x, int y, String farbe) {

        super("/objects/" + name + "_" + farbe, x, y);
    }
}
