package scene;

import entity.keyhandler.KeyHandlerMenu;
import main.Camera;
import ui.UI;

import java.awt.*;

public class EndScene extends Scene {

    //SCREEN SETTINGS
    private int originalTileSize = 32; //32x32 tile
    private int scale = 4; //World * 2 | Fight * 4

    private int maxScreenCol = 20;
    private int maxScreenRow = 12;

    //World Settings (World 80/30, Fight 20/12)
    private int maxWorldCol = 11;
    private int maxWorldRow = 6;

    KeyHandlerMenu keyH;

    public EndScene() {

        super();
        keyH = new KeyHandlerMenu();
        this.addKeyListener(keyH);

        ui = new UI(this);

        setUpGame();

    }

    public void setUpGame() {

        Camera.setPos(getScreenWidth() / 2, getScreenHeight() / 2);
    }

    public void update() {
        goNext();
    }

    public void paintComponent(Graphics g) {

        super.paintComponentBase(g);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("Congratulations! You made it back home ^-^", 310, 400);
        g.drawString("Press X to Exit", 500, 490);

        ui.graphics = (Graphics2D) g;
        ui.drawUI();
    }

    public void goNext() {

        if (keyH.next) {
            UI.instance.startClosing(1, LevelStatus.WON);
            keyH.next = false;
        }
    }

}
