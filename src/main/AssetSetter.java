package main;

import tile.Tile;
import object.Object;


public class AssetSetter {

    public Tile[] tile;
    public int[][] mapTileNum;

    public java.lang.Object obj[] = new java.lang.Object[10];

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;

    }

    public void setObject() {

        gp.obj[0] = new Object("key", 550, 350, "blau");

        gp.obj[1] = new Object("key", 400, 200, "blau");

    }



}
