package org.snakeinc.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;

import org.snakeinc.snake.model.Anaconda;
import org.snakeinc.snake.model.Edible;
import org.snakeinc.snake.model.Apple;
import org.snakeinc.snake.model.Brocoli;
import org.snakeinc.snake.model.BoaConstrictor;
import org.snakeinc.snake.model.Python;
import org.snakeinc.snake.model.Snake;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    public static final int TILE_SIZE = 20;
    public static final int N_TILES_X = 25;
    public static final int N_TILES_Y = 25;
    public static final int GAME_WIDTH = TILE_SIZE * N_TILES_X;
    public static final int GAME_HEIGHT = TILE_SIZE * N_TILES_Y;
    private Timer timer;
    private Snake snake;
    private Edible edible;
    private boolean running = false;
    private char direction = 'R';
    private boolean gameOver = false;

    public GamePanel() {
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(this);

        startGame();
    }

    
    private Random random = new Random();

    private void startGame() {
        // snake = new Python();
        int objectType = random.nextInt(3);
        int edibleType = random.nextInt(2);
        switch (objectType) {
            case 0:
                snake = new Anaconda();
                break;
            case 1:
                snake = new Python();
                break;
            case 2:
                snake = new BoaConstrictor();
                break;
        }
        switch (edibleType) {
            case 0:
                edible = new Brocoli();
                break;
            case 1:
                edible = new Apple();
                break;
        }
        timer = new Timer(100, this);
        timer.start();
        running = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (running) {
            edible.draw(g);
            snake.draw(g);
        } else{
            gameOver=true;
            gameOver(g);
        }
    }

    private void gameOver(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over", (GAME_WIDTH - metrics.stringWidth("Game Over")) / 2, GAME_HEIGHT / 2);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("Press any key to play again", (GAME_WIDTH - metrics.stringWidth("Press any key to play again")) / 2, GAME_HEIGHT * 3/4);

    }

    private void checkCollision() {
        // Vérifie si le serpent se mord ou sort de l'écran
        if (snake.checkSelfCollision() || snake.checkWallCollision()) {
            running = false;
            timer.stop();
        }
        // Vérifie si le serpent mange la pomme
        if (snake.getHead().equals(edible.getPosition())) {
            edible.beEatenBy(snake);
            Random random = new Random();
            int edibleType = random.nextInt(2);
            switch (edibleType) {
                case 0:
                    edible = new Brocoli();
                    break;
                case 1:
                    edible = new Apple();
                    break;
            }
            edible.updateLocation();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            snake.move(direction);
            checkCollision();
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                // if (direction != 'R') {
                    direction = 'L';
                // }
                break;
            case KeyEvent.VK_RIGHT:
                // if (direction != 'L') {
                    direction = 'R';
                // }
                break;
            case KeyEvent.VK_UP:
                // if (direction != 'D') {
                    direction = 'U';
                // }
                break;
            case KeyEvent.VK_DOWN:
                // if (direction != 'U') {
                    direction = 'D';
                // }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.err.println(gameOver);
        if (!gameOver) return;
        gameOver = false;
        startGame();
    }
}
