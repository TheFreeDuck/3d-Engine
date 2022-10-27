package main.game.world3d.entity;

import main.game.world3d.Object3d;
import main.game.world3d.Orientation;
import main.game.math.Point3d;

public abstract class Entity extends Object3d {

    public Entity(Point3d position, Orientation orientation) {
        super(position, orientation);
    }
}
