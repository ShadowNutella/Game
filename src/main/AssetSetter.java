package main;

import entity.Item;


public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;

    }

    public void createItems() {

        Item i;
        i = new Item("key", 12 * gp.tileSize, 10 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

        i = new Item("key",77 * gp.tileSize , 24 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

        i = new Item("key", 69 * gp.tileSize, 18 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

        i = new Item("key", 78 * gp.tileSize, 4 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

        i = new Item("key", 55 * gp.tileSize, 11 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

        i = new Item("key", 53 * gp.tileSize, 4 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

        i = new Item("key", 8 * gp.tileSize, 26 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

        i = new Item("key", 29 * gp.tileSize, 22 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

        i = new Item("key", 23 * gp.tileSize, 12 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

        i = new Item("key", 10 * gp.tileSize, 9 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

    }



}
