package world3d.entity;

import world3d.Object3d;
import world3d.Orientation;
import math.Point3d;

public abstract class Entity extends Object3d {

    public Entity(Point3d position, Orientation orientation) {
        super(position, orientation);
    }
}
