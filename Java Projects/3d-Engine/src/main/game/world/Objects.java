package main.game.world;

import main.mesh.Mesh;
import main.world3d.Object3d;

import java.util.ArrayList;

/**
 * @author Fredrik
 */
public class Objects extends ArrayList<Object3d> {

    public ArrayList<Mesh> meshes() {
        ArrayList<Mesh> meshes = new ArrayList<>();
        for (Object3d object : this) {
            meshes.add(object.getMesh());
        }
        return meshes;
    }

    public void update() {
        for (Object3d object : this) {
            object.update();
        }
    }


}
