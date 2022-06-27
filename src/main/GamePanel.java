package main;

import entity.*;
import entity.Item;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    final int originalTileSize = 32; //32x32 tile
    public int scale = 2; //World * 2 | Fight * 4

    public final int tileSize = originalTileSize * scale; //World 64x64 tile
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //World Settings (World 80/30, Fight 20/12)
    public int maxWorldCol = 80;
    public int maxWorldRow = 30;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //FPS
    int FPS = 60;

    TileManager tileM;
    KeyHandler keyH;
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public UI ui;

    public ArrayList<Item> items = new ArrayList<Item>();
    public Player playerOne, playerTwo;

    // Create list with Entity objects
    public ArrayList<Entity> entities = new ArrayList<Entity>();

    public boolean gameStarted = false;


    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        //tileM = new TileManager(this, "Blau", "blau", "/maps/worldblau.txt");

        Camera.instance.gp = this;
        Camera.setLimits(screenWidth / 2, worldWidth - screenWidth / 2, screenHeight / 2, worldHeight - screenHeight / 2);

        setUpGame();
    }


    public void setUpGame() {

        createItems();

        ItemHolder playerInventory = new ItemHolder();

        playerOne = new Player(this, keyH, "/characterOne/char1_", 5, tileSize * 69, tileSize * 24, playerInventory);
        //playerOne = new Player(this, keyH, "/characterOne/char1_", 5, 700, 300, playerInventory);
        playerOne.drawPriority = 100;
        playerTwo = new Player(this, keyH, "/characterTwo/char2_", 6, tileSize * 71, tileSize * 24, playerInventory);
        //playerTwo = new Player(this, keyH, "/characterTwo/char2_", 6, 700, 300, playerInventory);
        playerTwo.drawPriority = 99;

        entities.add(playerOne);
        entities.add(playerTwo);

    }


    public void createItems() {

    }


    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();

    }


    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;


        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }

    }


    public void update() {

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


    public void sortEntitiesByPriority() {
        for (int i = 0; i < entities.size(); i++) {
            for (int j = 0; j < entities.size() - 1; j++) {
                if (entities.get(j).drawPriority > entities.get(j + 1).drawPriority) {
                    Entity temp = entities.get(j);
                    entities.set(j, entities.get(j + 1));
                    entities.set(j + 1, temp);
                }
            }
        }
    }


}
