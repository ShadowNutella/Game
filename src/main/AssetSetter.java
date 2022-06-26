package main;

import entity.Item;


public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;

    }

    public void createItems() {

        gp.items[0] = new Item("key", 12 * gp.tileSize, 10 * gp.tileSize, "blau");
        gp.items[0].collision = true;

        gp.items[1] = new Item("key",77 * gp.tileSize , 24 * gp.tileSize, "blau");
        gp.items[1].collision = true;

        gp.items[2] = new Item("key", 69 * gp.tileSize, 18 * gp.tileSize, "blau");
        gp.items[2].collision = true;

        gp.items[3] = new Item("key", 78 * gp.tileSize, 4 * gp.tileSize, "blau");
        gp.items[3].collision = true;

        gp.items[4] = new Item("key", 55 * gp.tileSize, 11 * gp.tileSize, "blau");
        gp.items[4].collision = true;

        gp.items[5] = new Item("key", 53 * gp.tileSize, 4 * gp.tileSize, "blau");
        gp.items[5].collision = true;

        gp.items[6] = new Item("key", 8 * gp.tileSize, 26 * gp.tileSize, "blau");
        gp.items[6].collision = true;

        gp.items[7] = new Item("key", 29 * gp.tileSize, 22 * gp.tileSize, "blau");
        gp.items[7].collision = true;

        gp.items[8] = new Item("key", 23 * gp.tileSize, 12 * gp.tileSize, "blau");
        gp.items[8].collision = true;

        gp.items[9] = new Item("key", 10 * gp.tileSize, 9 * gp.tileSize, "blau");
        gp.items[9].collision = true;

    }



}
