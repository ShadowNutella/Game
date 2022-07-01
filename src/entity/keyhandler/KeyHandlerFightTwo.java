package entity.keyhandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandlerFightTwo implements KeyListener {

    public boolean leftPressed, rightPressed, abilityOne, abilityTwo;
    public boolean leftPressed2, rightPressed2, abilityOne2, abilityTwo2;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        //Spieler 1 Steuerung

        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
        if (code == KeyEvent.VK_1) {
            abilityOne = true;
        }
        if (code == KeyEvent.VK_2) {
            abilityTwo = true;
        }

        //Spieler 2 Steuerung

        if (code == KeyEvent.VK_LEFT) {
            leftPressed2 = true;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed2 = true;
        }
        if (code == KeyEvent.VK_NUMPAD1) {
            abilityOne2 = true;
        }
        if (code == KeyEvent.VK_NUMPAD2) {
            abilityTwo2 = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        //Player 1
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
        if (code == KeyEvent.VK_1) {
            abilityOne = false;
        }
        if (code == KeyEvent.VK_2) {
            abilityTwo =false;
        }

        //Player 2

        if (code == KeyEvent.VK_LEFT) {
            leftPressed2 = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed2 = false;
        }
        if (code == KeyEvent.VK_NUMPAD1) {
            abilityOne2 = false;
        }
        if (code == KeyEvent.VK_NUMPAD2) {
            abilityTwo2 = false;
        }

    }
}