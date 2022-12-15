package main.game.world3d.entity.camera;

import main.game.math.*;
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
        //TODO change edges arraylist to mesh and improve this method
        ArrayList<Point2d> projectedPoints = new ArrayList<>();
        for (int i = 0; i < mesh.getVertices().size(); i++) {
            Vertex vertex = mesh.getVertices().get(i);
            if (vertex.isInFrontOf(observer.addPoint(0,0,0), orientation.getForward())) {
                // Project the vertex onto the picture plane
                Point2d projectedPoint = projectVertex(vertex);
                if (projectedPoint != null) {
                    projectedPoints.add(projectedPoint);
                }
            } else {
                // Check if the vertex is connected to any edges that are in front of the camera.
                // If so, then project the point onto the picture plane using the intersection
                // of the edge and the picture plane.
                ArrayList<Integer> connectedEdges = vertex.getConnectedEdges();
                for (int edgeIndex : connectedEdges) {
                    Edge edge = mesh.getEdges().get(edgeIndex);
                    Vertex v1 = mesh.getVertices().get(edge.getVertex1());
                    Vertex v2 = mesh.getVertices().get(edge.getVertex2());
                    if (v1.isInFrontOf(observer.addPoint(0,0,0), orientation.getForward()) || v2.isInFrontOf(observer, orientation.getForward())) {
                        // Project the point onto the picture plane using the intersection
                        // of the edge and the picture plane.
                        Ray ray = new Ray(v1, v2);
                        Point3d intersect = ray.intersectWithPlane(picturePlane);
                        // Check if the intersection point is valid (i.e. not null) before projecting it
                        if (intersect != null) {
                            Point2d projectedPoint = picturePlane.project3dPointOnPanel(intersect, orientation, panel);
                            projectedPoints.add(projectedPoint);
                        }
                        break;
                    }
                }
            }
        }
        return projectedPoints;
    }






    private Point2d projectVertex(Vertex vertex) {
        Ray ray = new Ray(observer, vertex);
        Point3d intersect = ray.intersectWithPlane(picturePlane);
        if (intersect != null) {
            Vector v = new Vector(observer, intersect);
            return picturePlane.project3dPointOnPanel(intersect, orientation, panel);
        }
        return null;
    }


    public void drawProjectedObjects(ArrayList<Mesh> meshes, Graphics g) {
        ArrayList<ArrayList<Point2d>> projectedMeshes = projectMeshes(meshes);
        for (Mesh mesh : meshes) {
            mesh.drawEdges(g, projectedMeshes);
            //mesh.drawVertices(g, projectedMeshes);
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
