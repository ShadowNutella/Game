package entity.item;

import entity.Entity;
import entity.Player;
import main.ItemHolder;

import java.awt.*;

// Item is the same as an Entity but slightly different.
public class Item extends Entity {


    public Item(String resourcePath, int x, int y) {
        super(resourcePath, x, y);
    }

    /* String farbe to get the color needed of the item, since the items are available in different colors.
       String name in case there will be more different kinds of items in the future. */
    public Item(String name, int x, int y, String farbe) {

        super("/objects/" + name + "_" + farbe, x, y);
        solidPart = new Rectangle(0, 0, 64, 64);
    }

    // pickUp Method, calling the collectItem Method.
    public boolean pickUp(Player player) {

        player.inventory.collectItem(this);
        return true;
    }

}
