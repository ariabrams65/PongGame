package UI;

import GameLogic.Game;
import Pieces.Ball;
import Pieces.Direction;
import Pieces.Paddle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    private Paddle paddle1;
    private Paddle paddle2;
    private Ball ball;
    private Game game;

    public KeyboardListener(Game game) {
        this.game = game;
        this.paddle1 = game.getPaddles().get(0);
        this.paddle2 = game.getPaddles().get(1);
        this.ball = game.getBall();
    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        if (arg0.getKeyCode() == KeyEvent.VK_UP) {
            paddle2.setDirection(Direction.UP);

        } else if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
            paddle2.setDirection(Direction.DOWN);

        } else if (arg0.getKeyCode() == KeyEvent.VK_W) {
            paddle1.setDirection(Direction.UP);

        } else if (arg0.getKeyCode() == KeyEvent.VK_S) {
            paddle1.setDirection(Direction.DOWN);

        }  else if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
            game.getTimer().start();
            
        } else if (arg0.getKeyCode() == KeyEvent.VK_R) {
            game.reset();
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        if (arg0.getKeyCode() == KeyEvent.VK_UP) {
            paddle2.stop();

        } else if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
            paddle2.stop();

        } else if (arg0.getKeyCode() == KeyEvent.VK_W) {
            paddle1.stop();

        } else if (arg0.getKeyCode() == KeyEvent.VK_S) {
            paddle1.stop();

        }
    }

}
