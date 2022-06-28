package scene;

import entity.*;
import entity.item.Item;
import main.Camera;
import main.CollisionChecker;
import main.ItemHolder;
import entity.keyhandler.KeyHandler;
import tile.TileManager;
import ui.UI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Scene extends JPanel implements Runnable {

    //SCREEN SETTINGS
    private int originalTileSize = 32; //32x32 tile
    private int scale = 2; //World * 2 | Fight * 4

    private int maxScreenCol = 20;
    private int maxScreenRow = 12;

    //World Settings (World 80/30, Fight 20/12)
    private int maxWorldCol = 80;
    private int maxWorldRow = 30;

    //FPS
    int FPS = 60;

    public TileManager tileM;
    public KeyHandler keyH;
    public Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public UI ui;

    public ArrayList<Item> items = new ArrayList<Item>();
    public Player playerOne, playerTwo;

    // Create list with Entity objects
    public ArrayList<Entity> entities = new ArrayList<Entity>();

    public boolean gameStarted = false;

    // 0 => Playing, 1 => Won, 2 => Lost
    private int levelStatus = 0;


    public Scene() {

        this.setPreferredSize(new Dimension(getScreenWidth(), getScreenHeight()));
        this.setBackground(Color.black);
        this.addKeyListener(keyH);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        //tileM = new TileManager(this, "Blau", "blau", "/maps/worldblau.txt");

        Camera.instance.gp = this;
        Camera.setLimits(getScreenWidth() / 2, getWorldWidth() - getScreenWidth() / 2, getScreenHeight() / 2, getWorldHeight() - getScreenHeight() / 2);
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

        createItems();

        ItemHolder playerInventory = new ItemHolder();

        playerOne = new Player(this, keyH, "/characterOne/char1_", 5, getTileSize() * 69, getTileSize()  * 24, playerInventory);
        //playerOne = new Player(this, keyH, "/characterOne/char1_", 5, 700, 300, playerInventory);
        playerOne.drawPriority = 100;
        playerTwo = new Player(this, keyH, "/characterTwo/char2_", 6, getTileSize()  * 71, getTileSize()  * 24, playerInventory);
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
            if (e.alive)
                e.updateEntity();
        }

        for (Item i : items) {
            if (i.alive)
                i.updateEntity();
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

        //sorts the entities by their priority to decide which one will be drawn first and which one covers the others by running over them
        sortEntitiesByPriority();

        //Loop through entities and draws them
        for (Entity e : entities) {
            if (e.alive)
                e.draw(g2);
        }

        //Draws the items on the map
        for (Item i : items) {
            if (i != null && i.alive) {
                i.draw(g2);
            }
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

    public void win()
    {

        levelStatus = 1;
    }

    public void lose()
    {
        levelStatus = 2;
    }

    public int getLevelStatus()
    {
        return levelStatus;
    }



}
