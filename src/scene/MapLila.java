package scene;

import entity.*;
import entity.item.DoorGuardianItem;
import entity.item.Item;
import entity.keyhandler.KeyHandler;
import tile.TileManager;
import ui.MapUILila;

public class MapLila extends Scene {

    PatrolEnemy patrolerRight, patrolerLeft;

    public MapLila() {
        super();
        keyH = new KeyHandler();
        this.addKeyListener(keyH);
        tileM = new TileManager(this, "Lila", "lila", "/maps/worldlila.txt");
        ui = new MapUILila(this);

        setUpGame();
    }


    public void setUpGame() {

        super.setUpGame();

        playerOne.x = getTileSize() * 69;
        playerOne.y = getTileSize() * 24;
        playerOne.speed = 6;

        playerTwo.x = getTileSize() * 71;
        playerTwo.y = getTileSize() * 24;
        playerTwo.speed = 6;


        Enemy guardian_lila_left = new Enemy("/enemies/enemy_lila_left", 410, 105);
        guardian_lila_left.image.animationSpeed = 35;
        guardian_lila_left.setSize(1.5);
        Enemy guardian_lila_right = new Enemy("/enemies/enemy_lila_right", 525, 112);
        guardian_lila_right.image.animationSpeed = 25;
        guardian_lila_right.setSize(1.4);
        entities.add(guardian_lila_left);
        entities.add(guardian_lila_right);

        patrolerRight = new PatrolEnemy("/enemies/patrol/patrol_lila_", getTileSize() * 77, getTileSize() * 6, "Ha! I can Moonwalk, and you?");
        patrolerRight.patrolSpeed = 2;
        patrolerRight.imageLeft.animationSpeed = 24;
        patrolerRight.imageRight.animationSpeed = 24;
        items.add(patrolerRight.textItem);
        patrolerRight.setSize(1.7);
        entities.add(patrolerRight);

        patrolerLeft = new PatrolEnemy("/enemies/patrol/patrol_lila_", getTileSize() * 63, getTileSize() * 6, "Better get some Skills!");
        patrolerLeft.patrolSpeed = 2;
        patrolerLeft.imageLeft.animationSpeed = 24;
        patrolerLeft.imageRight.animationSpeed = 24;
        items.add(patrolerLeft.textItem);
        patrolerLeft.setSize(1.7);
        entities.add(patrolerLeft);

    }


    public void createItems() {

        Item i;
        i = new Item("key", 77 * getTileSize(), 23 * getTileSize(), "lila");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key",65 * getTileSize() , 4 * getTileSize(), "lila");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 49 * getTileSize(), 9 * getTileSize(), "lila");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 77 * getTileSize(), 4 * getTileSize(), "lila");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 43 * getTileSize(), 10 * getTileSize(), "lila");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 46 * getTileSize(), 25 * getTileSize(), "lila");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 23 * getTileSize(), 16 * getTileSize(), "lila");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 17 * getTileSize(), 25 * getTileSize(), "lila");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 27 * getTileSize(), 25 * getTileSize(), "lila");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 20 * getTileSize(), 9 * getTileSize(), "lila");
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


        if (patrolerRight.x > getTileSize() * 77)
            patrolerRight.moveLeft = true;
        if (patrolerRight.x < getTileSize() * 70 + 32)
            patrolerRight.moveLeft = false;
        patrolerRight.move();

        if (patrolerLeft.x > getTileSize() * 70 - 32)
            patrolerLeft.moveLeft = true;
        if (patrolerLeft.x < getTileSize() * 63)
            patrolerLeft.moveLeft = false;
        patrolerLeft.move();

        super.update();
    }

}
