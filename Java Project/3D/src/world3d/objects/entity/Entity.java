package world3d.objects.entity;

import world3d.objects.Orientation;
import math.Point3d;
import world3d.objects.Object3d;

public abstract class Entity extends Object3d{

    public Entity(Point3d position, Orientation orientation) {
        super(position, orientation);
    }
}
