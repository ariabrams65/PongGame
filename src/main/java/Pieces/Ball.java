package Pieces;

import java.awt.Graphics;

public class Ball extends Piece {

    public Ball(int initialX, int initialY, int length, int height, double dx, double dy) {
        super(initialX, initialY, length, height, dx, dy);
    }

    public void changeDirections(Direction d, double i) {
        if (d == Direction.HORIZONTAL) {
            setDx(getDx() * i * -1);

        } else if (d == Direction.VERTICAL) {
            setDy(getDy() * -1);
        }
    }

    public void move() {
        double dx = getDx();
        double dy = getDy();

        if (dx == 0 && dy == 0) {
            return;
        }
        //moves the ball x pixels diagnally
        double hypotenuse = Math.sqrt((dx * dx) + (dy * dy));
        double ratio = 15 / hypotenuse;
        addX(dx * ratio);
        addY(dy * ratio);
    }

    public void draw(Graphics g) {
        g.fillOval(getX(), getY(), getLength(), getHeight());
    }

}
