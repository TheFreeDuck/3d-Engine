package main.game.world3d.shapes;

import main.game.math.Point3d;
import main.game.math.Vector;
import main.game.math.Vertex;
import main.game.world3d.Object3d;
import main.game.world3d.Orientation;
import java.util.ArrayList;

/**
 * @author Fredrik
 */
public class Cuboidnew extends Object3d {

    private double w;
    private double h;
    private double l;

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
        vertices.get(0).addConnectedVertex(1);
        vertices.get(0).addConnectedVertex(1);
        vertices.get(0).addConnectedVertex(1);
         //TODO make vertices know which other vertices they are connected to
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
