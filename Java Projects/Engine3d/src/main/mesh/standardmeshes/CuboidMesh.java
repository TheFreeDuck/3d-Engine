package main.mesh.standardmeshes;

import main.math.Point3d;
import main.mesh.Vertex;
import main.mesh.Edge;
import main.mesh.Mesh;
import main.mesh.Triangle;

public class CuboidMesh extends Mesh {
    double width, height, length;
    Point3d position;
    public CuboidMesh(double height, double width, double length, Point3d position) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.position = position;

        // Create vertices
        vertices.add(new Vertex(position));
        vertices.add(vertices.get(0).addPoint(0, 0, height));
        vertices.add(vertices.get(1).addPoint(0, width, 0));
        vertices.add(vertices.get(2).addPoint(0, 0, -height));
        vertices.add(vertices.get(3).addPoint(length, 0, 0));
        vertices.add(vertices.get(4).addPoint(0, 0, height));
        vertices.add(vertices.get(5).addPoint(0, -width, 0));
        vertices.add(vertices.get(6).addPoint(0, 0, -height));

        // Create edges
        edges.add(new Edge(0,1)); //index 0
        edges.add(new Edge(0,7)); //index 1
        edges.add(new Edge(0,3)); //index 2
        edges.add(new Edge(1,2)); //index 3
        edges.add(new Edge(1,6)); //index 4
        edges.add(new Edge(2,3)); //index 5
        edges.add(new Edge(2,5)); //index 6
        edges.add(new Edge(3,4)); //index 7
        edges.add(new Edge(4,5)); //index 8
        edges.add(new Edge(4,7)); //index 9
        edges.add(new Edge(5,6)); //index 10
        edges.add(new Edge(6,7)); //index 11

        // Create triangles
        triangles.add(new Triangle(0, 2, 3));
        triangles.add(new Triangle(0, 1, 2));
        triangles.add(new Triangle(1, 5, 6));
        triangles.add(new Triangle(1, 2, 5));
        triangles.add(new Triangle(4, 5, 6));
        triangles.add(new Triangle(4, 6, 7));
        triangles.add(new Triangle(0, 4, 7));
        triangles.add(new Triangle(0, 3, 7));
        triangles.add(new Triangle(3, 6, 7));
        triangles.add(new Triangle(3, 5, 6));
        triangles.add(new Triangle(0, 1, 4));
        triangles.add(new Triangle(1, 4, 5));

        updateVertexConnectedEdges();
    }
}
