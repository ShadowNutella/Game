package main;

import tile.Tile;
import entity.Camera;
import object.Objects;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;



public class AssetSetter {

    public Tile[] tile;
    public int[][] mapTileNum;

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;

    }

    public void setObject() {

        gp.obj[0] = new Objects("key", 550, 350, "blau");

        gp.obj[1] = new Objects("key", 400, 200, "blau");

    }

}
