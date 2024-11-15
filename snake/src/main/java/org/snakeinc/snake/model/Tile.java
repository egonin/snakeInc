package org.snakeinc.snake.model;

import java.awt.Graphics;
import java.util.Objects;
import lombok.Getter;
import org.snakeinc.snake.GamePanel;


@Getter
public class Tile {

    @Getter
    private int X;

    @Getter
    private int Y;

    private int upperPixelX;
    private int upperPixelY;

    public Tile(int x, int y) {
        setX(x);
        setY(y);
    }

    public Tile copy() {
        return new Tile(this.X, this.Y);
    }

    public void setX(int X) {
        this.X = X;
        upperPixelX = X * GamePanel.TILE_SIZE;
    }

    public void setY(int Y) {
        this.Y = Y;
        upperPixelY = Y * GamePanel.TILE_SIZE;
    }

    public void drawRectangle(Graphics g) {
        g.fillRect(upperPixelX, upperPixelY, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE);
    }

    public void drawOval(Graphics g) {
        g.fillOval(upperPixelX, upperPixelY, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE);
    }

    public boolean isInsideGame() {
        return (((X > 0) && (X < GamePanel.N_TILES_X)) && ((Y > 0) && (Y < GamePanel.N_TILES_Y)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tile tile = (Tile) o;
        return X == tile.X && Y == tile.Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }
}
