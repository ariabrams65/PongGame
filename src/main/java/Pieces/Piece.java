
package Pieces;

import java.awt.Rectangle;

public class Piece {
    
    private int x;
    private int y;
    private int length;
    private int height;
    private int initialX;
    private int initialY;
    private double dx;
    private double dy;
    
    public Piece(int x, int y, int length, int height, double dx, double dy) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.height = height;
        this.initialX = x;
        this.initialY = y;
        this.dx = dx;
        this.dy = dy;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }    
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, length , height);
    }
    
    public int getLength() {
        return this.length;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getInitialX() {
        return this.initialX;
    }
    
    public int getInitialY() {
        return this.initialY;
    }
    
        public double getDx() {
        return this.dx;
    }

    public double getDy() {
        return this.dy;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }
    
    public void addY(double y) {
        this.y += y;
    }
    
    public void addX(double x) {
        this.x += x;
    }
}
