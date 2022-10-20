package world3d.objects.shapes;

import java.awt.Color;
import java.awt.Graphics;
import math.Point2d;
import math.Point3d;
import math.Vertex;

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
    
    public void draw(Graphics g) {
        g.setColor(Color.white);
        int[] xPoly = {(int)vtx1.getP2d().getX(), (int)vtx2.getP2d().getX(), (int)vtx3.getP2d().getX()};
        int[] yPoly = {(int)vtx1.getP2d().getY(), (int)vtx2.getP2d().getY(), (int)vtx3.getP2d().getY()};
        //g.setColor(new Color((int) (Math.random() * 255),(int) (Math.random() * 255),(int) (Math.random() * 255)));
        g.setColor(color);
        g.drawPolygon(xPoly, yPoly, 3);
    }
    
    

}
