package scene;

import entity.*;
import entity.item.Item;
import main.Camera;
import main.ItemHolder;
import entity.keyhandler.KeyHandlerFight;
import tile.TileManager;
import ui.FightUIBlau;
import ui.UI;

import java.awt.*;

public class FightScreenOne extends Scene {

    //SCREEN SETTINGS
    private int originalTileSize = 32; //32x32 tile
    private int scale = 4; //World * 2 | Fight * 4

    private int maxScreenCol = 20;
    private int maxScreenRow = 12;

    //World Settings (World 80/30, Fight 20/12)
    private int maxWorldCol = 11;
    private int maxWorldRow = 6;


    public FightScreenOne() {
        this.setPreferredSize(new Dimension(getScreenWidth() / 2, getScreenHeight() / 2));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

        this.keyH = new KeyHandlerFight();
        this.addKeyListener(keyH);
        tileM = new TileManager(this, "Blau", "blau", "/maps/FightScreen.txt");
        ui = new FightUIBlau(this);

        Camera.instance = new Camera(0, 0);
        Camera.instance.gp = this;
        Camera.setLimits(0, 0, 0, 0);

        setUpGame();
    }

    public int getMaxWorldRow() {
        return maxWorldRow;
    }

    public int getMaxWorldCol() {
        return maxWorldCol;
    }

    public int getScale() {
        return scale;
    }

    public int getOriginalTileSize() {
        return originalTileSize;
    }

    public int getTileSize() {
        return getOriginalTileSize() * getScale();
    }

    public int getScreenWidth() {
        return getTileSize() * getMaxScreenCol();
    }

    public int getMaxScreenCol() {
        return maxScreenCol;
    }

    public int getScreenHeight() {
        return getTileSize() * getMaxScreenRow();
    }

    public int getMaxScreenRow() {
        return maxScreenRow;
    }

    public int getWorldWidth() {
        return getTileSize() * getMaxWorldCol();
    }

    public int getWorldHeight() {
        return getTileSize() * getMaxWorldRow();
    }

    FightEnemy guardian_blue_left, guardian_blue_right;

    public void setUpGame() {

        ItemHolder playerInventory = new ItemHolder();

        playerOne = new FightPlayer(this, keyH, "/characterOne/char1_", 9, 500, 675, playerInventory);
        //playerOne = new Player(this, keyH, "/characterOne/char1_", 5, 700, 300, playerInventory);
        playerOne.drawPriority = 100;

        playerInventory.setHP(10);

        playerTwo = new FightPlayer(this, keyH, "/characterTwo/char2_", 9, 520, 670, playerInventory);
        //playerTwo = new Player(this, keyH, "/characterTwo/char2_", 6, 700, 300, playerInventory);
        playerTwo.drawPriority = 99;

        playerInventory.setHP(10);


        //Entity enemy = new Enemy("/enemies/enemy_blau", 425, 115);
        //entities.add(enemy);

        guardian_blue_left = new FightEnemy("/enemies/enemy_blau_left", 410, 85, playerOne, 1);
        guardian_blue_left.image.animationSpeed = 35;
        guardian_blue_left.setSize(1.5);
        guardian_blue_left.projectileFarbe = "blau";
        guardian_blue_left.setEnemyHP(30);

        guardian_blue_right = new FightEnemy("/enemies/enemy_blau_right", 675, 92, playerTwo,1);
        guardian_blue_right.image.animationSpeed = 25;
        guardian_blue_right.setSize(1.4);
        guardian_blue_right.projectileFarbe = "blau";
        guardian_blue_right.setEnemyHP(30);

        entities.add(guardian_blue_left);
        entities.add(guardian_blue_right);

        entities.add(playerOne);
        entities.add(playerTwo);

        Camera.setPos(getScreenWidth() / 2, getScreenHeight() / 2);
    }

    public int shootTimer = 0;

    public void update() {

        playerOne.setAnimationSpeed(12);
        playerOne.updatePlayerOne();
        playerTwo.setAnimationSpeed(10);
        playerTwo.updatePlayerTwo();

        shootTimer++;
        shootTimer %= 240;
        if (shootTimer == 120) {
            items.add(guardian_blue_left.shoot());
        }
        if (shootTimer == 180) {
            items.add(guardian_blue_right.shoot());
        }

        for (Entity e : entities) {
            if (e.alive)
                e.updateEntity();
        }

        for (Item i : items) {
            if (i.alive)
                i.updateEntity();
        }

    }
}
