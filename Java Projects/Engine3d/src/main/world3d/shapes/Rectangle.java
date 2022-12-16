package main.world3d.shapes;

import main.math.Point3d;
import main.math.Vector;
import main.mesh.Vertex;

import java.awt.*;
import java.util.ArrayList;

/**
 * p1 is top left of the rectangle
 *
 * @author Fredrik
 */
public class Rectangle {

    private double w, h;
    ArrayList<Vertex> vertices;
    private Vector v1, v2;
    private Color color;

    public Rectangle(Point3d p1, Point3d p2, Point3d p3, Point3d p4) {
        this.vertices = new ArrayList<>();
        vertices.add(new Vertex(p1));
        vertices.add(new Vertex(p2));
        vertices.add(new Vertex(p3));
        vertices.add(new Vertex(p4));

        w = p1.getDistanceFromPoint(p2);
        h = p2.getDistanceFromPoint(p3);

        v1 = new Vector(p1, p2);
        v2 = new Vector(p1, p4);

        color = Color.green;

    }

    public Rectangle(Vertex vtx1, Vertex vtx2, Vertex vtx3, Vertex vtx4) {
        this.vertices = new ArrayList<>();
        vertices.add(new Vertex(vtx1));
        vertices.add(new Vertex(vtx2));
        vertices.add(new Vertex(vtx3));
        vertices.add(new Vertex(vtx4));

        w = vtx1.getDistanceFromPoint(vtx2);
        h = vtx2.getDistanceFromPoint(vtx3);

        v1 = new Vector(vtx1, vtx2);
        v2 = new Vector(vtx1, vtx4);

        color = Color.white;

    }

    public Rectangle(Point3d p1, double w, double h) {
        this.w = w;
        this.h = h;
        vertices.add(new Vertex(p1));
        vertices.add(vertices.get(0).addPoint(0, w, 0));
        vertices.add(vertices.get(1).addPoint(0, 0, -h));
        vertices.add(vertices.get(2).addPoint(0, -w, 0));

        v1 = new Vector(p1, vertices.get(1));
        v2 = new Vector(p1, vertices.get(3));

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

    public Vector getV1() {
        return v1;
    }

    public void setV1(Vector v1) {
        this.v1 = v1;
    }

    public Vector getV2() {
        return v2;
    }

    public void setV2(Vector v2) {
        this.v2 = v2;
    }

    public Vertex getVtx1() {
        return vertices.get(0);
    }

    public void setVtx1(Vertex vtx1) {
        vertices.set(0,vtx1);
    }

    public Vertex getVtx2() {
        return vertices.get(1);
    }

    public void setVtx2(Vertex vtx2) {
        vertices.set(1,vtx2);
    }

    public Vertex getVtx3() {
        return vertices.get(2);
    }

    public void setVtx3(Vertex vtx3) {
        vertices.set(2,vtx3);
    }

    public Vertex getVtx4() {
        return vertices.get(3);
    }

    public void setVtx4(Vertex vtx4) {
        vertices.set(3,vtx4);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "vertices=" + vertices +
                '}';
    }
}
