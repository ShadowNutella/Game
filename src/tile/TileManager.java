package tile;

import entity.Camera;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;


    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[66];
        mapTileNum = new int[gp.maxWorldCol] [gp.maxWorldRow];

        getTileImage("Rosa", "rosa");
        loadMap("/maps/worldblau.txt");
    }

    public void getTileImage(String farbe1, String farbe2) {

        try {

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/gras_" + farbe2 + ".png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/water_" + farbe2 + ".png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/bush_" + farbe2 + ".png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/fluss_ecke_links_unten_" + farbe2 + ".png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/fluss_ecke_rechts_unten_" + farbe2 + ".png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/fluss_ecke_links_oben_" + farbe2 + ".png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/fluss_ecke_rechts_oben_" + farbe2 + ".png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/fluss_gerade_1_unten_" + farbe2 + ".png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/fluss_gerade_2_unten_" + farbe2 + ".png"));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/fluss_gerade_oben_" + farbe2 + ".png"));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/fluss_gerade_links_" + farbe2 + ".png"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/fluss_gerade_rechts_" + farbe2 + ".png"));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/fluss_kurve_1_links_" + farbe2 + ".png"));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/fluss_kurve_2_links_" + farbe2 + ".png"));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/fluss_kurve_1_rechts_" + farbe2 + ".png"));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/fluss_kurve_2_rechts_" + farbe2 + ".png"));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/mauer_" + farbe2 + ".png"));
            tile[16].collision = true;

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/mauer_" + farbe2 + "_gras.png"));
            tile[17].collision = true;

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/mauer_tor_" + farbe2 + "_unten_links.png"));
            tile[18].collision = true;

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/mauer_tor_" + farbe2 + "_unten_rechts.png"));
            tile[19].collision = true;

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/mauer_tor_" + farbe2 + "_oben_links.png"));
            tile[20].collision = true;

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles" + farbe1 + "/mauer_tor_" + farbe2 + "_oben_rechts.png"));
            tile[21].collision = true;



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath) {

        try {

            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            for(int row = 0; row < gp.maxWorldRow; row++)
            {
                String line = br.readLine();
                String[] numbers = line.split(" ");

                for(int col = 0; col < gp.maxWorldCol; col++)
                {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col] [row] = num;
                }
            }
            br.close();

        } catch (Exception e) {

        }
    }

    public void drawWorldTiles(Graphics2D w1) {

        for(int worldCol = 0; worldCol < gp.maxWorldCol; worldCol++)
        {
            for(int worldRow = 0; worldRow < gp.maxWorldRow; worldRow++)
            {
                int tileNum = mapTileNum[worldCol] [worldRow];

                int worldX = worldCol * gp.tileSize;
                int worldY = worldRow * gp.tileSize;

                int screenX = worldX - Camera.getAbsoluteX();
                int screenY = worldY - Camera.getAbsoluteY();

                w1.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null); //* "Malt" die Tiles für die Umgebung
            }
        }

    }
}
