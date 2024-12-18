package org.snakeinc.snake.model;
import java.awt.Color;
import java.awt.Graphics;

public class Python extends Snake {
    public Python(){
        super();
    }

    @Override
    public void draw(Graphics g) {
        for (Tile t : body) {
            g.setColor(Color.GREEN);
            t.drawRectangle(g);
        }
    }

    // @Override
    // public void eat(Edible edible) {
    //     switch (edible.getFoodType()) {
    //         case FoodType.APPLE:
    //             body.add(edible.getPosition());
    //             break;
    //         case FoodType.BROCOLI:
    //             body.removeLast();
    //             body.removeLast();
    //             break;
    //     }
    // }
    @Override
    public void eat(Apple apple) {
                body.add(apple.getPosition());
    }

    @Override
    public void eat(Brocoli brocoli){
            if (body.size() > 3){
                body.removeLast();
                // body.removeLast();
            }
    }
}
