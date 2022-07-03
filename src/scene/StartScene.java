package scene;

import entity.keyhandler.KeyHandlerMenu;
import main.Camera;
import ui.UI;

import java.awt.*;

public class StartScene extends Scene {

    private int originalTileSize = 32; //32x32 tile
    private int scale = 4; //World * 2 | Fight * 4

    private int maxScreenCol = 20;
    private int maxScreenRow = 12;

    private int maxWorldCol = 11;
    private int maxWorldRow = 6;

    KeyHandlerMenu keyH;

    public StartScene() {
            super();
            keyH = new KeyHandlerMenu();
            this.addKeyListener(keyH);

            ui = new UI(this);

            setUpGame();

    }

    public void setUpGame() {

        Camera.setPos(getScreenWidth() / 2, getScreenHeight() / 2);
    }

    // Calls the goNext Method permanently.
    public void update() {
        goNext();
    }

    // Draws the Messages on the Screen with the Instructions for the Game.
    public void paintComponent(Graphics g) {
        super.paintComponentBase(g);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("You and your Friend woke up in an unknown Place and want to get back home.", 100, 90);
        g.drawString("Collect all 10 Keys and Fight the Guardians to enter the next World.", 150, 180);
        g.drawString("Player One walks with WASD and attacks with 1.", 255, 270);
        g.drawString("Player Two walks with ARROW KEYS and attacks with NUM1.", 180, 360);
        g.drawString("During Fight dodge the Enemies projectiles and try to attack the Enemies.", 120, 450);
        g.drawString("(This Game can also be played alone)", 310, 630);
        g.drawString("Press X to Start", 450, 720);

        ui.graphics = (Graphics2D) g;
        ui.drawUI();
    }

    // If the X Key got pressed sets LevelStatus to WON so the First Level Starts.
    public void goNext() {

        if (keyH.next) {
            UI.instance.startClosing(1, LevelStatus.WON);
            keyH.next = false;
        }
    }

}
