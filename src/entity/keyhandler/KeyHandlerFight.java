package entity.keyhandler;

import entity.keyhandler.KeyHandler;

import java.awt.event.KeyEvent;

public class KeyHandlerFight extends KeyHandler {


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

            //Spieler 2 Steuerung

            if (code == KeyEvent.VK_LEFT) {
                leftPressed2 = true;
            }
            if (code == KeyEvent.VK_RIGHT) {
                rightPressed2 = true;
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

            int code = e.getKeyCode();

            if (code == KeyEvent.VK_A) {
                leftPressed = false;
            }
            if (code == KeyEvent.VK_D) {
                rightPressed = false;
            }


            if (code == KeyEvent.VK_LEFT) {
                leftPressed2 = false;
            }
            if (code == KeyEvent.VK_RIGHT) {
                rightPressed2 = false;
            }

        }
}

