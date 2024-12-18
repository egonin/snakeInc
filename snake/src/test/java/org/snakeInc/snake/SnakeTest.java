package org.snakeInc.snake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.snakeinc.snake.model.Edible;
import org.snakeinc.snake.model.Snake;
import org.snakeinc.snake.model.Anaconda;
import org.snakeinc.snake.model.Apple;

public class SnakeTest {

    @Test
    public void snakeEatApples_ReturnsCorrectBodySize() {
        Snake snake = new Anaconda();
        Edible edible = new Apple();
        snake.eat((Apple) edible);
        Assertions.assertEquals(2, snake.getBody().size());

    }

    @Test void snakeMovesUp_ReturnCorrectHead() {
        Snake snake = new Anaconda();
        snake.move('U');
        Assertions.assertEquals(5, snake.getHead().getX());
        Assertions.assertEquals(5, snake.getHead().getY());
    }

}
