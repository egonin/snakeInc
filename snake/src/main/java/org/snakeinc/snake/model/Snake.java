package org.snakeinc.snake.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {

    private final ArrayList<Tile> body;

    public Snake() {
        body = new ArrayList<>();
        body.add(new Tile(5, 5)); // La tête du serpent
    }

    public Tile getHead() {
        return body.get(0);
    }

    public void eat(Apple apple) {
        body.add(apple.getPosition());
    }

    public void move(char direction) {
        Tile newHead = getHead().copy();

        switch (direction) {
            case 'U':
                newHead.setY(newHead.getY() - 1);
                break;
            case 'D':
                newHead.setY(newHead.getY() + 1);
                break;
            case 'L':
                newHead.setX(newHead.getX() - 1);
                break;
            case 'R':
                newHead.setX(newHead.getX() + 1);
                break;
        }

        body.add(0,newHead);
        body.remove(body.size() -1); // Supprime le dernier segment pour simuler le déplacement
    }

    public void draw(Graphics g) {
        for (Tile t : body) {
            g.setColor(Color.GREEN);
            t.drawRectangle(g);
        }
    }

    public boolean checkSelfCollision() {
        for (int i = 1; i < body.size(); i++) {
            if (getHead().equals(body.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean checkWallCollision() {
        return !getHead().isInsideGame();
    }

}
