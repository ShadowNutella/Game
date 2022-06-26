package entity;

import main.ItemHolder;

import java.awt.*;

public class Item extends Entity {


    public Item(String name, int x, int y, String farbe) {

        super("/objects/" + name + "_" + farbe, x, y);
        solidPart = new Rectangle(0, 0, 64, 64);
    }


    public boolean pickUp(Player player) {

        player.inventory.collectItem(this);
        return true;
    }

}
