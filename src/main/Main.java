package main;

import scene.*;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args) {
        JFrame window = null;


        LevelStatus result = LevelStatus.PLAYING;

        while(result != LevelStatus.WON)
        {
            MapBlau mapBlau = new MapBlau();
            window = startLevel(mapBlau);

            result = getLevelResult(mapBlau);
            mapBlau.endGameThread();
        }
        disposeWindow(window);



        result = LevelStatus.PLAYING;


        while(result != LevelStatus.WON)
        {
            FightScreenOne fightScreenOne = new FightScreenOne();
            window = startLevel(fightScreenOne);

            result = getLevelResult(fightScreenOne);
            fightScreenOne.endGameThread();
        }

        disposeWindow(window);
    }

    public static LevelStatus getLevelResult(Scene scene)
    {
        while(scene.getLevelStatus() == LevelStatus.PLAYING)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return scene.getLevelStatus();
    }

    public static void disposeWindow(JFrame window)
    {
        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
    }

    public static JFrame startLevel(Scene scene)
    {
        JFrame window;

        window = new JFrame();
        //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
