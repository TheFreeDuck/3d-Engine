package main.game.world3d.entity;

import main.game.math.*;
import main.game.window.Panel;
import main.game.world3d.Object3d;
import main.game.world3d.Orientation;
import main.game.world3d.mesh.QuadMesh;
import main.game.world3d.shapes.Rectangle;

import java.util.ArrayList;

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

    public ArrayList<QuadMesh> projectQuadMeshes(ArrayList<QuadMesh> meshes) {
        for (QuadMesh mesh : meshes) {
            projectMesh(mesh);
        }
        return meshes;
    }

    private void projectMesh(QuadMesh mesh) {
        ArrayList<Integer> verticesBehind = new ArrayList<>();
        for (int i = 0; i < mesh.getVertices().size(); i++) {
            if (mesh.getVertices().get(i).isInFrontOf(picturePlane.getVtx1(), orientation.getForward())) {
                projectVertexInFrontOfCamera(mesh.getVertices().get(i));
            } else {
                verticesBehind.add(i);
            }
        }
        for (int i : verticesBehind) {
            projectVertexBehindCamera(mesh.getVertices().get(i), mesh.getVertices().get(i).);
        }
    }

    private Vertex projectVertexInFrontOfCamera(Vertex vertex) {
        Ray ray = new Ray(vertex, observer);
        Point3d intersect = ray.intersectWithPlane(picturePlane);
        vertex.setP2d(picturePlane.project2dPointOnPanel(intersect, orientation,panel));
        return vertex;
    }

    private Vertex projectVertexBehindCamera(Vertex vertex, Vertex connectedVertex) {
        Ray ray = new Ray(vertex, connectedVertex);
        Point3d intersect = ray.intersectWithPlane(picturePlane);
        vertex.setP2d(picturePlane.project2dPointOnPanel(intersect, orientation,panel));
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
