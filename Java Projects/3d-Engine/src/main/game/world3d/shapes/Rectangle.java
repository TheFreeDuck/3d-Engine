package main.game.world3d.shapes;

import main.game.math.Point3d;
import main.game.math.Vector;
import main.game.math.Vertex;

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

    Vertex vtx1;
    Vertex vtx2;
    Vertex vtx3;
    Vertex vtx4;

    public Rectangle(Point3d p1, Point3d p2, Point3d p3, Point3d p4) {

        w = p1.getDistanceFromPoint(p2);
        h = p2.getDistanceFromPoint(p3);

        this.vtx1 = new Vertex(p1);
        this.vtx2 = new Vertex(p2);
        this.vtx3 = new Vertex(p3);
        this.vtx4 = new Vertex(p4);

        color = Color.green;

    }

    public Rectangle(Vertex vtx1, Vertex vtx2, Vertex vtx3, Vertex vtx4) {
        this.vtx1 = vtx1;
        this.vtx2 = vtx2;
        this.vtx3 = vtx3;
        this.vtx4 = vtx4;

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

    public ArrayList<Vertex> listOfPoints() {
        ArrayList<Vertex> points = new ArrayList<>();
        points.add(vtx1);
        points.add(vtx2);
        points.add(vtx3);
        points.add(vtx4);
        return points;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        int[] xPoly = {(int) vtx1.getP2d().getX(), (int) vtx2.getP2d().getX(), (int) vtx3.getP2d().getX(), (int) vtx4.getP2d().getX()};
        int[] yPoly = {(int) vtx1.getP2d().getY(), (int) vtx2.getP2d().getY(), (int) vtx3.getP2d().getY(), (int) vtx4.getP2d().getY()};
        //g.setColor(new Color((int) (Math.random() * 255),(int) (Math.random() * 255),(int) (Math.random() * 255)));
        g.setColor(color);
        if (vtx1.isInFrame()) {
            g.drawPolygon(xPoly, yPoly, 4);
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
        return vtx1;
    }

    public void setVtx1(Vertex vtx1) {
        this.vtx1 = vtx1;
    }

    public Vertex getVtx2() {
        return vtx2;
    }

    public void setVtx2(Vertex vtx2) {
        this.vtx2 = vtx2;
    }

    public Vertex getVtx3() {
        return vtx3;
    }

    public void setVtx3(Vertex vtx3) {
        this.vtx3 = vtx3;
    }

    public Vertex getVtx4() {
        return vtx4;
    }

    public void setVtx4(Vertex vtx4) {
        this.vtx4 = vtx4;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "vtx1=" + vtx1 +
                ", vtx2=" + vtx2 +
                ", vtx3=" + vtx3 +
                ", vtx4=" + vtx4 +
                '}';
    }
}
