package org.snakeinc.snake;

import javax.swing.JFrame;

public class SnakeApp {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Inc");
        GamePanel gamePanel = new GamePanel();

        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();
    }
}