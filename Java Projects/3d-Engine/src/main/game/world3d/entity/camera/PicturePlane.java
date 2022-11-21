package main.game.world3d.entity.camera;

import main.game.math.Point2d;
import main.game.math.Point3d;
import main.game.math.Vector;
import main.game.window.Panel;
import main.game.world3d.Orientation;
import main.game.world3d.shapes.Rectangle;

public class PicturePlane extends Rectangle {
    private double aspectRatio;

    public PicturePlane(Point3d p1, Point3d p2, Point3d p3, Point3d p4) {
        super(p1, p2, p3, p4);
        aspectRatio = p1.getDistanceFromPoint(p2)/p2.getDistanceFromPoint(p3);
    }

    public double getAspectRatio() {
        return aspectRatio;
    }

    public Point2d project3dPointOnPanel(Point3d intersect, Orientation orientation, Panel panel) {
        Vector hypotenuse = new Vector(intersect, this.getVtx1());
        double length = hypotenuse.scalar();
        double angle;
        if (intersect.isInFrontOf(this.getVtx1(), orientation.getUp())) {
            angle = Math.PI - hypotenuse.angleBetweenVector(orientation.getRight()) * -1;
        } else {
            angle = Math.PI - hypotenuse.angleBetweenVector(orientation.getRight());

        }
        return new Point2d(Math.cos(angle) * length * (panel.getWidth() / this.getW()), Math.sin(angle) * length * (panel.getHeight() / this.getH()));
    }
}
