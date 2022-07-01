package entity;

import entity.item.Item;
import entity.keyhandler.KeyHandler;
import main.AnimatedBufferedImage;
import main.Camera;
import main.ItemHolder;
import scene.Scene;

import java.awt.*;

public class FightPlayer extends Player {

    KeyHandler keyH;

    public AnimatedBufferedImage particleOnePL1 = new AnimatedBufferedImage("/objects/abilities/abilityOne_dragon_left_1");
    public AnimatedBufferedImage particleOnePR1 = new AnimatedBufferedImage("/objects/abilities/abilityOne_dragon_right_1");
    Graphics2D particles;

    public FightPlayer(Scene gp, KeyHandler keyH, String resourcePath, int speed, int x, int y, ItemHolder inventory) {
        super();
        this.x = x;
        this.y = y;
        this.gp = gp;
        this.keyH = keyH;
        this.resourcePath = resourcePath;
        this.speed = speed;
        this.inventory = inventory;
        this.direction = "right";
        loadImages();

        solidPart = new Rectangle(6, 34, 58, 30);
    }

    public void setAnimationSpeed(int animationSpeed) {
        image.animationSpeed = animationSpeed;
    }

    public void loadImages() {
        image = new AnimatedBufferedImage(resourcePath + "back");
    }

    public void updateEntity() {
        image.advance();
    }


    public void updatePlayerOne() {


        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed || keyH.abilityOne) {

            //Player 1
            if (keyH.upPressed) {


            } else if (keyH.downPressed) {


            } else if (keyH.leftPressed) {
                direction = "left";

            }
            else if (keyH.abilityOne) {

                System.out.println("Ability Player 1");
                particles.drawImage(particleOnePL1.getImage(), 0, 0, gp.getTileSize(), gp.getTileSize(), null);
                particles.drawImage(particleOnePR1.getImage(),0,0,gp.getTileSize(), gp.getTileSize(), null);

            }  else {
                direction = "right";

            }


            //Check Tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //Check Object collision -> Returns array with all colliding objects

            //If collision is false, player can move
            if (!collisionOn) {
                switch (direction) {
                    case "left" -> x -= speed;
                    case "right" -> x += speed;
                }

            }
        }  else {
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

    public void updatePlayerTwo() {

        if (keyH.upPressed2 || keyH.downPressed2 || keyH.leftPressed2 || keyH.rightPressed2 || keyH.abilityOne2) {

            //Player 1
            if (keyH.upPressed2) {


            } else if (keyH.downPressed2) {


            } else if (keyH.leftPressed2) {
                direction = "left";

            }
            else if (keyH.abilityOne2) {

                System.out.println("Ability Player 2");
                /**particles.drawImage(particleOnePL2.getImage(), 0, 0, gp.getTileSize(), gp.getTileSize(), null);
                particles.drawImage(particleOnePR2.getImage(),0,0,gp.getTileSize(), gp.getTileSize(), null);**/

            }  else {
                direction = "right";

            }

            collisionOn = false;
            gp.cChecker.checkTile(this);

            //Check Object collision -> Returns array with all colliding objects


            //If collision is false, player can move
            if (!collisionOn) {

                switch (direction) {
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
        int finalSizeX = (int) (Camera.instance.gp.getTileSize() * sizeX);
        int finalSizeY = (int) (Camera.instance.gp.getTileSize() * sizeY);
        p.drawImage(image.getImage(), x - Camera.getAbsoluteX(), y - Camera.getAbsoluteY(), finalSizeX, finalSizeY, null); //* "Malt" den Charakter an Stelle XY plus dessen "Animation"
    }
}
