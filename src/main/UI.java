package main;

import entity.InteractiveItem;

import java.awt.*;


public class UI {

    public static UI instance;
    GamePanel gp;

    Graphics2D graphics;
    Font arial_30;

    String currentMessage = "";

    AnimatedBufferedImage keyImage = new AnimatedBufferedImage("/objects/key_blau");


    public UI(GamePanel gp) {

        instance = this;
        this.gp = gp;
        arial_30 = new Font("Monospaced", Font.BOLD, 30);

    }

    public void showMessage(String text, int duration) {
        currentMessage = text;
        // ? Duration irgendwie ausstellen nach gewisser Zeit
    }


    public void drawUI() {
        graphics.setFont(arial_30);
        graphics.setColor(Color.white);
        graphics.drawImage(keyImage.getImage(), 0, 0, gp.tileSize, gp.tileSize, null);
        graphics.drawString("x " + gp.playerOne.inventory.getKeyCount(), 65, 40);

        graphics.drawString(currentMessage, 50, 50);

    }

}
