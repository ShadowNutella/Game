package scene;

import entity.Enemy;
import entity.PatrolEnemy;
import entity.item.DoorGuardianItem;
import entity.item.Item;
import entity.keyhandler.KeyHandler;
import tile.TileManager;
import ui.MapUIRosa;

public class MapRosa extends Scene {

    PatrolEnemy patrolerRight, patrolerLeft;

    public MapRosa() {
        super();
        keyH = new KeyHandler();
        this.addKeyListener(keyH);
        tileM = new TileManager(this, "Rosa", "rosa", "/maps/worldrosa.txt");
        ui = new MapUIRosa(this);

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


        Enemy guardian_lila_left = new Enemy("/enemies/enemy_rosa_left", 410, 105);
        guardian_lila_left.image.animationSpeed = 35;
        guardian_lila_left.setSize(1.5);
        Enemy guardian_lila_right = new Enemy("/enemies/enemy_rosa_right", 525, 112);
        guardian_lila_right.image.animationSpeed = 25;
        guardian_lila_right.setSize(1.4);
        entities.add(guardian_lila_left);
        entities.add(guardian_lila_right);

        patrolerRight = new PatrolEnemy("/enemies/patrol/patrol_rosa_", getTileSize() * 77, getTileSize() * 6, "Walking on Spot is also walking!");
        patrolerRight.patrolSpeed = 2;
        patrolerRight.imageLeft.animationSpeed = 24;
        patrolerRight.imageRight.animationSpeed = 24;
        items.add(patrolerRight.textItem);
        patrolerRight.setSize(1.7);
        entities.add(patrolerRight);

        patrolerLeft = new PatrolEnemy("/enemies/patrol/patrol_rosa_", getTileSize() * 75, getTileSize() * 6, "This is better than actually walking!");
        patrolerLeft.patrolSpeed = 2;
        patrolerLeft.imageLeft.animationSpeed = 24;
        patrolerLeft.imageRight.animationSpeed = 24;
        items.add(patrolerLeft.textItem);
        patrolerLeft.setSize(1.7);
        entities.add(patrolerLeft);

    }


    public void createItems() {

        Item i;
        i = new Item("key", 78 * getTileSize(), 24 * getTileSize(), "rosa");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key",68 * getTileSize() , 19 * getTileSize(), "rosa");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 72 * getTileSize(), 12 * getTileSize(), "rosa");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 45 * getTileSize(), 16 * getTileSize(), "rosa");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 55 * getTileSize(), 4 * getTileSize(), "rosa");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 42 * getTileSize(), 4 * getTileSize(), "rosa");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 30 * getTileSize(), 4 * getTileSize(), "rosa");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 15 * getTileSize(), 5 * getTileSize(), "rosa");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 3 * getTileSize(), 4 * getTileSize(), "rosa");
        i.collisionOn = true;
        items.add(i);

        i = new Item("key", 37 * getTileSize(), 4 * getTileSize(), "rosa");
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


        super.update();
    }

}
