package math;

/**
 * @author Fredrik
 */
public class Vector {

    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Point3d p1, Point3d p2) {
        this.x = p2.getX() - p1.getX();
        this.y = p2.getY() - p1.getY();
        this.z = p2.getZ() - p1.getZ();
    }

    public double scalar() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public Vector unitVector() {
        return new Vector(this.x / this.scalar(), this.y / this.scalar(), this.z / this.scalar());
    }

    public void setScalarOnAxis(double magnitude, int axis) {
        if (axis == Point3d.X) {
            x = magnitude;
        } else if (axis == Point3d.Y) {
            y = magnitude;
        } else if (axis == Point3d.Z) {
            z = magnitude;
        }
    }

    public void rotate(double angle, int axis) {
        switch (axis) {
            case Point3d.X:
                y = y * Math.cos(angle) - z * Math.sin(angle);
                z = y * Math.sin(angle) + z * Math.cos(angle);
                break;
            case Point3d.Y:
                x = x * Math.cos(angle) + z * Math.sin(angle);
                z = -x * Math.sin(angle) + z * Math.cos(angle);
                break;
            case Point3d.Z:
                x = x * Math.cos(angle) - y * Math.sin(angle);
                y = x * Math.sin(angle) + y * Math.cos(angle);
                break;
        }

    }

    public double calculateAngleBetweenVector(Vector vector){
        return Math.acos((this.dotProduct(vector))/ (this.scalar() * vector.scalar()));
    }


    public Vector addVector(Vector vector) {
        vector.setX(vector.getX() + x);
        vector.setY(vector.getY() + y);
        vector.setZ(vector.getZ() + z);
        return vector;
    }

    public double dotProduct(Vector v) {
        return x * v.x + y * v.y + z * v.z;
    }

    public Vector crossProduct(Vector v) {
        return new Vector(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x);
    }

    public Vector divideScalar(double value) {
        return new Vector(x / value, y / value, z / value);
    }

    public Vector multiplyScalar(double value) {
        return new Vector(x * value, y * value, z * value);
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
        return "Vector{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

}
