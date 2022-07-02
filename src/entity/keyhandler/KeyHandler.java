package entity.keyhandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean upPressed2, downPressed2, leftPressed2, rightPressed2;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    // While a Key is Pressed, the boolean for it is set true to trigger an event.
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        // Player One Controls

        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }

        // Player Two Controls

        if (code == KeyEvent.VK_UP) {
            upPressed2 = true;
        }
        if (code == KeyEvent.VK_DOWN) {
            downPressed2 = true;
        }
        if (code == KeyEvent.VK_LEFT) {
            leftPressed2 = true;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed2 = true;
        }

    }

    @Override
    // Same as keyPressed but with releasing a Key.
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        // Player One
        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }

        // Player Two
        if (code == KeyEvent.VK_UP) {
            upPressed2 = false;
        }
        if (code == KeyEvent.VK_DOWN) {
            downPressed2 = false;
        }
        if (code == KeyEvent.VK_LEFT) {
            leftPressed2 = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed2 = false;
        }

    }
}