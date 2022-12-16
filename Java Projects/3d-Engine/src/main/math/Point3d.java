package main.math;

import main.mesh.Vertex;

/**
 *
 * @author Fredrik
 */
public class Point3d {

    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    private double x;
    private double y;
    private double z;
    boolean inFrame;

    /**
     * creates a point from 3 values
     * @param x value
     * @param y value
     * @param z value
     */
    public Point3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        inFrame = true;
    }

    public Point3d addPoint(double x, double y, double z) {
        return new Point3d(this.x + x, this.y + y, this.z + z);
    }

    /**
     * Adds the values of a vector to the values of the point
     * @param velocity The vector to add
     * @return The new point
     */
    public Point3d addVector(Vector velocity) {
        return new Point3d(this.x + velocity.getX(), this.y + velocity.getY(), this.z + velocity.getZ());
    }

    /**
     * Adds a given distance along a given vector
     * @param v The vector to move along
     * @param distance The distance to move
     * @return The moved point
     */
    public Point3d addDistanceAlongVector(Vector v, double distance) {
        v = v.unitVector();
        v = new Vector(v.getX()*distance,v.getY()*distance,v.getZ()*distance);
        return new Point3d(this.x + v.getX(), this.y + v.getY(), this.z + v.getZ());
    }

    public Point3d subtractPoint(Point3d p2) {
        return new Point3d(x - p2.x, y - p2.y, z - p2.z);
    }

    public double getDistanceFromPoint(Point3d p) {
        return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2) + Math.pow(p.z - z, 2));
    }

    public Point3d midpoint(Vertex other) {
        double x = (this.getX() + other.getX()) / 2;
        double y = (this.getY() + other.getY()) / 2;
        double z = (this.getZ() + other.getZ()) / 2;
        return new Point3d(x, y, z);
    }

    public boolean isInFrontOf(Point3d p,Vector vector){
        return vector.dotProduct(new Vector(p, this)) > 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

    public boolean isInFrame() {
        return inFrame;
    }

    public void setInFrame(boolean inFrame) {
        this.inFrame = inFrame;
    }
    
    
}
