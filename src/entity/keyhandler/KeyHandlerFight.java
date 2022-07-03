package entity.keyhandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandlerFight implements KeyListener {

    public boolean leftPressed, rightPressed, abilityOne;
    public boolean leftPressed2, rightPressed2, abilityOne2;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        // Player Two

        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
        if (code == KeyEvent.VK_1) {
            abilityOne = true;
        }

        // Player Two

        if (code == KeyEvent.VK_LEFT) {
            leftPressed2 = true;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed2 = true;
        }
        if (code == KeyEvent.VK_NUMPAD1) {
            abilityOne2 = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        // Player One
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
        if (code == KeyEvent.VK_1) {
            abilityOne = false;
        }

        // Player Two

        if (code == KeyEvent.VK_LEFT) {
            leftPressed2 = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed2 = false;
        }
        if (code == KeyEvent.VK_NUMPAD1) {
            abilityOne2 = false;
        }

    }
}