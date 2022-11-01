package main.game.world3d;

import main.game.math.Point3d;
import main.game.math.Vector;
import main.game.math.Vertex;

import java.util.ArrayList;

public abstract class Object3d {
    protected Point3d position;
    protected Orientation orientation;
    protected Vector velocity;

    protected ArrayList<Vertex> vertices;

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
