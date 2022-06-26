package main;

import entity.InteractiveItem;

import java.awt.*;


public class UI {

    GamePanel gp;
    Font arial_30;

    AnimatedBufferedImage keyImage = new AnimatedBufferedImage("/objects/key_blau");


    public UI(GamePanel gp) {

        this.gp = gp;

        arial_30 = new Font("Monospaced", Font.BOLD, 30);

    }

    public void showMessage(Graphics2D m) {

        m.drawString(String text, 50, 50);

    }


    public void drawUI(Graphics2D u) {

        u.setFont(arial_30);
        u.setColor(Color.white);
        u.drawImage(keyImage.getImage(), 0, 0, gp.tileSize, gp.tileSize, null);
        u.drawString("x " + gp.playerOne.inventory.getKeyCount(), 65, 40);

    }

}
