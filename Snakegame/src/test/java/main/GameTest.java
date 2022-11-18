package main;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import javafx.geometry.Point2D;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

    //Test that snake can move in all directions
    @Test
    public void snakeMovesTest(){
        Snake snake = new Snake(new Point2D(0, 0));

        for (Direction direction : Direction.values()) {
            Point2D oldPosition = snake.getPosition();

            snake.setDirection(direction);

            snake.update();

            assertThat(snake.getPosition(), is(oldPosition.add(direction.vector)));
        }
    }

    @Test
    public void snakeFoodCollisionTest(){
        Snake snake = new Snake(new Point2D(10,5));

        Food food = new Food(new Point2D(10,5));

        assertTrue(snake.isCollidingWith(food));
    }

    @Test
    public void snakeCanGrowTest(){
        Snake snake = new Snake(new Point2D(0,0));

        snake.setDirection(Direction.RIGHT);
        snake.update();
        snake.grow();

        assertThat(snake.getLength(), is(2));
        assertThat(snake.getBody(), hasItem(new Point2D(0,0)));
    }

    @Test
    public void snakeOutOfBoundsTest(){
        Snake snake = new Snake(new Point2D(25,0));

        assertTrue(snake.isOutOfBounds(24));
        assertFalse(snake.isOutOfBounds(25));
    }

    @Test
    public void snakeCanDieTest(){
        Snake snake = new Snake(new Point2D(0, 0));

        for (int i = 0; i < 5; i++) {
            snake.setDirection(Direction.RIGHT);
            snake.update();
            snake.grow();
        }

        snake.setDirection(Direction.UP);
        snake.update();

        snake.setDirection(Direction.LEFT);
        snake.update();

        snake.setDirection(Direction.DOWN);
        snake.update();

        assertTrue(snake.isDead());
    }
}