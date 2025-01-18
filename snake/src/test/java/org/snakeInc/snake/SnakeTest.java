package org.snakeInc.snake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.snakeinc.snake.model.Edible;
import org.snakeinc.snake.model.Snake;
import org.snakeinc.snake.model.Python;
import org.snakeinc.snake.model.Apple;

public class SnakeTest {

    @Test
    public void snakeEatApples_ReturnsCorrectBodySize() {
        Snake snake = new Python();
        Edible edible = new Apple();
        // snake.eat((Apple) edible);
        edible.beEatenBy(snake);
        Assertions.assertEquals(2, snake.getBody().size());

    }

    @Test void snakeMovesUp_ReturnCorrectHead() {
        Snake snake = new Python();
        snake.move('R');
        Assertions.assertEquals(6, snake.getHead().getX());
        Assertions.assertEquals(5, snake.getHead().getY());
    }

}
