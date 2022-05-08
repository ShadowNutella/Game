package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //SCREEN SETTINGS
    final int originalTileSize = 32; //32x32 tile
    final int scale = 2;

    final int tileSize = originalTileSize * scale; //64x64 tile
    final int maxScreenCol = 20;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    //FPS
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //Set player 1 default position
    int player1X = 100;
    int player1Y = 100;
    int playerSpeed = 4;

    //Set player 2 default position
    int player2X = 400;
    int player2Y = 400;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();

    }

    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }

    }

    public void update() {

        //Player 1
        if(keyH.upPressed == true) {
            player1Y -= playerSpeed;
        }
        else if(keyH.downPressed == true) {
            player1Y += playerSpeed;
        }
        else if(keyH.leftPressed == true) {
            player1X -= playerSpeed;
        }
        else if(keyH.rightPressed == true) {
            player1X += playerSpeed;
        }

        //Player 2
        if(keyH.upPressed2 == true) {
            player2Y -= playerSpeed;
        }
        else if(keyH.downPressed2 == true) {
            player2Y += playerSpeed;
        }
        else if(keyH.leftPressed2 == true) {
            player2X -= playerSpeed;
        }
        else if(keyH.rightPressed2 == true) {
            player2X += playerSpeed;
        }

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        Graphics2D g3 = (Graphics2D)g;

        g2.setColor(Color.magenta);

        g2.fillRect(player1X, player1Y, tileSize, tileSize);

        g3.setColor(Color.white);

        g3.fillRect(player2X, player2Y, tileSize, tileSize);

        g2.dispose();

        g3.dispose();
    }


}
