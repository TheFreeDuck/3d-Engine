package world3d.objects;

import math.Point3d;
import math.Vector;

public abstract class Object3d {
    protected Point3d position;
    protected Orientation orientation;
    protected Vector velocity;

    protected Object3d(Point3d position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
        velocity = new Vector(0,0,0);
    }

    protected abstract void update();
}
