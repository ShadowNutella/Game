package main;

import scene.*;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args) {
        JFrame window = null;

        // These methods are used for every level, in order

        window = loopLevelUntilWon(window, new StartScene());
        // Level 1: Blue Level
        window = loopLevelUntilWon(window, new MapBlau());

        // If Blue Level Won, call Fight
        window = loopLevelUntilWon(window, new FightScreenOne());


        window = loopLevelUntilWon(window, new MapLila());

        window = loopLevelUntilWon(window, new FightScreenTwo());


        window = loopLevelUntilWon(window, new MapRosa());

        window = loopLevelUntilWon(window, new FightScreenThree());

        //window = loopLevelUntilWon(window, new EndScene());
    }

    // Method to start a window with the current Level and swap to next Level if current Level is won.
    public static JFrame loopLevelUntilWon(JFrame window, Scene scene) {

        LevelStatus result = LevelStatus.PLAYING;

        while(result != LevelStatus.WON) {
            window = startLevel(scene);

            result = getLevelResult(scene);
            scene.endGameThread();
            disposeWindow(window);
        }

        return window;
    }

    // Method to get the current LevelStatus.
    public static LevelStatus getLevelResult(Scene scene)
    {
        // Loop and wait until the level-status is no longer "playing".
        while(scene.getLevelStatus() == LevelStatus.PLAYING)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Return the new level status, either "won" or "lost"
        return scene.getLevelStatus();
    }

    // Method to close the window when called.
    public static void disposeWindow(JFrame window)
    {
        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
    }

    // Sets up the window, Title, etc. when called.
    public static JFrame startLevel(Scene scene)
    {
        JFrame window;

        window = new JFrame();

        // We are re-using the window object, so we cannot exit the application.
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Journey Back Home");

        window.add(scene);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        scene.startGameThread();

        return window;
    }

}