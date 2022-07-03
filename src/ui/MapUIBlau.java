package ui;

import main.AnimatedBufferedImage;
import scene.Scene;

// UI for the current Map
public class MapUIBlau extends UI {

    private AnimatedBufferedImage keyImage = new AnimatedBufferedImage("/objects/key_blau");

    public MapUIBlau(Scene gp) {

        super(gp);

    }

    // Displays the amount of collected Keys and an Icon of the Keys next to it on the top left corner of the Screen.
    public void drawUI() {

        super.drawUI();

        graphics.drawImage(keyImage.getImage(), 0, 0, gp.getTileSize(), gp.getTileSize(), null);
        graphics.drawString("x " + gp.playerOne.inventory.getKeyCount(), 65, 40);

    }

}
