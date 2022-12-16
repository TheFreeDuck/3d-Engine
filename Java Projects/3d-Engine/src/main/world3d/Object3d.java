package main.world3d;

import main.math.Point3d;
import main.math.Vector;
import main.mesh.Mesh;

public abstract class Object3d {

    protected Mesh mesh;
    protected Point3d position;
    protected Orientation orientation;
    protected Vector velocity;

    protected Object3d(Point3d position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
        velocity = new Vector(0, 0, 0);
    }

    public abstract void update();

    public Point3d getPosition() {
        return position;
    }

    public void setPosition(Point3d position) {
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Mesh getMesh() {
        return mesh;
    }

    public Vector getVelocity() {
        return velocity;
    }
}
