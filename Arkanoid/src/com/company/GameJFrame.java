package com.company;

import javax.swing.*;

public class GameJFrame extends JFrame {

    public static void main(String[] args) {
        GameJFrame gameJFrame = new GameJFrame();
    }

    public GameJFrame() {
        GamePlay gamePlay = new GamePlay();
        this.setResizable(false);
        this.setTitle("Arkanoid");
        this.add(gamePlay);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }

}
