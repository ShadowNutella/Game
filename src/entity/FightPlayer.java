package entity;

import entity.item.Item;
import entity.item.Particle;
import entity.keyhandler.KeyHandlerFightOne;
import main.AnimatedBufferedImage;
import main.Camera;
import main.ItemHolder;
import scene.FightScreenOne;
import scene.Scene;
import ui.UI;

import java.awt.*;

public class FightPlayer extends Player {

    KeyHandlerFightOne keyH;
    AnimatedBufferedImage ability;
    String player, side, number, count;
    public boolean attacking = false;
    int animationCounter = 0;

    public FightPlayer(Scene gp, KeyHandlerFightOne keyH, String resourcePath, int speed, int x, int y, ItemHolder inventory) {
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


        if (keyH.abilityOne) {
            System.out.println("Ability Player 1");
            attacking = true;
            attack();
        }

        if (keyH.leftPressed || keyH.rightPressed) {

            //Player 1
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
            System.out.println("Ability Player 2");
            attacking = true;
            attack();
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


    public void drawAttackImage(String player, String side, String number, String count) {

        this.player = player;
        this.side = side;
        this.number = number;
        this.count = count;
        this.ability = new AnimatedBufferedImage("/objects/abilities/ability" + count + "_" + player + "_" + side + "_" + number);

        int finalSizeX = (int) (Camera.instance.gp.getTileSize() * sizeX);
        int finalSizeY = (int) (Camera.instance.gp.getTileSize() * sizeY);
        UI.instance.graphics.drawImage(this.ability.getImage(), 100, 100, finalSizeX, finalSizeY, null);
    }


    public void attack() {

        Enemy[] enemies = Camera.instance.gp.getEnemies();
        Particle[] particles = new Particle[enemies.length];

        for (int i = 0; i < particles.length; i++) {
            particles[i] = new Particle("/objects/abilities/abilityOne_dragon_" + enemies[i].direction + "_", enemies[i].x + enemies[i].offsetX, enemies[i].y + enemies[i].offsetY, 12);


            particles[i].sizeX = enemies[i].sizeX;
            particles[i].sizeY = enemies[i].sizeY;
            particles[i].setAnimationSpeed(10);
            Camera.instance.gp.entities.add(particles[i]);
        }
    }
}
