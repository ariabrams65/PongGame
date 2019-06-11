package Pieces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Paddle extends Piece {

    private Direction d;
    private Piece[] sections;

    public Paddle(int initialX, int initialY, int length, int height, int dx, int dy, Direction d) {
        super(initialX, initialY, length, height, dx, dy);
        this.d = d;
        this.sections = new Piece[5];
        createSections();

    }

    public void setDirection(Direction direction) {
        if (direction == Direction.UP) {
            setDy(-10);

        } else if (direction == Direction.DOWN) {
            setDy(10);
        }
    }

    public void draw(Graphics g) {
        if (d == Direction.RIGHT) {
            g.setColor(Color.BLUE);
        } else {
            g.setColor(Color.RED);
        }
        g.fillRect(getX(), getY(), getLength(), getHeight());
    }

    public void stop() {
        setDy(0);
        setDx(0);
    }

    public void move() {
        addX(getDx());
        addY(getDy());
        createSections();
    }

    public Direction getSide() {
        return this.d;
    }

    private void createSections() {
        int height = getHeight() / 5;
        int y = getY();
        int x = getX();

        for (int i = 0; i < 5; i++) {

            sections[i] = new Piece(x, y, getLength(), height, getDx(), getDy());
            y += height;
        }
    }

    public Piece[] getSections() {
        return this.sections;
    }

}
