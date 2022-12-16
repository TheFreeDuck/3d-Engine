package main.world3d.entity;

import main.world3d.Object3d;
import main.world3d.Orientation;
import main.math.Point3d;

public abstract class Entity extends Object3d {

    public Entity(Point3d position, Orientation orientation) {
        super(position, orientation);
    }
}
