package main.world3d.shapes;

import main.math.Point2d;
import main.math.Point3d;
import main.mesh.Vertex;

import java.awt.*;

/**
 *
 * @author Fredrik
 */
public class Triangle {

    private Vertex vtx1,vtx2,vtx3;
    private Point2d p12D, p22D;
    private Color color;

    public Triangle(Point3d p1, Point3d p2, Point3d p3) {
        vtx1 = new Vertex(p1);
        vtx2 = new Vertex(p2);
        vtx3 = new Vertex(p3);
        color = Color.green;
    }

    public Point2d getP12D() {
        return p12D;
    }

    public void setP12D(Point2d p12D) {
        this.p12D = p12D;
    }

    public Point2d getP22D() {
        return p22D;
    }

    public void setP22D(Point2d p22D) {
        this.p22D = p22D;
    }

    public Vertex getVtx1() {
        return vtx1;
    }

    public void setVtx1(Vertex vtx1) {
        this.vtx1 = vtx1;
    }

    public Vertex getVtx2() {
        return vtx2;
    }

    public void setVtx2(Vertex vtx2) {
        this.vtx2 = vtx2;
    }

    public Vertex getVtx3() {
        return vtx3;
    }

    public void setVtx3(Vertex vtx3) {
        this.vtx3 = vtx3;
    }
    
    

}
