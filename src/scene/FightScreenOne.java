package scene;

import entity.*;
import entity.item.Item;
import main.Camera;
import main.ItemHolder;
import entity.item.KeyHandlerFight;
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
    private int maxWorldCol = 10;
    private int maxWorldRow = 6;


    public FightScreenOne() {
        super();
        this.keyH = new KeyHandlerFight();
        this.addKeyListener(keyH);
        tileM = new TileManager(this, "Blau", "blau", "/maps/FightScreen.txt");
        ui = new FightUIBlau(this);

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

    public int getOriginalTileSize()
    {
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

    public int getMaxScreenRow()
    {
        return maxScreenRow;
    }

    public int getWorldWidth() {
        return getTileSize() * getMaxWorldCol();
    }

    public int getWorldHeight() {
        return getTileSize() * getMaxWorldRow();
    }

    public void setUpGame() {

        ItemHolder playerInventory = new ItemHolder();
        playerOne = new Player(this, keyH, "/characterOne/char1_", 9, getScreenWidth() / 2 + 2, getTileSize() * 5, playerInventory);
        //playerOne = new Player(this, keyH, "/characterOne/char1_", 5, 700, 300, playerInventory);
        playerOne.drawPriority = 100;
        playerTwo = new Player(this, keyH, "/characterTwo/char2_", 9, getScreenWidth() / 2, getTileSize() * 5, playerInventory);
        //playerTwo = new Player(this, keyH, "/characterTwo/char2_", 6, 700, 300, playerInventory);
        playerTwo.drawPriority = 99;


        //Entity enemy = new Enemy("/enemies/enemy_blau", 425, 115);
        //entities.add(enemy);

        Enemy guardian_blue_left = new Enemy("/enemies/enemy_blau_left", 410, 105);
        guardian_blue_left.image.animationSpeed = 35;
        guardian_blue_left.setSize(1.5);
        Enemy guardian_blue_right = new Enemy("/enemies/enemy_blau_right", 525, 112);
        guardian_blue_right.image.animationSpeed = 25;
        guardian_blue_right.setSize(1.4);
        entities.add(guardian_blue_left);
        entities.add(guardian_blue_right);

        entities.add(playerOne);
        entities.add(playerTwo);

        Camera.setPos(getScreenWidth() / 2, getScreenHeight() / 2);
    }


    public void update() {

        playerOne.setAnimationSpeed(12);
        playerOne.updatePlayerOne();
        playerTwo.setAnimationSpeed(10);
        playerTwo.updatePlayerTwo();


        for (Entity e : entities) {
            e.update();
        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        ui.graphics = g2;

        //Draws the Tiles of the current world map
        tileM.drawWorldTiles(g2);

        //Draws the items on the map
        for (Item i : items) {
            if (i != null) {
                i.draw(g2);
            }
        }

        //sorts the entities by their priority to decide which one will be drawn first and which one covers the others by running over them
        sortEntitiesByPriority();

        //Loop through entities and draws them
        for (Entity e : entities) {
            e.draw(g2);
        }

        //UI
        ui.drawUI();


        g2.dispose();

        if (!gameStarted)
        {
            UI.instance.startOpening(20);
            gameStarted = true;
        }
    }

}
