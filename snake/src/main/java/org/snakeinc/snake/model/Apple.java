package org.snakeinc.snake.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import org.snakeinc.snake.GamePanel;

public class Apple {

    private int x, y;
    private final Random random;

    public Apple() {
        random = new Random();
        updateLocation();
    }

    public void updateLocation() {
        x = random.nextInt(0, (GamePanel.GAME_WIDTH / GamePanel.TILE_SIZE)) * GamePanel.TILE_SIZE;
        y = random.nextInt(0, (GamePanel.GAME_HEIGHT / GamePanel.TILE_SIZE)) * GamePanel.TILE_SIZE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE);
    }

}
