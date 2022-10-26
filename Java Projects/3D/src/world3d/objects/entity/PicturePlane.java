package world3d.objects.entity;

import math.Point3d;
import world3d.objects.shapes.Rectangle;

public class PicturePlane extends Rectangle {
    private double aspectRatio;

    public PicturePlane(Point3d p1, Point3d p2, Point3d p3, Point3d p4) {
        super(p1, p2, p3, p4);
        aspectRatio = p1.getDistanceFromPoint(p2)/p2.getDistanceFromPoint(p3);
    }

    public double getAspectRatio() {
        return aspectRatio;
    }
}
