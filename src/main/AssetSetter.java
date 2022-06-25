package main;

import tile.Tile;
import object.Item;


public class AssetSetter {

    public Tile[] tile;
    public int[][] mapTileNum;

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;

    }

    public void createItems() {

        gp.items[0] = new Item("key", 550, 350, "blau");

        gp.items[1] = new Item("key", 400, 200, "blau");

    }



}
