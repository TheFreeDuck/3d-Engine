package main.math;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Fredrik
 */
public class Point2d {

    public static final int X = 0;
    public static final int Y = 1;
    private double x;
    private double y;

    public Point2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval((int) x, (int) y, 10, 10);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }

}
