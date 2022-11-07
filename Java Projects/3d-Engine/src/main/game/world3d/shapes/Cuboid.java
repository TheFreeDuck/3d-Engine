package main.game.world3d.shapes;

import main.game.math.Point3d;
import main.game.math.Vertex;
import main.game.world3d.Object3d;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Fredrik
 */
public class Cuboid extends Object3d {

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
    private ArrayList<Vertex> vertices;
    private main.game.world3d.shapes.Rectangle r1, r2, r3, r4, r5, r6;

    public Cuboid(Point3d p1, double w, double h, double l) {
        super(p1);
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
        vertices = new ArrayList<>();
        vertices.add(vtx1);
        vertices.add(vtx2);
        vertices.add(vtx3);
        vertices.add(vtx4);
        vertices.add(vtx5);
        vertices.add(vtx6);
        vertices.add(vtx7);
        vertices.add(vtx8);

        r1 = new main.game.world3d.shapes.Rectangle(vtx2, vtx3, vtx4, vtx1);
        r2 = new main.game.world3d.shapes.Rectangle(vtx3, vtx7, vtx8, vtx4);
        r3 = new main.game.world3d.shapes.Rectangle(vtx6, vtx7, vtx8, vtx5);
        r4 = new main.game.world3d.shapes.Rectangle(vtx2, vtx6, vtx5, vtx1);
        r5 = new main.game.world3d.shapes.Rectangle(vtx6, vtx7, vtx3, vtx2);
        r6 = new main.game.world3d.shapes.Rectangle(vtx5, vtx8, vtx4, vtx1);
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    public void changeVertex(Vertex vertex, int element) {
        vertices.set(element, vertex);
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

    public double getH() {
        return h;
    }

    public double getL() {
        return l;
    }

}
