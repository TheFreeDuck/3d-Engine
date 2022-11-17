package main.game.world3d.mesh.meshes;

import main.game.math.Point3d;
import main.game.math.Vertex;
import main.game.world3d.mesh.Edge;
import main.game.world3d.mesh.Triangle;
import main.game.world3d.mesh.Mesh;

public class Cuboid extends Mesh {
    double width, height, length;
    Point3d position;
    public Cuboid(double height,double width,double length,Point3d position) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.position = position;

        vertices.add(new Vertex(position));
        vertices.add(vertices.get(0).addPoint(0, 0, height));
        vertices.add(vertices.get(1).addPoint(0, width, 0));
        vertices.add(vertices.get(2).addPoint(0, 0, -height));
        vertices.add(vertices.get(3).addPoint(length, 0, 0));
        vertices.add(vertices.get(4).addPoint(0, 0, height));
        vertices.add(vertices.get(5).addPoint(0, -width, 0));
        vertices.add(vertices.get(6).addPoint(0, 0, -height));

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

        triangles.add(new Triangle(0,2));
        triangles.add(new Triangle(2,11));
        triangles.add(new Triangle(9,11));
        triangles.add(new Triangle(7,8));
        triangles.add(new Triangle(7,2));
        triangles.add(new Triangle(3,4));

    }
}
