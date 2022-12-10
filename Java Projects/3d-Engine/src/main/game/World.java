package main.game;

import main.game.keyinput.Keys;
import main.game.math.Point3d;
import main.game.math.Vector;
import main.game.math.Vertex;
import main.game.window.Frame;
import main.game.window.Panel;
import main.game.world3d.Orientation;
import main.game.world3d.entity.Player;
import main.game.world3d.shapes.Cuboid;

import java.awt.*;

/**
 * @author Fredrik
 */
public class World {

    public final static double GRAVITY = 0.001;
    private Player player;
    private Objects objects;
    private Frame frame;
    private Panel panel;


    public World(Frame frame, Panel panel) {
        this.panel = panel;
        this.frame = frame;
        player = new Player(new Point3d(0, 0, 0), new Orientation(new Vector(1, 0, 0), new Vector(0, 1, 0)), panel);
        objects = new Objects();

        objects.add(new Cuboid(new Vertex(2, 0, 0), 1, 1, 1));

        //objects.add((new Cuboid(new Point3d(2, 0, 0), 100, 0, 100)));
        /*objects.add(new Cuboid(new Vertex(2, 0, 0), 1, 1, 1));
        for (int i = 0; i < 100; i++) {
            objects.add(new Cuboid(new Point3d(Math.max(2, Math.random() * 20), Math.random() * 20, Math.random() * 20), 1, 1, 1));
        }
        for (int i = 0; i < 100; i++) {
            objects.add(new Cuboid(new Point3d(Math.max(2, Math.random() * 20) + 50, Math.random() * 20 + 50, Math.random() * 20), 1, 1, Math.random() * 5));
        }
        for (int i = 2; i < 102; i++) {
            objects.add(new Cuboid(new Point3d(i, -10, 0), 10, 0, 1));
        }*/

    }

    public void update() {
        objects.update();
        player.update();

    }

    public void draw(Graphics g) {
        player.getCamera().drawProjectedObjects(objects.meshes(), g);
    }

    public void keyEvents() {
        player.keyEvents();
        if (Keys.R.isPressed()) {
            player.setPosition(new Point3d(0, 0, 0));
            player.setOrientation(new Orientation(new Vector(1, 0, 0), new Vector(0, 1, 0)));
        }
        if (Keys.F.isPressedOneTick()) {
            Keys.F.setPressedOneTick(false);
            frame.setFullscreen(!frame.isFullscreen());
        }
        if (Keys.ESC.isPressed()) {
            if (frame.isFullscreen()) {
                frame.setFullscreen(false);
            }
        }
    }

}
