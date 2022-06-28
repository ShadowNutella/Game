package ui;

import main.AnimatedBufferedImage;
import scene.Scene;

public class MapUILila extends UI {

    private AnimatedBufferedImage keyImage = new AnimatedBufferedImage("/objects/key_lila");

    public MapUILila(Scene gp) {

        super(gp);

    }

    public void drawUI() {

        super.drawUI();

        graphics.drawImage(keyImage.getImage(), 0, 0, gp.getTileSize(), gp.getTileSize(), null);
        graphics.drawString("x " + gp.playerOne.inventory.getKeyCount(), 65, 40);

    }

}
