package main;

import entity.Item;


public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;

    }

    public void createItems() {

        Item i;
        i = new Item("key", 30 * gp.tileSize, 8 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

        i = new Item("key",77 * gp.tileSize , 24 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

        i = new Item("key", 69 * gp.tileSize, 18 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

        i = new Item("key", 77 * gp.tileSize, 4 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

        i = new Item("key", 55 * gp.tileSize, 10 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

        i = new Item("key", 42 * gp.tileSize, 4 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

        i = new Item("key", 32 * gp.tileSize, 25 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

        i = new Item("key", 15 * gp.tileSize, 25 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

        i = new Item("key", 22 * gp.tileSize, 13 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

        i = new Item("key", 5 * gp.tileSize, 10 * gp.tileSize, "blau");
        i.collisionOn = true;
        gp.items.add(i);

    }



}
