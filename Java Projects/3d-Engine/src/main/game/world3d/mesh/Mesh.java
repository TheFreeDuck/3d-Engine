package main.game.world3d.mesh;

import main.game.math.Point2d;
import main.game.math.Vertex;

import java.awt.*;
import java.util.ArrayList;

public abstract class Mesh {
    protected ArrayList<Vertex> vertices;
    protected ArrayList<Edge> edges;
    protected ArrayList<Triangle> triangles;

    public Mesh() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        triangles = new ArrayList<>();
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public void drawVertices(Graphics g, ArrayList<ArrayList<Point2d>> projectedPoints){
        for(ArrayList<Point2d> points : projectedPoints){
            for(Point2d point : points){
                g.setColor(Color.green);
                g.fillRect((int) point.getX(), (int) point.getY(), 3, 3);
            }

        }
    }

    public void drawEdges(Graphics g){
        /*for(Edge edge : edges){
            g.setColor(Color.white);
            g.drawLine((int) vertices.get(edge.v1).getP2d().getX(), (int) vertices.get(edge.v1).getP2d().getY(), (int) vertices.get(edge.v2).getP2d().getX(), (int) vertices.get(edge.v2).getP2d().getY());
        }*/
    }

    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public ArrayList<Triangle> getFaces() {
        return triangles;
    }

    public void setFaces(ArrayList<Triangle> triangles) {
        this.triangles = triangles;
    }

    public void setVertex(int i, Vertex vertex) {
        vertices.set(i, vertex);
    }
}
