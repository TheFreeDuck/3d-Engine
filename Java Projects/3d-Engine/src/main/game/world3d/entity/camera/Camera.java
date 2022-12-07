package main.game.world3d.entity.camera;

import main.game.math.Point2d;
import main.game.math.Point3d;
import main.game.math.Ray;
import main.game.math.Vertex;
import main.game.window.Panel;
import main.game.world3d.Object3d;
import main.game.world3d.Orientation;
import main.game.world3d.mesh.Edge;
import main.game.world3d.mesh.Mesh;
import main.game.world3d.shapes.Rectangle;

import java.awt.*;
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
        fov = 1;
        updatePicturePlane();
    }

    public ArrayList<ArrayList<Point2d>> projectMeshes(ArrayList<Mesh> meshes) {
        ArrayList<ArrayList<Point2d>> projectedMeshes = new ArrayList<>();
        for (Mesh mesh : meshes) {
            projectedMeshes.add(projectMesh(mesh));
        }
        return projectedMeshes;
    }

    private ArrayList<Point2d> projectMesh(Mesh mesh) {
        System.out.println(mesh.getVertices().get(0).getConnectedEdges());
        ArrayList<Point2d> projectedPoints = new ArrayList<>();
        for (int i = 0; i < mesh.getVertices().size(); i++) {
            projectedPoints.add(null);
        }
        //FIXME: unnecessary many iterations per vertex when project per edge. iterate each vertex individually and find which edge it is connected to
        for (Edge edge : mesh.getEdges()) {
            if (mesh.getVertices().get(edge.getV1()).isInFrontOf(observer, orientation.getForward())) {
                projectedPoints.set(edge.getV1(),projectVertexInFrontOfCamera(mesh.getVertices().get(edge.getV1())));
                if (mesh.getVertices().get(edge.getV2()).isInFrontOf(observer, orientation.getForward())) {
                    projectedPoints.set(edge.getV2(),projectVertexInFrontOfCamera(mesh.getVertices().get(edge.getV2())));
                } else {
                    projectedPoints.set(edge.getV2(),projectVertexBehindCamera(mesh.getVertices().get(edge.getV2()), mesh.getVertices().get(edge.getV1())));
                }
            } else if (mesh.getVertices().get(edge.getV2()).isInFrontOf(observer, orientation.getForward())) {
                projectedPoints.set(edge.getV1(),projectVertexBehindCamera(mesh.getVertices().get(edge.getV1()), mesh.getVertices().get(edge.getV2())));
            }
        }


        return projectedPoints;
    }

    private Point2d projectVertexInFrontOfCamera(Vertex vertex) {
        Ray ray = new Ray(vertex, observer);
        Point3d intersect = ray.intersectWithPlane(picturePlane);
        return picturePlane.project3dPointOnPanel(intersect, orientation, panel);
    }

    private Point2d projectVertexBehindCamera(Vertex vertex, Vertex connectedVertex) {
        Ray ray = new Ray(vertex, connectedVertex);
        Point3d intersect = ray.intersectWithPlane(picturePlane);
        return picturePlane.project3dPointOnPanel(intersect, orientation, panel);
    }

    public void drawProjectedObjects(ArrayList<Mesh> meshes, Graphics g) {
        ArrayList<ArrayList<Point2d>> projectedMeshes = projectMeshes(meshes);
        for (Mesh mesh : meshes) {
            mesh.drawEdges(g, projectedMeshes);
            mesh.drawVertices(g, projectedMeshes);
        }

    }

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
