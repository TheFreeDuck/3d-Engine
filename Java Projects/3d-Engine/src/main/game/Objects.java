package main.game;

import java.util.ArrayList;

import main.game.world3d.Object3d;
import main.game.world3d.mesh.Mesh;

/**
 * @author Fredrik
 */
public class Objects extends ArrayList<Object3d> {

    public ArrayList<Mesh> meshes() {
        ArrayList<Mesh> meshes = new ArrayList<>();
        for (Object3d object : this) {
            meshes.add(object.getQuadMesh());
        }
        return meshes;
    }

    public void update() {
        for (Object3d object : this) {
            object.update();
        }
    }


}
