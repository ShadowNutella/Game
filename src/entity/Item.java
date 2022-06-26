package entity;

import java.awt.*;

public class Item extends Entity {

    public Item(String name, int x, int y, String farbe) {

        super("/objects/" + name + "_" + farbe, x, y);
        solidPart = new Rectangle(0, 0, 64, 64);
    }
}
