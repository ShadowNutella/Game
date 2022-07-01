package ui;

import main.AnimatedBufferedImage;
import scene.Scene;

public class MapUIRosa extends UI {

    private AnimatedBufferedImage keyImage = new AnimatedBufferedImage("/objects/key_rosa");

    public MapUIRosa(Scene gp) {

        super(gp);

    }

    public void drawUI() {

        super.drawUI();

        graphics.drawImage(keyImage.getImage(), 0, 0, gp.getTileSize(), gp.getTileSize(), null);
        graphics.drawString("x " + gp.playerOne.inventory.getKeyCount(), 65, 40);

    }

}
