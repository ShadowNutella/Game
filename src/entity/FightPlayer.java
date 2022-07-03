package entity;

import entity.item.Item;
import entity.item.Particle;
import entity.keyhandler.KeyHandlerFight;
import main.AnimatedBufferedImage;
import main.Camera;
import main.ItemHolder;
import scene.Scene;

import java.awt.*;

public class FightPlayer extends Player {

    // Using different KeyHandler
    KeyHandlerFight keyH;


    // Same as Player but different KeyHandler
    public FightPlayer(Scene gp, KeyHandlerFight keyH, String resourcePath, int speed, int x, int y, ItemHolder inventory) {
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

        // If the Key for ability is pressed, call the attack Method.
        if (keyH.abilityOne) {
            attack("dragon");
        }

        if (keyH.leftPressed || keyH.rightPressed) {

            if (keyH.leftPressed) {
                direction = "left";
            }
            else {
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

        if (keyH.abilityOne2) {
            attack("fox");
        }

        if (keyH.leftPressed2 || keyH.rightPressed2 ) {

            //Player 1
            if (keyH.leftPressed2) {
                direction = "left";
            }
            else {
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

    // Method used to attack by spawning the textures of the attack on every Enemy on the list and dealing 1 damage to them.
    public void attack(String character) {

        Enemy[] enemies = Camera.instance.gp.getEnemies();
        Particle[] particles = new Particle[enemies.length];

        for (int i = 0; i < particles.length; i++) {
            particles[i] = new Particle("/objects/abilities/abilityOne_" + character + "_" + enemies[i].direction + "_", enemies[i].x + enemies[i].offsetX, enemies[i].y + enemies[i].offsetY, 20);


            particles[i].sizeX = enemies[i].sizeX;
            particles[i].sizeY = enemies[i].sizeY;
            particles[i].setAnimationSpeed(2);
            Camera.instance.gp.entities.add(particles[i]);

            enemies[i].takeDamage(1);
        }

    }
}
