package main.game.world3d.shapes;

import main.game.math.Point3d;
import main.game.math.Vector;
import main.game.math.Vertex;
import main.game.world3d.Object3d;
import main.game.world3d.Orientation;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Fredrik
 */
public class Cuboidnew extends Object3d {

    private double w;
    private double h;
    private double l;
    private ArrayList<Vertex> vertices;

    public Cuboidnew(Point3d p1, double w, double h, double l) {
        super(p1,new Orientation(new Vector(1,0,0),new Vector(0,1,0)));
        this.w = w;
        this.h = h;
        this.l = l;
        vertices.add(new Vertex(p1));
        vertices.add(vertices.get(0).addPoint(0, 0, h));
        vertices.add(vertices.get(1).addPoint(0, w, 0));
        vertices.add(vertices.get(2).addPoint(0, 0, -h));
        vertices.add(vertices.get(0).addPoint(l, 0, 0));
        vertices.add(vertices.get(4).addPoint(0, 0, h));
        vertices.add(vertices.get(5).addPoint(0, w, 0));
        vertices.add(vertices.get(6).addPoint(0, 0, -h));
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

    public void update() {

    }

    public void draw(Graphics g) {
        r1 = new Rectangle(vtx2, vtx3, vtx4, vtx1);
        r2 = new Rectangle(vtx3, vtx7, vtx8, vtx4);
        r3 = new Rectangle(vtx6, vtx7, vtx8, vtx5);
        r4 = new Rectangle(vtx2, vtx6, vtx5, vtx1);
        r5 = new Rectangle(vtx6, vtx7, vtx3, vtx2);
        r6 = new Rectangle(vtx5, vtx8, vtx4, vtx1);
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
