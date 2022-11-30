package main.game.math;

import java.util.ArrayList;

/**
 *
 * @author Fredrik
 */
public class Vertex extends Point3d {
    private ArrayList<Integer> connectedVertices;

    public Vertex(double x, double y, double z) {
        super(x, y, z);
        connectedVertices = new ArrayList<>();
    }

    public Vertex(Point3d point) {
        super(point.getX(), point.getY(), point.getZ());
    }

    @Override
    public Vertex addPoint(double x, double y, double z) {
        return new Vertex(this.getX() + x, this.getY() + y, this.getZ() + z);
    }
    public void addConnectedVertex(int index){
        connectedVertices.add(index);
    }

}
