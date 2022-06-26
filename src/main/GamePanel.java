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
    final int scale = 2;

    public final int tileSize = originalTileSize * scale; //64x64 tile
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //World Settings
    public final int maxWorldCol = 80;
    public final int maxWorldRow = 30;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //FPS
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter setter1 = new AssetSetter(this);

    public Item[] items = new Item[10];
    public Player playerOne, playerTwo;

    // Create list with Entity objects
    public ArrayList<Entity> entities = new ArrayList<Entity>();

    PatrolEnemy patroler;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        Camera.instance.gp = this;
        Camera.setLimits(screenWidth / 2, worldWidth - screenWidth / 2, screenHeight / 2, worldHeight - screenHeight / 2);

        setUpGame();

    }

    public void setUpGame() {
        setter1.createItems();

        playerOne = new Player(this, keyH, "/characterOne/char1_", 5, 500, 300);
        playerOne.drawPriority = 100;
        playerTwo = new Player(this, keyH, "/characterTwo/char2_", 6, 200, 300);
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


        patroler = new PatrolEnemy("/enemies/patrol/patrol_blau_", 400, 250);
        patroler.patrolSpeed = 2;
        patroler.imageLeft.animationSpeed = 24;
        patroler.imageRight.animationSpeed = 24;
        patroler.setSize(1.7);
        entities.add(patroler);
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

        playerOne.setAnimationSpeed(12);
        playerOne.updatePlayerOne();
        playerTwo.setAnimationSpeed(10);
        playerTwo.updatePlayerTwo();

        if (patroler.x > 1500)
            patroler.moveLeft = true;
        if (patroler.x < 300)
            patroler.moveLeft = false;
        patroler.move();


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


        g2.dispose();
    }

    private void sortEntitiesByPriority() {
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
