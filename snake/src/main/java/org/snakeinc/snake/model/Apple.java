package org.snakeinc.snake.model;
import java.awt.Color;
import java.awt.Graphics;

public class Apple extends Edible {
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        position.drawOval(g);
    }
}
