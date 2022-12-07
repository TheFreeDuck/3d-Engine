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

    public void drawEdges(Graphics g,ArrayList<ArrayList<Point2d>> projectedPoints){
        for(ArrayList<Point2d> points : projectedPoints) {
            for (Edge edge : edges) {
                g.setColor(Color.white);
                g.drawLine((int) points.get(edge.v1).getX(), (int) points.get(edge.v1).getY(), (int) points.get(edge.v2).getX(), (int) points.get(edge.v2).getY());
            }
        }
    }

    protected void updateVertexConnectedEdges(){
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < edges.size(); j++) {
                if(edges.get(j).v1 == i || edges.get(j).v2 == i){
                    vertices.get(i).addConnectedEdge(j);
                }
            }
        }
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
