package object;

import entity.Camera;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Objects {

    public BufferedImage image;
    public int objX;
    public int objY;




    public Objects(String name, int objX, int objY, String farbe) {

        this.objX = objX;
        this.objY = objY;


        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/" + name + "_" + farbe + ".png"));
        }catch(IOException e) {

            e.printStackTrace();
        }

    }

    public void drawObjects(Graphics2D o) {

        int finalSizeX = (int) ((double) Camera.instance.gp.tileSize);
        int finalSizeY = (int) ((double) Camera.instance.gp.tileSize);

        if (image != null) {
                o.drawImage(image, objX - Camera.getAbsoluteX(), objY - Camera.getAbsoluteY(), finalSizeX, finalSizeY, null);
        }
    }



}
