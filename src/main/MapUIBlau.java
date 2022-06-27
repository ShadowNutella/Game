package main;

public class MapUIBlau extends UI {

    AnimatedBufferedImage keyImage = new AnimatedBufferedImage("/objects/key_blau");

    public MapUIBlau(GamePanel gp) {

        super(gp);

    }

    public void drawUI() {

        super.drawUI();

        graphics.drawImage(keyImage.getImage(), 0, 0, gp.tileSize, gp.tileSize, null);
        graphics.drawString("x " + gp.playerOne.inventory.getKeyCount(), 65, 40);

    }

}
