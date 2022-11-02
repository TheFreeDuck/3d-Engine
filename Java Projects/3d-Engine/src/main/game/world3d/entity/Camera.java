package main.game.world3d.entity;

import main.game.Objects;
import main.game.math.*;
import main.game.window.Panel;
import main.game.world3d.Object3d;
import main.game.world3d.Orientation;
import main.game.world3d.shapes.Cuboid;
import main.game.world3d.shapes.Rectangle;

import java.awt.*;

/**
 * @author Fredrik
 */
public class Camera extends Object3d {

    private Point3d observer;
    private PicturePlane picturePlane;
    private double fov;
    private Panel panel;

    public Camera(Point3d observer, Orientation orientation, Panel panel) {
        super(observer, orientation);
        this.panel = panel;
        this.observer = observer;
        this.orientation = orientation;
        this.fov = 1;
        updatePicturePlane();
    }

    public void drawProjectedObjects(Objects objects, Graphics g) {
        objects = projectObjects(objects);
        objects.draw(g);
    }

    public Objects projectObjects(Objects objects) {
        for (Cuboid cuboid : objects.getCuboids()) {
            for (int i = 0; i < cuboid.getVertices().size(); i++) {
                cuboid.changeVertex(projectVertex(cuboid.getVertices().get(i)), i);
            }
        }
        return objects;

    }

    /**
     * projects a vertex on the picture plane
     *
     * @param vertex The vertex to be projected
     * @return The projected vertex
     */

    private Vertex projectVertex(Vertex vertex) {
        if (vertex.isInFrontOf(picturePlane.getVtx1(), orientation.getForward())) {
            vertex.setInFrame(true);
            Ray ray = new Ray(vertex, observer);
            double a = picturePlane.getVtx1().getY() * (picturePlane.getVtx2().getZ() - picturePlane.getVtx3().getZ()) + picturePlane.getVtx2().getY() * (picturePlane.getVtx3().getZ() - picturePlane.getVtx1().getZ()) + picturePlane.getVtx3().getY() * (picturePlane.getVtx1().getZ() - picturePlane.getVtx2().getZ());
            double b = picturePlane.getVtx1().getZ() * (picturePlane.getVtx2().getX() - picturePlane.getVtx3().getX()) + picturePlane.getVtx2().getZ() * (picturePlane.getVtx3().getX() - picturePlane.getVtx1().getX()) + picturePlane.getVtx3().getZ() * (picturePlane.getVtx1().getX() - picturePlane.getVtx2().getX());
            double c = picturePlane.getVtx1().getX() * (picturePlane.getVtx2().getY() - picturePlane.getVtx3().getY()) + picturePlane.getVtx2().getX() * (picturePlane.getVtx3().getY() - picturePlane.getVtx1().getY()) + picturePlane.getVtx3().getX() * (picturePlane.getVtx1().getY() - picturePlane.getVtx2().getY());
            double d = -picturePlane.getVtx1().getX() * (picturePlane.getVtx2().getY() * picturePlane.getVtx3().getZ() - picturePlane.getVtx3().getY() * picturePlane.getVtx2().getZ()) - picturePlane.getVtx2().getX() * (picturePlane.getVtx3().getY() * picturePlane.getVtx1().getZ() - picturePlane.getVtx1().getY() * picturePlane.getVtx3().getZ()) - picturePlane.getVtx3().getX() * (picturePlane.getVtx1().getY() * picturePlane.getVtx2().getZ() - picturePlane.getVtx2().getY() * picturePlane.getVtx1().getZ());
            double t = -(a * ray.getP1().getX() + b * ray.getP1().getY() + c * ray.getP1().getX() + d) / (a * ray.getVector().getX() + b * ray.getVector().getY() + c * ray.getVector().getZ());
            if (t > 0) {
                vertex.setInFrame(true);

                Point3d intersect = new Point3d(ray.getP1().getX() + ray.getVector().getX() * t, ray.getP1().getY() + ray.getVector().getY() * t, ray.getP1().getZ() + ray.getVector().getZ() * t);
                Vector hypotenuse = new Vector(intersect, picturePlane.getVtx1());
                double length = hypotenuse.scalar();
                double angle;
                if (intersect.isInFrontOf(picturePlane.getVtx1(), orientation.getUp())) {
                    angle = Math.PI - hypotenuse.angleBetweenVector(orientation.getRight()) * -1;
                    vertex.setP2d(new Point2d(Math.cos(angle) * length * (panel.getWidth() / picturePlane.getW()), Math.sin(angle) * length * (panel.getHeight() / picturePlane.getH())));
                } else {
                    angle = Math.PI - hypotenuse.angleBetweenVector(orientation.getRight());

                }
                vertex.setP2d(new Point2d(Math.cos(angle) * length * (panel.getWidth() / picturePlane.getW()), Math.sin(angle) * length * (panel.getHeight() / picturePlane.getH())));
            } else if (t > 0) {
                vertex.setInFrame(false);
            }
        } else {
            vertex.setInFrame(false);
        }
        return vertex;

    }

    @Override
    public void update() {
        updatePicturePlane();
    }

    private void updatePicturePlane() {
        picturePlane = new PicturePlane(observer.addDistanceAlongVector(orientation.getForward(), 1).addDistanceAlongVector(orientation.getRight(), -panel.getAspectRatio() * fov / 2).addDistanceAlongVector(orientation.getUp(), fov / 2), observer.addDistanceAlongVector(orientation.getForward(), 1).addDistanceAlongVector(orientation.getRight(), panel.getAspectRatio() * fov / 2).addDistanceAlongVector(orientation.getUp(), fov / 2), observer.addDistanceAlongVector(orientation.getForward(), 1).addDistanceAlongVector(orientation.getRight(), panel.getAspectRatio() * fov / 2).addDistanceAlongVector(orientation.getUp(), -fov / 2), observer.addDistanceAlongVector(orientation.getForward(), 1).addDistanceAlongVector(orientation.getRight(), -panel.getAspectRatio() * fov / 2).addDistanceAlongVector(orientation.getUp(), -fov / 2));
    }

    public Point3d getObserver() {
        return observer;
    }

    public void setObserver(Point3d observer) {
        this.observer = observer;
    }

    public Rectangle getPicturePlane() {
        return picturePlane;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
