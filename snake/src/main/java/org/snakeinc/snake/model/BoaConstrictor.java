package org.snakeinc.snake.model;
import java.awt.Color;
import java.awt.Graphics;

public class BoaConstrictor extends Snake {

    public BoaConstrictor(){
        super();
    }

    @Override
    public void draw(Graphics g) {
        for (Tile t : body) {
            g.setColor(Color.BLUE);
            t.drawRectangle(g);
        }
    }

    // @Override
    // public void eat(Edible edible) {
    //     switch (edible.getFoodType()) {
    //         case FoodType.APPLE:
    //             body.add(edible.getPosition());
    //             body.add(edible.getPosition());
    //             body.add(edible.getPosition());
    //             break;
    //         case FoodType.BROCOLI:
    //             break;
    //     }
    // } 
    @Override
    public void eat(Apple apple) {
                body.add(apple.getPosition());
                body.add(apple.getPosition());
                body.add(apple.getPosition());
    }

    @Override
    public void eat(Brocoli brocoli){
    }
}
