package scene;

import entity.*;
import entity.item.DoorGuardianItem;
import entity.item.Item;
import entity.keyhandler.KeyHandler;
import tile.TileManager;
import ui.MapUIBlau;

// First Level
public class MapBlau extends Scene {

    PatrolEnemy patrolerRight, patrolerLeft;


    public MapBlau() {
        super();
        keyH = new KeyHandler();
        this.addKeyListener(keyH);
        tileM = new TileManager(this, "Blau", "blau", "/maps/worldblau.txt");
        ui = new MapUIBlau(this);

        setUpGame();
    }

    public void setUpGame() {

        super.setUpGame();

        // Spawn points and speed settings for both Players.
        playerOne.x = getTileSize() * 69;
        playerOne.y = getTileSize() * 24;
        playerOne.speed = 6;

        playerTwo.x = getTileSize() * 71;
        playerTwo.y = getTileSize() * 24;
        playerTwo.speed = 6;

        // Create Enemy Objects and Place them + other Settings such as size etc.
        Enemy guardian_blue_left = new Enemy("/enemies/enemy_blau_left", 410, 105);
        guardian_blue_left.image.animationSpeed = 35;
        guardian_blue_left.setSize(1.5);
        Enemy guardian_blue_right = new Enemy("/enemies/enemy_blau_right", 525, 112);
        guardian_blue_right.image.animationSpeed = 25;
        guardian_blue_right.setSize(1.4);
        entities.add(guardian_blue_left);
        entities.add(guardian_blue_right);


        // Same for Patrolers.
        patrolerRight = new PatrolEnemy("/enemies/patrol/patrol_blau_", getTileSize() * 78, getTileSize() * 11, "If I was you, I wouldn't walk any further!");
        patrolerRight.patrolSpeed = 2;
        patrolerRight.imageLeft.animationSpeed = 24;
        patrolerRight.imageRight.animationSpeed = 24;
        items.add(patrolerRight.textItem);
        patrolerRight.setSize(1.7);
        entities.add(patrolerRight);

        patrolerLeft = new PatrolEnemy("/enemies/patrol/patrol_blau_", getTileSize() * 62, getTileSize() * 11, "Make way!");
        patrolerLeft.patrolSpeed = 2;
        patrolerLeft.imageLeft.animationSpeed = 24;
        patrolerLeft.imageRight.animationSpeed = 24;
        items.add(patrolerLeft.textItem);
        patrolerLeft.setSize(1.7);
        entities.add(patrolerLeft);

    }


    // Create the Item Objects and place them.
    public void createItems() {

        Item i;
        i = new Item("key", 30 * getTileSize(), 8 * getTileSize(), "blau");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key",77 * getTileSize() , 24 * getTileSize(), "blau");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 69 * getTileSize(), 18 * getTileSize(), "blau");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 77 * getTileSize(), 4 * getTileSize(), "blau");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 55 * getTileSize(), 10 * getTileSize(), "blau");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 42 * getTileSize(), 4 * getTileSize(), "blau");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 32 * getTileSize(), 25 * getTileSize(), "blau");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 15 * getTileSize(), 25 * getTileSize(), "blau");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 22 * getTileSize(), 13 * getTileSize(), "blau");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 5 * getTileSize(), 10 * getTileSize(), "blau");
        i.collisionOn = true;
        items.add(i);

        i = new DoorGuardianItem(410, 175, getTileSize() * 4, getTileSize());
        items.add(i);

    }


    public void update() {

        playerOne.setAnimationSpeed(10);
        playerOne.updatePlayerOne();
        playerTwo.setAnimationSpeed(10);
        playerTwo.updatePlayerTwo();

        // Paths for the Patrolers.
        if (patrolerRight.x > getTileSize() * 78)
            patrolerRight.moveLeft = true;
        if (patrolerRight.x < getTileSize() * 70 + 32)
            patrolerRight.moveLeft = false;
        patrolerRight.move();

        if (patrolerLeft.x > getTileSize() * 70 - 32)
            patrolerLeft.moveLeft = true;
        if (patrolerLeft.x < getTileSize() * 62)
            patrolerLeft.moveLeft = false;
        patrolerLeft.move();

        super.update();
    }

}

