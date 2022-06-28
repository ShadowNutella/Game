package entity;

import entity.item.Item;
import main.AnimatedBufferedImage;
import main.Camera;
import scene.Scene;
import main.ItemHolder;
import entity.item.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    Scene gp;
    KeyHandler keyH;
    public int speed;
    public AnimatedBufferedImage front, back, left, right;
    public String direction;

    public ItemHolder inventory;


    public Player(Scene gp, KeyHandler keyH, String resourcePath, int speed, int x, int y, ItemHolder inventory) {
        super(resourcePath, x, y);
        direction = "right";
        this.gp = gp;
        this.keyH = keyH;
        this.speed = speed;
        this.inventory = inventory;

        solidPart = new Rectangle(6, 34, 58, 30);

    }

    public void setAnimationSpeed(int animationSpeed) {
        front.animationSpeed = animationSpeed;
        back.animationSpeed = animationSpeed;
        left.animationSpeed = animationSpeed;
        right.animationSpeed = animationSpeed;
    }

    public void loadImages() {
        front = new AnimatedBufferedImage(resourcePath + "front");
        back = new AnimatedBufferedImage(resourcePath + "back");
        left = new AnimatedBufferedImage(resourcePath + "left");
        right = new AnimatedBufferedImage(resourcePath + "right");
    }

    public void update() {
        front.advance();
        back.advance();
        left.advance();
        right.advance();
    }

    public void updatePlayerOne() {
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {

            //Player 1
            if (keyH.upPressed) {
                direction = "back";

            } else if (keyH.downPressed) {
                direction = "front";

            } else if (keyH.leftPressed) {
                direction = "left";

            } else if (keyH.rightPressed) {
                direction = "right";

            }

            //Check Tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //Check Object collision -> Returns array with all colliding objects

            Item[] collisions = gp.cChecker.checkObjects(this);
            for (int i = 0; i < collisions.length; i++) {
                boolean remove = collisions[i].pickUp(this);
                if (remove)
                    gp.items.remove(collisions[i]);
            }

            //If collision is false, player can move
            if (!collisionOn) {
                switch (direction) {
                    case "back" -> y -= speed;
                    case "front" -> y += speed;
                    case "left" -> x -= speed;
                    case "right" -> x += speed;
                }

            }
        } else {
            setAnimationSpeed(0);
        }

    }

    public void updatePlayerTwo() {
        if (keyH.upPressed2 || keyH.downPressed2 || keyH.leftPressed2 || keyH.rightPressed2) {

            //Player 2
            if (keyH.upPressed2) {
                direction = "back";

            } else if (keyH.downPressed2) {
                direction = "front";

            } else if (keyH.leftPressed2) {
                direction = "left";

            } else if (keyH.rightPressed2) {
                direction = "right";

            }

            collisionOn = false;
            gp.cChecker.checkTile(this);

            //Check Object collision -> Returns array with all colliding objects

            Item[] collisions = gp.cChecker.checkObjects(this);
            for (int i = 0; i < collisions.length; i++) {
                boolean remove = collisions[i].pickUp(this);
                if (remove)
                    gp.items.remove(collisions[i]);
            }

            //If collision is false, player can move
            if (!collisionOn) {

                switch (direction) {
                    case "back" -> y -= speed;
                    case "front" -> y += speed;
                    case "left" -> x -= speed;
                    case "right" -> x += speed;
                }

            }
        } else {
            setAnimationSpeed(0);
        }
    }

    public void draw(Graphics2D p) {

        BufferedImage image = switch (direction) {
            case "back" -> back.getImage();
            case "front" -> front.getImage();
            case "left" -> left.getImage();
            case "right" -> right.getImage();
            default -> null;
        };

        int finalSizeX = (int) (Camera.instance.gp.getTileSize() * sizeX);
        int finalSizeY = (int) (Camera.instance.gp.getTileSize() * sizeY);
        p.drawImage(image, x - Camera.getAbsoluteX(), y - Camera.getAbsoluteY(), finalSizeX, finalSizeY, null); //* "Malt" den Charakter an Stelle XY plus dessen "Animation"
    }
}
