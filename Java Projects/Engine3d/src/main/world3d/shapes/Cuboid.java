package main.world3d.shapes;

import main.math.Point3d;
import main.math.Vector;
import main.world3d.Object3d;
import main.world3d.Orientation;
import main.mesh.standardmeshes.CuboidMesh;

/**
 * @author Fredrik
 */
public class Cuboid extends Object3d {

    private double w;
    private double h;
    private double l;

    public Cuboid(Point3d p1, double w, double h, double l) {
        super(p1,new Orientation(new Vector(1,0,0),new Vector(0,1,0)));
        mesh = new CuboidMesh(h,w,l,p1);
        this.w = w;
        this.h = h;
        this.l = l;
    }

    public void update() {

    }

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }

    public double getL() {
        return l;
    }

}
