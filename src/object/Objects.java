package object;

import entity.Camera;
import main.GamePanel;
import tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Objects {

    public BufferedImage image;





    public Objects(String name, int objX, int objY, String farbe, tile.collision) {


        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/" + name + "_" + farbe + ".png"));
        }catch(IOException e) {
            e.printStackTrace();
        }

    }

    public void drawObjects(Graphics2D o) {

        int finalSizeX = (int) ((double) Camera.instance.gp.tileSize * sizeX);
        int finalSizeY = (int) ((double) Camera.instance.gp.tileSize * sizeY);

        if (image != null) {
                o.drawImage(image.getImage(), objX - Camera.getAbsoluteX(), objY - Camera.getAbsoluteY(), finalSizeX, finalSizeY, null);
        }
    }



}
