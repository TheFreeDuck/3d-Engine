package main.game.world3d.mesh;

import main.game.math.Vertex;

import java.util.ArrayList;

public abstract class QuadMesh {
    protected ArrayList<Vertex> vertices;
    protected ArrayList<Edge> edges;
    protected ArrayList<Quad> quads;

    public ArrayList<Vertex> getVertices() {
        return vertices;
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

    public ArrayList<Quad> getFaces() {
        return quads;
    }

    public void setFaces(ArrayList<Quad> quads) {
        this.quads = quads;
    }
}
