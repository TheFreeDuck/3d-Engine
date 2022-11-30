package main.game.math;

import java.util.ArrayList;

/**
 *
 * @author Fredrik
 */
public class Vertex extends Point3d {
//TODO: remove p2D
    private Point2d p2D = new Point2d(0,0);
    private ArrayList<Integer> connectedVertices;

    public Vertex(double x, double y, double z) {
        super(x, y, z);
        connectedVertices = new ArrayList<>();
        p2D = new Point2d(0,0);
    }

    public Vertex(Point3d point) {
        super(point.getX(), point.getY(), point.getZ());
    }

    public Point2d getP2d() {
        return p2D;
    }

    public void setP2d(Point2d p2D) {
        this.p2D = p2D;
    }

    @Override
    public Vertex addPoint(double x, double y, double z) {
        return new Vertex(this.getX() + x, this.getY() + y, this.getZ() + z);
    }
    public void addConnectedVertex(int index){
        connectedVertices.add(index);
    }

}
