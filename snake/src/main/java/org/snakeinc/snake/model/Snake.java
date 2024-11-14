package org.snakeinc.snake.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import org.snakeinc.snake.GamePanel;

public class Snake {

    private final ArrayList<Point> body;

    public Snake() {
        body = new ArrayList<>();
        body.add(new Point(5 * GamePanel.TILE_SIZE, 5 * GamePanel.TILE_SIZE)); // La tête du serpent
    }

    public int getHeadX() {
        return (int) body.get(0).getX();
    }

    public int getHeadY() {
        return (int) body.get(0).getY();
    }

    public void eat(Apple apple) {
        body.add(new Point(apple.getX(), apple.getY()));
    }

    public void move(char direction) {
        Point newHead = new Point(getHeadX(), getHeadY());

        switch (direction) {
            case 'U':
                newHead.y -= GamePanel.TILE_SIZE;
                break;
            case 'D':
                newHead.y += GamePanel.TILE_SIZE;
                break;
            case 'L':
                newHead.x -= GamePanel.TILE_SIZE;
                break;
            case 'R':
                newHead.x += GamePanel.TILE_SIZE;
                break;
        }

        body.add(0, newHead);
        body.remove(body.size() - 1); // Supprime le dernier segment pour simuler le déplacement
    }

    public void draw(Graphics g) {
        for (Point p : body) {
            g.setColor(Color.GREEN);
            g.fillRect(p.x, p.y, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE);
        }
    }

    public boolean checkSelfCollision() {
        for (int i = 1; i < body.size(); i++) {
            if (getHeadX() == body.get(i).x && getHeadY() == body.get(i).y) {
                return true;
            }
        }
        return false;
    }

    public boolean checkWallCollision(int width, int height) {
        return getHeadX() < 0 || getHeadX() >= width || getHeadY() < 0 || getHeadY() >= height;
    }

}
