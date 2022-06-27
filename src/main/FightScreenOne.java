package main;

import entity.*;
import tile.TileManager;

import java.awt.*;

public class FightScreenOne extends GamePanel{

    //SCREEN SETTINGS
    final int originalTileSize = 32; //32x32 tile
    public int scale = 4; //World * 2 | Fight * 4

    public final int tileSize = originalTileSize * scale; //World 64x64 tile
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * 2 * maxScreenCol;
    public final int screenHeight = tileSize * 2 * maxScreenRow;

    //World Settings (World 80/30, Fight 20/12)
    public int maxWorldCol = 20;
    public int maxWorldRow = 12;
    public final int worldWidth = maxWorldCol;
    public final int worldHeight = maxWorldRow;



    public FightScreenOne() {

        super();
        this.keyH = new KeyHandlerFight();
        tileM = new TileManager(this, "Blau", "blau", "/maps/FightScreen.txt");
        ui = new FightUIBlau(this);

    }

    public void setUpGame() {

        ItemHolder playerInventory = new ItemHolder();
        playerOne = new Player(this, keyH, "/characterOne/char1_", 9, screenWidth / 2 + 2, tileSize * 12, playerInventory);
        //playerOne = new Player(this, keyH, "/characterOne/char1_", 5, 700, 300, playerInventory);
        playerOne.drawPriority = 100;
        playerTwo = new Player(this, keyH, "/characterTwo/char2_", 9, screenWidth / 2, tileSize * 12, playerInventory);
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


    }


    public void update() {

        playerOne.setAnimationSpeed(12);
        playerOne.updatePlayerOne();
        playerTwo.setAnimationSpeed(10);
        playerTwo.updatePlayerTwo();


        for (Entity e : entities) {
            e.update();
        }

        int cameraX, cameraY;
        // Calculate cameraX and cameraY as point in the center between playerOne and playerTwo
        cameraX = (playerOne.x + playerTwo.x) / 2;
        cameraY = (playerOne.y + playerTwo.y) / 2;
        Camera.setPos(cameraX, cameraY);
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
