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
        this.fov = 1;
        updatePicturePlane();
    }

    public ArrayList<Mesh> projectMeshes(ArrayList<Mesh> meshes) {
        for (Mesh mesh : meshes) {
            projectMesh(mesh);
        }
        return meshes;
    }

    private void projectMesh(Mesh mesh) {
        for (Edge edge : mesh.getEdges()) {
            if (mesh.getVertices().get(edge.getV1()).isInFrontOf(observer, orientation.getForward())) {
                projectVertexInFrontOfCamera(mesh.getVertices().get(edge.getV1()));
                if (mesh.getVertices().get(edge.getV2()).isInFrontOf(observer, orientation.getForward())) {
                    projectVertexInFrontOfCamera(mesh.getVertices().get(edge.getV2()));
                } else {
                    projectVertexBehindCamera(mesh.getVertices().get(edge.getV2()), mesh.getVertices().get(edge.getV1()));
                }
            } else if(mesh.getVertices().get(edge.getV2()).isInFrontOf(observer, orientation.getForward())){
                projectVertexBehindCamera(mesh.getVertices().get(edge.getV1()), mesh.getVertices().get(edge.getV2()));
            }else{
                mesh.getVertices().get(edge.getV1()).setInFrame(false);
                mesh.getVertices().get(edge.getV2()).setInFrame(false);
            }
        }
    }

    private Vertex projectVertexInFrontOfCamera(Vertex vertex) {
        Ray ray = new Ray(vertex, observer);
        Point3d intersect = ray.intersectWithPlane(picturePlane);
        if(intersect != null){
            vertex.setP2d(picturePlane.project3dPointOnPanel(intersect, orientation, panel));
        }
        return vertex;
    }

    private Vertex projectVertexBehindCamera(Vertex vertex, Vertex connectedVertex) {
        Ray ray = new Ray(vertex, connectedVertex);
        Point3d intersect = ray.intersectWithPlane(picturePlane);
        vertex.setP2d(picturePlane.project3dPointOnPanel(intersect, orientation, panel));
        return vertex;
    }

    public void drawProjectedObjects(ArrayList<Mesh> meshes, Graphics g) {
        for (Mesh mesh : meshes) {
            //mesh.drawVertices(g);
            mesh.drawEdges(g);
        }

    }

    public void update(){

    }
    public void update(ArrayList<Mesh> meshes) {
        projectMeshes(meshes);
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
