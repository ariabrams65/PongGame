package GameLogic;

import Pieces.Ball;
import Pieces.Direction;
import Pieces.Paddle;
import Pieces.Piece;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

public class Game {

    private Ball ball;
    private List<Paddle> paddles;
    private int width;
    private int height;
    private ScoreManager sm;
    Timer timer;

    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        this.ball = new Ball(width / 2, height / 2, 10, 10, -1, 1);
        Paddle p1 = new Paddle(width / 10, height / 2 - 50, 15, 100, 0, 0, Direction.LEFT);
        Paddle p2 = new Paddle(width - (width / 10) - 15, height / 2 - 50, 15, 100, 0, 0, Direction.RIGHT);
        this.paddles = new ArrayList<Paddle>();
        paddles.add(p1);
        paddles.add(p2);
        this.sm = new ScoreManager();
    }

    public void tick() {
        ball.move();
        System.out.println(ball.getDx());

        for (Paddle p : paddles) {
            p.move();
        }
        manageCollisions();
    }

    public Ball getBall() {
        return this.ball;
    }

    public List<Paddle> getPaddles() {
        return this.paddles;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public ScoreManager getScoreManager() {
        return this.sm;
    }

    private void manageCollisions() {
        Rectangle ballCollision = ball.getBounds();
        Rectangle top = new Rectangle(0, -100, width, 100);
        Rectangle bottom = new Rectangle(0, height - 40, width, 100);
        Rectangle left = new Rectangle(-100, 0, 100, height);
        Rectangle right = new Rectangle(width, 0, 100, height);

        for (Paddle paddle : paddles) {
            Rectangle paddleCollision = paddle.getBounds();

            //managePaddleSections(paddle, ballCollision);

            if (ballCollision.intersects(paddleCollision)) {
                  ball.changeDirections(Direction.HORIZONTAL, 1);

                if (paddle.getSide() == Direction.LEFT) {
                    ball.setX(paddle.getX() + paddle.getLength());
                } else {
                    ball.setX(paddle.getX() - ball.getLength());
                }
            }
            if (paddleCollision.intersects(top)) {
                paddle.setY(0);
                paddle.setDy(0);
            }
            if (paddleCollision.intersects(bottom)) {
                paddle.setY(height - paddle.getHeight() - 40);
                paddle.setDy(0);
            }
        }
        if (ballCollision.intersects(top) || ballCollision.intersects(bottom)) {
            ball.changeDirections(Direction.VERTICAL, 1);

        } else if (ballCollision.intersects(left)) {
            sm.addRight();
            reset();

        } else if (ballCollision.intersects(right)) {
            sm.addLeft();
            reset();
        }
    }

    public void reset() {
        timer.stop();
        ball.setX(ball.getInitialX());
        ball.setY(ball.getInitialY());

        for (Paddle p : paddles) {
            p.setX(p.getInitialX());
            p.setY(p.getInitialY());
            p.setDy(0);
        }
    }

    public void addTimer(Timer t) {
        this.timer = t;
    }

    public Timer getTimer() {
        return this.timer;
    }

    private void managePaddleSections(Paddle paddle, Rectangle bc) {
        // changes the reflection angle of the ball based on where it hits the paddle
        Piece[] ps = paddle.getSections();

        for (int i = 0; i < ps.length; i++) {
            Rectangle pieceCollision = ps[i].getBounds();

            if (ball.getDy() > 0) {

                if (i == 0 && bc.intersects(pieceCollision)) {
                    ball.changeDirections(Direction.HORIZONTAL, 2);


                } else if (i == 1 && bc.intersects(pieceCollision)) {
                    ball.changeDirections(Direction.HORIZONTAL, 1.5);

                } else if (i == 2 && bc.intersects(pieceCollision)) {
                    ball.changeDirections(Direction.HORIZONTAL, 1);

                } else if (i == 3 && bc.intersects(pieceCollision)) {
                    ball.changeDirections(Direction.HORIZONTAL, 2/3);

                } else if (i == 4 && bc.intersects(pieceCollision)) {
                    ball.changeDirections(Direction.HORIZONTAL, .5);
                }

            } else if (ball.getY() < 0) {

                if (i == 0 && bc.intersects(pieceCollision)) {
                    ball.changeDirections(Direction.HORIZONTAL, .5);

                } else if (i == 1 && bc.intersects(pieceCollision)) {
                    ball.changeDirections(Direction.HORIZONTAL, 2/3);

                } else if (i == 2 && bc.intersects(pieceCollision)) {
                    ball.changeDirections(Direction.HORIZONTAL, 1);

                } else if (i == 3 && bc.intersects(pieceCollision)) {
                    ball.changeDirections(Direction.HORIZONTAL, 1.5);

                } else if (i == 2 && bc.intersects(pieceCollision)) {
                    ball.changeDirections(Direction.HORIZONTAL, 2);
                }
            } else {
                if (i == 0 && bc.intersects(pieceCollision)) {
                    ball.changeDirections(Direction.HORIZONTAL, 125);

                } else if (i == 1 && bc.intersects(pieceCollision)) {
                    ball.changeDirections(Direction.HORIZONTAL, 105);

                } else if (i == 2 && bc.intersects(pieceCollision)) {
                    ball.changeDirections(Direction.HORIZONTAL, 1);

                } else if (i == 3 && bc.intersects(pieceCollision)) {
                    ball.changeDirections(Direction.HORIZONTAL, 75);

                } else if (i == 2 && bc.intersects(pieceCollision)) {
                    ball.changeDirections(Direction.HORIZONTAL, 60);
                }
            }

        }
    }
}
