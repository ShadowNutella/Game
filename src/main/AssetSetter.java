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

        gp.obj[0] = new Objects("key", 550, 350, "blau", false);

        gp.obj[1] = new Objects("key", 400, 200, "blau", false);

    }


    public void drawObjects(Graphics2D o1, GamePanel gp) {

        for (int worldCol = 0; worldCol < gp.maxWorldCol; worldCol++) {
            for (int worldRow = 0; worldRow < gp.maxWorldRow; worldRow++) {
                int tileNum = mapTileNum[worldCol][worldRow];

                int worldX = worldCol * gp.tileSize;
                int worldY = worldRow * gp.tileSize;

                int screenX = worldX - Camera.getAbsoluteX();
                int screenY = worldY - Camera.getAbsoluteY();

                o1.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null); //* "Malt" die Tiles für die Umgebung
            }
        }

    }

}
