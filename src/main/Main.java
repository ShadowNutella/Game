package main;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Journey Back Home");

        //GamePanel gamePanel = new GamePanel();
        FightScreenOne gamePanelFight = new FightScreenOne();
        //MapLila gamePanel2 = new MapLila();
        //window.add(gamePanel);
        window.add(gamePanelFight);
        //window.add(gamePanel2);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        //gamePanel.startGameThread();
        gamePanelFight.startGameThread();

    }

}
