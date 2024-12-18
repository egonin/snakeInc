package org.snakeinc.snake.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import lombok.Getter;
import org.snakeinc.snake.GamePanel;

public abstract class Edible {

    @Getter
    protected Tile position;
    private final Random random;

    public Edible() {
        random = new Random();
        updateLocation();
    }

    public void beEatenBy(AlimentEater alimentEater) {
        if (this instanceof Apple) {
            alimentEater.eat((Apple)this);
        } else if (this instanceof Brocoli) {
            alimentEater.eat((Brocoli)this);
        }
        
    };

    public void updateLocation() {
        position = new Tile(random.nextInt(0, (GamePanel.GAME_WIDTH / GamePanel.TILE_SIZE)),
                random.nextInt(0, (GamePanel.GAME_HEIGHT / GamePanel.TILE_SIZE)));

    }

    public abstract void draw(Graphics g);

}