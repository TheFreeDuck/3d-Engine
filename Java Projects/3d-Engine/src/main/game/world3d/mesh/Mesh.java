package main.game.world3d.mesh;

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

    public void draw(Graphics g){
        for(Vertex v : vertices){
            g.setColor(Color.white);
            g.fillRect((int) v.getP2d().getX(), (int) v.getP2d().getY(), 5, 5);
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
}
