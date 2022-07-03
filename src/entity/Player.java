package entity;

import entity.item.Item;
import main.AnimatedBufferedImage;
import main.Camera;
import scene.Scene;
import main.ItemHolder;
import entity.keyhandler.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

// Player is another form of Entity but different.
public class Player extends Entity {

    // Sets the scene in which the Player is drawn.
    Scene gp;
    // Assigns the KeyHandler to the Player.
    KeyHandler keyH;
    // Setting for the speed of the Player.
    public int speed;
    // Creating different animated Images of the same Type (AnimatedBufferedImage).
    public AnimatedBufferedImage front, back, left, right;
    public String direction;
    public ItemHolder inventory;

    public Player() {
        super();
    }


    public Player(Scene gp, KeyHandler keyH, String resourcePath, int speed, int x, int y, ItemHolder inventory) {
        super(resourcePath, x, y);
        // Default direction when the Player is drawn
        direction = "right";
        this.gp = gp;
        this.keyH = keyH;
        this.speed = speed;
        this.inventory = inventory;

        // solidPart is the Hitbox of the Player, which is created here.
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

    public void updateEntity() {
        front.advance();
        back.advance();
        left.advance();
        right.advance();
    }

    // Updates the PlayerOne for every Frame. Checking for collision and if a key is pressed and if so, check which one.
    public void updatePlayerOne() {
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {

            // Controls of Player One
            if (keyH.upPressed) {
                direction = "back";

            } else if (keyH.downPressed) {
                direction = "front";

            } else if (keyH.leftPressed) {
                direction = "left";

            } else {
                direction = "right";

            }

            // Check Tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);


            // If collision is false, player can move
            if (!collisionOn) {
                switch (direction) {
                    case "back" -> y -= speed;
                    case "front" -> y += speed;
                    case "left" -> x -= speed;
                    case "right" -> x += speed;
                }

            }
            // If no key is pressed, the Players animation stops too.
        } else {
            setAnimationSpeed(0);
        }

        /* Creating variable tempSpeed, so the collision check happens right on where the Player is standing
            and not where it will be standing since the Items should be only collected if the Player is standing on them.*/
        int tempSpeed = speed;
        speed = 0;

        Item[] collisions = gp.cChecker.checkObjects(this);

            for (int i = 0; i < collisions.length; i++) {
                boolean remove = collisions[i].pickUp(this);
                    if (remove)
                    gp.items.remove(collisions[i]);
        }
        speed = tempSpeed;

    }

    public void updatePlayerTwo() {
        if (keyH.upPressed2 || keyH.downPressed2 || keyH.leftPressed2 || keyH.rightPressed2) {

            if (keyH.upPressed2) {
                direction = "back";

            } else if (keyH.downPressed2) {
                direction = "front";

            } else if (keyH.leftPressed2) {
                direction = "left";

            } else {
                direction = "right";

            }

            collisionOn = false;
            gp.cChecker.checkTile(this);

            //Check Object collision -> Returns array with all colliding objects

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

        int tempSpeed = speed;
        speed = 0;

        Item[] collisions = gp.cChecker.checkObjects(this);

            for (int i = 0; i < collisions.length; i++) {
                boolean remove = collisions[i].pickUp(this);
                    if (remove)
                    gp.items.remove(collisions[i]);
        }
        speed = tempSpeed;
    }

    public void draw(Graphics2D p) {

        // Depending on the Players direction, get the right Images.
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
