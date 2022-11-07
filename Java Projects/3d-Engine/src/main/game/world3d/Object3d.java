package main.game.world3d;

import main.game.math.Point3d;
import main.game.math.Vector;
import main.game.world3d.mesh.Mesh;

public abstract class Object3d {

    protected Mesh mesh;
    protected Point3d position;
    protected Orientation orientation;
    protected Vector velocity;

    protected Object3d(Point3d position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
        velocity = new Vector(0,0,0);
    }

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

    protected abstract void update();
}
