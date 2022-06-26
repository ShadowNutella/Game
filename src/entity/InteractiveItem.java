package entity;

import java.awt.*;

public class InteractiveItem extends Item {

    public String text;

    public InteractiveItem(String name, int x, int y, String farbe, String text) {

        super(null, x, y, null);

        this.text = text;

    }

    public void loadImages() {

    }

    public void draw(Graphics2D p) {

    }

    public void pickUp(Player player) {

            if (player.inventory.getKeyCount() < 10) {

        }

    }

}
