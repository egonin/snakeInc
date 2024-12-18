package org.snakeinc.snake.model;

import java.awt.Color;
import java.awt.Graphics;

public class Anaconda extends Snake {

    public Anaconda(){
        super();
    }

    @Override
    public void draw(Graphics g) {
        for (Tile t : body) {
            g.setColor(Color.GRAY);
            t.drawRectangle(g);
        }
    }

    @Override
    public void eat(Apple apple) {
                body.add(apple.getPosition());
                body.add(apple.getPosition());
    }

    @Override
    public void eat(Brocoli brocoli){
                if (body.size() > 2){
                body.removeLast();
                }
    }
}
