package entity;

import entity.item.TextInteractionItem;
import main.AnimatedBufferedImage;

public class PatrolEnemy extends Enemy {
    public AnimatedBufferedImage imageRight, imageLeft;
    public boolean moveLeft = false;
    public int patrolSpeed = 5;

    public TextInteractionItem textItem;

    // Same as Enemy but adding a TextInteractionItem to them.
    public PatrolEnemy(String resourcePath, int x, int y, String messageText) {
        super(resourcePath, x, y);
        textItem = new TextInteractionItem(x, y, 128, 128, messageText, 120);
    }


    public void loadImages() {
        imageRight = new AnimatedBufferedImage(resourcePath + "right");
        imageLeft = new AnimatedBufferedImage(resourcePath + "left");
        image = imageRight;
    }

    // Method, so the Patroler can walk.
    public void move() {
        if (moveLeft) {
            x -= patrolSpeed;
            image = imageLeft;
        } else {
            x += patrolSpeed;
            image = imageRight;
        }
        // TextInteraction Item, which moves with the Patroler.
        textItem.x = x;
        textItem.y = y;
    }
}
