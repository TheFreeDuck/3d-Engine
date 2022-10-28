package main.game.math;

/**
 * @author Fredrik
 */
public class Ray {

    private Point3d p1;
    private Point3d p2;

    public Ray(Point3d p1, Point3d p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Calculates the vector of the ray. p1 is the front of the vector
     *
     * @return the vector of the ray
     */
    public Vector getVector() {
        return new Vector(p2.getX() - p1.getX(), p2.getY() - p1.getY(), p2.getZ() - p1.getZ());
    }

    public double length() {
        return this.getVector().scalar();
    }

    public Point3d getP1() {
        return p1;
    }

    public void setP1(Point3d p1) {
        this.p1 = p1;
    }

    public Point3d getP2() {
        return p2;
    }

    public void setP2(Point3d p2) {
        this.p2 = p2;
    }


}
