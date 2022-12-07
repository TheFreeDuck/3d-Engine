package main.game.math;

import java.util.ArrayList;

/**
 *
 * @author Fredrik
 */
public class Vertex extends Point3d {
    private ArrayList<Integer> connectedEdges;

    public Vertex(double x, double y, double z) {
        super(x, y, z);
    }

    public Vertex(Point3d point) {
        super(point.getX(), point.getY(), point.getZ());
    }

    @Override
    public Vertex addPoint(double x, double y, double z) {
        return new Vertex(this.getX() + x, this.getY() + y, this.getZ() + z);
    }
    public void addConnectedEdge(int index){
        if(connectedEdges == null){
            connectedEdges = new ArrayList<>();
        }
        connectedEdges.add(index);
    }

    public ArrayList<Integer> getConnectedEdges() {
        return connectedEdges;
    }
}
