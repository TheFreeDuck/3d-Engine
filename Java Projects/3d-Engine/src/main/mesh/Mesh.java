package main.mesh;

import main.math.Point2d;

import java.awt.*;
import java.util.ArrayList;

public abstract class Mesh {
    protected ArrayList<Vertex> vertices;
    //TODO change to hashmap
    protected ArrayList<Edge> edges;
    //TODO change to hashmap
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
        //TODO change edges arraylist in mesh class to hashmap to be able to make the draw vertices method faster
        for(ArrayList<Point2d> points : projectedPoints){
            for(Point2d point : points){
                g.setColor(Color.green);
                g.fillRect((int) point.getX(), (int) point.getY(), 3, 3);
            }

        }
    }

    public void drawEdges(Graphics g, ArrayList<ArrayList<Point2d>> projectedPoints) {
        //TODO change edges arraylist in mesh class to hashmap to be able to make the draw edges method faster
        if (!edges.isEmpty()) {
            for (ArrayList<Point2d> points : projectedPoints) {
                if (!edges.isEmpty() && !points.isEmpty()) {
                    // Loop over the edges and draw them using the points in the points list
                    for (Edge edge : edges) {
                        if (edge.vertex1 >= 0 && edge.vertex1 < points.size() && edge.vertex2 >= 0 && edge.vertex2 < points.size()) {
                            g.setColor(Color.white);
                            g.drawLine((int) points.get(edge.vertex1).getX(), (int) points.get(edge.vertex1).getY(), (int) points.get(edge.vertex2).getX(), (int) points.get(edge.vertex2).getY());
                        }
                    }
                }
            }
        }
    }

    protected void updateVertexConnectedEdges(){
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < edges.size(); j++) {
                if(edges.get(j).vertex1 == i || edges.get(j).vertex2 == i){
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
