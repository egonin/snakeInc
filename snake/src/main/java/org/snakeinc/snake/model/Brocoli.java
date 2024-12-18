package org.snakeinc.snake.model;
import java.awt.Color;
import java.awt.Graphics;

public class Brocoli extends Edible {
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        position.drawOval(g);
    }
}
