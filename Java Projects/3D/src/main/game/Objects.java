package main.game;

import java.awt.Graphics;
import java.util.ArrayList;
import world3d.shapes.Cuboid;

/**
 *
 * @author Fredrik
 */
public class Objects {
    private ArrayList<Cuboid> cuboids;

    public Objects() {
        cuboids = new ArrayList<>();
    }

    public ArrayList<Cuboid> getCuboids() {
        return cuboids;
    }

    public void setCuboids(ArrayList<Cuboid> cuboids) {
        this.cuboids = cuboids;
    }
    
    public void addCuboid(Cuboid cuboid){
        cuboids.add(cuboid);
    }
    
    public void draw(Graphics g){
        for (Cuboid cuboid : cuboids) {
            cuboid.draw(g);
        }
    }
    
    public void update(){
        for(Cuboid cuboid : cuboids){
            cuboid.update();
        }
    }

    
    
    
    
}
