package main.game;

import world3d.objects.Orientation;
import world3d.objects.entity.Player;
import main.window.Panel;
import math.Point3d;
import math.Vector;
import math.Vertex;
import world3d.objects.shapes.Cuboid;

import java.awt.*;

/**
 * @author Fredrik
 */
public class World {

    public final static double GRAVITY = 0.001;
    private final Player player;
    private final Objects objects;
    main.window.Panel panel;



    public World(Panel panel) {
        this.panel = panel;
        player = new Player(new Point3d(-10, 0, 0),new Orientation( new Vector(1, 0, 0), new Vector(0, 1, 0)),panel);
        objects = new Objects();
        objects.addCuboid((new Cuboid(new Point3d(2, 0, 0), 100, 0, 100)));
        objects.addCuboid(new Cuboid(new Vertex(2, 0, 0), 1, 1, 1));
        for (int i = 0; i < 100; i++) {
            objects.addCuboid(new Cuboid(new Point3d(Math.max(2,Math.random()*20),Math.random()*20,Math.random()*20),1,1,1));
        }
        for (int i = 0; i < 100; i++) {
            objects.addCuboid(new Cuboid(new Point3d(Math.max(2,Math.random()*20)+50,Math.random()*20+50,Math.random()*20),1,1,Math.random()*5));
        }
        for (int i = 2; i < 102; i++) {
            objects.addCuboid(new Cuboid(new Point3d(i,-10,0),10,0,1));
        }
    }

    public void update() {
        objects.update();
        player.update();
    }

    public void draw(Graphics g) {
        player.getCamera().drawProjectedObjects(objects, g);
    }

    public void keyEvents(){
        player.keyEvents();
    }

}
