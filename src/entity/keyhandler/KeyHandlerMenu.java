package entity.keyhandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandlerMenu implements KeyListener {

    public boolean next;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();


        if (code == KeyEvent.VK_X) {
            next = true;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}