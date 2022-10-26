package math;

/**
 * @author Fredrik
 */
public class Vector {

    private double x;
    private double y;
    private double z;

    /**
     * Creates vector from 3 values
     * @param x value
     * @param y value
     * @param z value
     */
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Creates vector from two points
     * @param p1 Point 1
     * @param p2 Points 2
     */
    public Vector(Point3d p1, Point3d p2) {
        this.x = p2.getX() - p1.getX();
        this.y = p2.getY() - p1.getY();
        this.z = p2.getZ() - p1.getZ();
    }

    /**
     * Calculates the magnitude/scalar of the vector
     * @return Scalar value of the vector
     */
    public double scalar() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    /**
     * Calculates the unit vector of the vector
     * @return The unit vector
     */
    public Vector unitVector() {
        return new Vector(this.x / this.scalar(), this.y / this.scalar(), this.z / this.scalar());
    }

    /**
     * Rotates the vector
     * @param angle angle of rotation
     * @param axis on which axis to rotate the vector
     */
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

    /**
     * calculates angle between the current vector and a given vector
     * @param vector the vector to calculate the angle between
     * @return returns the angle between the vectors in radians
     */
    public double angleBetweenVector(Vector vector){
        return Math.acos((this.dotProduct(vector))/ (this.scalar() * vector.scalar()));
    }

    /**
     * adds the values of the current vector and another vector together
     * @param vector the vector to add
     * @return the added vectors
     */
    public Vector addVector(Vector vector) {
        vector.setX(vector.getX() + x);
        vector.setY(vector.getY() + y);
        vector.setZ(vector.getZ() + z);
        return vector;
    }

    /**
     * calculates the dot product of the current vector and another vector
     * @param vector the vector to calculate the dot product with
     * @return the dot product of the current vector and another vector
     */
    public double dotProduct(Vector vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    /**
     * calculates the cross product of the current vector and another vector
     * @param vector the vector to calculate the cross product with
     * @return the cross product of the current vector and another vector
     */
    public Vector crossProduct(Vector vector) {
        return new Vector(y * vector.z - z * vector.y, z * vector.x - x * vector.z, x * vector.y - y * vector.x);
    }

    public Vector divideScalar(double value) {
        return new Vector(x / value, y / value, z / value);
    }

    /**
     * Multiples the values of the vector with a given value
     * @param value The value to multiply the vector values by
     * @return The multiplied vector
     */
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
