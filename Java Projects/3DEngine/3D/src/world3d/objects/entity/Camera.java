package world3d.objects.entity;

import main.game.Objects;
import main.window.Panel;
import math.*;
import world3d.objects.Object3d;
import world3d.objects.Orientation;
import world3d.objects.shapes.Cuboid;
import world3d.objects.shapes.Rectangle;

import java.awt.*;

/**
 * @author Fredrik
 */
public class Camera extends Object3d {

    private Point3d observer;
    private Rectangle picturePlane;
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
            for (int i = 0; i < cuboid.getVertecies().size(); i++) {
                cuboid.changeVertex(projectVertex(cuboid.getVertecies().get(i)), i);
            }
        }
        return objects;

    }

    private Vertex projectVertex(Vertex vertex) {
        //if (orientation.getForwardDirection().dotProduct(new Ray(observer, vertex).getVector()) > 0) {
        Ray ray = new Ray(vertex, observer);
        double a = picturePlane.getVtx1().getY() * (picturePlane.getVtx2().getZ() - picturePlane.getVtx3().getZ()) + picturePlane.getVtx2().getY() * (picturePlane.getVtx3().getZ() - picturePlane.getVtx1().getZ()) + picturePlane.getVtx3().getY() * (picturePlane.getVtx1().getZ() - picturePlane.getVtx2().getZ());
        double b = picturePlane.getVtx1().getZ() * (picturePlane.getVtx2().getX() - picturePlane.getVtx3().getX()) + picturePlane.getVtx2().getZ() * (picturePlane.getVtx3().getX() - picturePlane.getVtx1().getX()) + picturePlane.getVtx3().getZ() * (picturePlane.getVtx1().getX() - picturePlane.getVtx2().getX());
        double c = picturePlane.getVtx1().getX() * (picturePlane.getVtx2().getY() - picturePlane.getVtx3().getY()) + picturePlane.getVtx2().getX() * (picturePlane.getVtx3().getY() - picturePlane.getVtx1().getY()) + picturePlane.getVtx3().getX() * (picturePlane.getVtx1().getY() - picturePlane.getVtx2().getY());
        double d = -picturePlane.getVtx1().getX() * (picturePlane.getVtx2().getY() * picturePlane.getVtx3().getZ() - picturePlane.getVtx3().getY() * picturePlane.getVtx2().getZ()) - picturePlane.getVtx2().getX() * (picturePlane.getVtx3().getY() * picturePlane.getVtx1().getZ() - picturePlane.getVtx1().getY() * picturePlane.getVtx3().getZ()) - picturePlane.getVtx3().getX() * (picturePlane.getVtx1().getY() * picturePlane.getVtx2().getZ() - picturePlane.getVtx2().getY() * picturePlane.getVtx1().getZ());
        double t = -(a * ray.getP1().getX() + b * ray.getP1().getY() + c * ray.getP1().getX() + d) / (a * ray.getVector().getX() + b * ray.getVector().getY() + c * ray.getVector().getZ());
        //if T NEGATIVE FIX
        //if (t < 0) {
        //    vertex.setInFrame(false);
        //} else if (t > 0) {
        //    vertex.setInFrame(true);
        //}
        Point3d intersect = new Point3d(ray.getP1().getX() + ray.getVector().getX() * t, ray.getP1().getY() + ray.getVector().getY() * t, ray.getP1().getZ() + ray.getVector().getZ() * t);
        //Point3d pointOnPlane = new Point3d(Math.abs(picturePlane.getVtx1().getX() - intersect.getX()), Math.abs(picturePlane.getVtx1().getY() - intersect.getY()), Math.abs(picturePlane.getVtx1().getZ() - intersect.getZ()));
        Vector distance = new Vector(intersect, picturePlane.getVtx1());
        //System.out.println(distance.scalar());
        double length = distance.scalar();
        double angle = distance.calculateAngleBetweenVector(orientation.getRightDirection());
        vertex.setP2d(new Point2d(Math.sin(angle) * length * panel.getWidth()/fov, Math.cos(angle) * length * panel.getHeight()/fov));
        System.out.println(vertex.getP2d());
        System.out.println(panel.getSize());
        //vertex.setP2d(new Point2d((intersect.getY() - picturePlane.getVtx1().getY()) * (panel.getWidth() / picturePlane.getW()), (picturePlane.getVtx1().getZ() - intersect.getZ()) * (panel.getHeight() / picturePlane.getH())));
        //}
        return vertex;

    }

    @Override
    public void update() {
        updatePicturePlane();
        //System.out.println(new Ray(observer, picturePlane.getVtx1()).length());
    }

    private void updatePicturePlane() {
        picturePlane = new Rectangle(observer.addDistanceAlongVector(orientation.getForwardDirection(), 1).addDistanceAlongVector(orientation.getRightDirection(), -panel.getAspectRatio() * fov / 2).addDistanceAlongVector(orientation.getUpDirection(), fov / 2),
                observer.addDistanceAlongVector(orientation.getForwardDirection(), 1).addDistanceAlongVector(orientation.getRightDirection(), panel.getAspectRatio() * fov / 2).addDistanceAlongVector(orientation.getUpDirection(), fov / 2),
                observer.addDistanceAlongVector(orientation.getForwardDirection(), 1).addDistanceAlongVector(orientation.getRightDirection(), panel.getAspectRatio() * fov / 2).addDistanceAlongVector(orientation.getUpDirection(), -fov / 2),
                observer.addDistanceAlongVector(orientation.getForwardDirection(), 1).addDistanceAlongVector(orientation.getRightDirection(), -panel.getAspectRatio() * fov / 2).addDistanceAlongVector(orientation.getUpDirection(), -fov / 2));
    }

    public Point3d getObserver() {
        return observer;
    }

    public void setObserver(Point3d observer) {
        this.observer = observer;
    }

    public world3d.objects.shapes.Rectangle getPicturePlane() {
        return picturePlane;
    }

    public void setPicturePlane(Rectangle picturePlane) {
        this.picturePlane = picturePlane;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
