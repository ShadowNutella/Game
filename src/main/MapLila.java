package main;

import entity.*;
import tile.TileManager;

import java.awt.*;

public class MapLila extends GamePanel {

    PatrolEnemy patrolerRight, patrolerLeft;

    public MapLila() {

        super();
        keyH = new KeyHandler();
        tileM = new TileManager(this, "Lila", "lila", "/maps/worldlila.txt");
        ui = new MapUILila(this);

    }


    public void setUpGame() {

        super.setUpGame();

        playerOne.x = tileSize * 69;
        playerOne.y = tileSize * 24;
        playerOne.speed = 5;

        playerTwo.x = tileSize * 71;
        playerTwo.y = tileSize * 24;
        playerTwo.speed = 6;

        //Entity enemy = new Enemy("/enemies/enemy_blau", 425, 115);
        //entities.add(enemy);

        Enemy guardian_lila_left = new Enemy("/enemies/enemy_lila_left", 410, 105);
        guardian_lila_left.image.animationSpeed = 35;
        guardian_lila_left.setSize(1.5);
        Enemy guardian_lila_right = new Enemy("/enemies/enemy_lila_right", 525, 112);
        guardian_lila_right.image.animationSpeed = 25;
        guardian_lila_right.setSize(1.4);
        entities.add(guardian_lila_left);
        entities.add(guardian_lila_right);

        patrolerRight = new PatrolEnemy("/enemies/patrol/patrol_lila_", tileSize * 78, tileSize * 11);
        patrolerRight.patrolSpeed = 2;
        patrolerRight.imageLeft.animationSpeed = 24;
        patrolerRight.imageRight.animationSpeed = 24;
        items.add(patrolerRight.textItem);
        patrolerRight.setSize(1.7);
        entities.add(patrolerRight);

        patrolerLeft = new PatrolEnemy("/enemies/patrol/patrol_lila_", tileSize * 62, tileSize * 11);
        patrolerLeft.patrolSpeed = 2;
        patrolerLeft.imageLeft.animationSpeed = 24;
        patrolerLeft.imageRight.animationSpeed = 24;
        items.add(patrolerLeft.textItem);
        patrolerLeft.setSize(1.7);
        entities.add(patrolerLeft);

    }


    public void createItems() {

        Item i;
        i = new Item("key", 30 * tileSize, 8 * tileSize, "lila");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key",77 * tileSize , 24 * tileSize, "lila");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 69 * tileSize, 18 * tileSize, "lila");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 77 * tileSize, 4 * tileSize, "lila");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 55 * tileSize, 10 * tileSize, "lila");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 42 * tileSize, 4 * tileSize, "lila");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 32 * tileSize, 25 * tileSize, "lila");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 15 * tileSize, 25 * tileSize, "lila");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 22 * tileSize, 13 * tileSize, "lila");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 5 * tileSize, 10 * tileSize, "lila");
        i.collisionOn = true;
        items.add(i);

        i = new DoorGuardianItem(410, 175, tileSize * 4, tileSize);
        items.add(i);

    }

    public void update() {

        playerOne.setAnimationSpeed(12);
        playerOne.updatePlayerOne();
        playerTwo.setAnimationSpeed(10);
        playerTwo.updatePlayerTwo();

        if (patrolerRight.x > tileSize * 78)
            patrolerRight.moveLeft = true;
        if (patrolerRight.x < tileSize * 70 + 32)
            patrolerRight.moveLeft = false;
        patrolerRight.move();

        if (patrolerLeft.x > tileSize * 70 - 32)
            patrolerLeft.moveLeft = true;
        if (patrolerLeft.x < tileSize * 62)
            patrolerLeft.moveLeft = false;
        patrolerLeft.move();

        super.update();
    }

}