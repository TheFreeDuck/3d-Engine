package main.game.world3d.shapes;

import main.game.math.Point3d;
import main.game.math.Vertex;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Fredrik
 */
public class Cuboid {

    private double w;
    private double h;
    private double l;
    private Vertex vtx1;
    private Vertex vtx2;
    private Vertex vtx3;
    private Vertex vtx4;
    private Vertex vtx5;
    private Vertex vtx6;
    private Vertex vtx7;
    private Vertex vtx8;
    private ArrayList<Vertex> vertecies;
    private main.game.world3d.shapes.Rectangle r1, r2, r3, r4, r5, r6;

    public Cuboid(Point3d p1, double w, double h, double l) {
        this.w = w;
        this.h = h;
        this.l = l;
        this.vtx1 = new Vertex(p1);
        this.vtx2 = vtx1.addPoint(0, 0, h);
        this.vtx3 = vtx2.addPoint(0, w, 0);
        this.vtx4 = vtx3.addPoint(0, 0, -h);
        this.vtx5 = vtx1.addPoint(l, 0, 0);
        this.vtx6 = vtx5.addPoint(0, 0, h);
        this.vtx7 = vtx6.addPoint(0, w, 0);
        this.vtx8 = vtx7.addPoint(0, 0, -h);
        vertecies = new ArrayList<>();
        vertecies.add(vtx1);
        vertecies.add(vtx2);
        vertecies.add(vtx3);
        vertecies.add(vtx4);
        vertecies.add(vtx5);
        vertecies.add(vtx6);
        vertecies.add(vtx7);
        vertecies.add(vtx8);

        r1 = new main.game.world3d.shapes.Rectangle(vtx2, vtx3, vtx4, vtx1);
        r2 = new main.game.world3d.shapes.Rectangle(vtx3, vtx7, vtx8, vtx4);
        r3 = new main.game.world3d.shapes.Rectangle(vtx6, vtx7, vtx8, vtx5);
        r4 = new main.game.world3d.shapes.Rectangle(vtx2, vtx6, vtx5, vtx1);
        r5 = new main.game.world3d.shapes.Rectangle(vtx6, vtx7, vtx3, vtx2);
        r6 = new main.game.world3d.shapes.Rectangle(vtx5, vtx8, vtx4, vtx1);
    }

    public ArrayList<Vertex> getVertecies() {
        return vertecies;
    }

    public void setVertecies(ArrayList<Vertex> vertecies) {
        this.vertecies = vertecies;
    }

    public void changeVertex(Vertex vertex, int element) {
        vertecies.set(element, vertex);
    }

    public ArrayList<main.game.world3d.shapes.Rectangle> listOfRectangles() {
        ArrayList<main.game.world3d.shapes.Rectangle> rectangles = new ArrayList<>();
        rectangles.add(r1);
        rectangles.add(r2);
        rectangles.add(r3);
        rectangles.add(r4);
        rectangles.add(r5);
        rectangles.add(r6);
        return rectangles;
    }

    public void update() {

    }

    public void draw(Graphics g) {
        r1 = new main.game.world3d.shapes.Rectangle(vtx2, vtx3, vtx4, vtx1);
        r2 = new main.game.world3d.shapes.Rectangle(vtx3, vtx7, vtx8, vtx4);
        r3 = new main.game.world3d.shapes.Rectangle(vtx6, vtx7, vtx8, vtx5);
        r4 = new main.game.world3d.shapes.Rectangle(vtx2, vtx6, vtx5, vtx1);
        r5 = new main.game.world3d.shapes.Rectangle(vtx6, vtx7, vtx3, vtx2);
        r6 = new main.game.world3d.shapes.Rectangle(vtx5, vtx8, vtx4, vtx1);
        for (Rectangle rectangle : listOfRectangles()) {
            rectangle.draw(g);
        }
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getL() {
        return l;
    }

    public void setL(double l) {
        this.l = l;
    }
}
