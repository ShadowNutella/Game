package main;

import scene.FightScreenOne;
import scene.MapBlau;
import scene.MapLila;
import scene.Scene;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame window;

        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Journey Back Home");


        MapBlau mapBlau = new MapBlau();
        //FightScreenOne FightOne = new FightScreenOne();
        //MapLila mapLila = new MapLila();

        window.add(mapBlau);
        //window.add(gamePanelFight);
        //window.add(gamePanel2);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);


        mapBlau.startGameThread();

        //gamePanelFight.startGameThread();
        //gamePanel2.startGameThread();

    }

}
