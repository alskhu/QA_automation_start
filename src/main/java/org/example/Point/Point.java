package org.example.Point;

public class Point implements Movable{
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return this.y;
    }

    public void print() {
        System.out.println("x: " + this.x);
        System.out.println("y: " + this.y);
    }

    @Override
    public void moveUp() {
        this.y++;
    }

    @Override
    public void moveDown() {
        this.y--;

    }

    @Override
    public void moveLeft() {
        this.x--;

    }

    @Override
    public void moveRight() {
        this.x++;
    }
}
