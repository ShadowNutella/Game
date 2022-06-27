package main;

public class MapUILila extends UI {

    AnimatedBufferedImage keyImage = new AnimatedBufferedImage("/objects/key_blau");

    public MapUILila(GamePanel gp) {

        super(gp);

    }

    public void drawUI() {

        super.drawUI();

        graphics.drawImage(keyImage.getImage(), 0, 0, gp.tileSize, gp.tileSize, null);
        graphics.drawString("x " + gp.playerOne.inventory.getKeyCount(), 65, 40);

    }

}
