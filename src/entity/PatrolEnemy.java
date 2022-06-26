package entity;

import main.AnimatedBufferedImage;

public class PatrolEnemy extends Enemy {
    public AnimatedBufferedImage imageRight, imageLeft;
    public boolean moveLeft = false;
    public int patrolSpeed = 5;

    public TextInteractionItem textItem;

    public PatrolEnemy(String resourcePath, int x, int y) {
        super(resourcePath, x, y);
        textItem = new TextInteractionItem(0, 0, 128, 128, "Make way!", 120);
    }

    public void loadImages() {
        imageRight = new AnimatedBufferedImage(resourcePath + "right");
        imageLeft = new AnimatedBufferedImage(resourcePath + "left");
        image = imageRight;
    }

    public void move() {
        if (moveLeft) {
            x -= patrolSpeed;
            image = imageLeft;
        } else {
            x += patrolSpeed;
            image = imageRight;
        }
        textItem.x = x;
        textItem.y = y;
    }
}
