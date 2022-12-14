package main.world3d.entity;

import main.game.keyinput.Keys;
import main.window.Panel;
import main.math.Point3d;
import main.math.Vector;
import main.world3d.Orientation;
import main.world3d.entity.camera.Camera;

public class Player extends Entity {
    private Vector movement;
    private double movementSpeed;
    private Camera camera;

    public Player(Point3d position, Orientation orientation, Panel panel) {
        super(position, orientation);
        camera = new Camera(position, orientation,panel);
        velocity = new Vector(0, 0, 0);
        movement = new Vector(0, 0, 0);
        movementSpeed = 0;
    }

    @Override
    public void update() {
        position = position.addVector(velocity.addVector(movement));

        camera.setOrientation(orientation);
        camera.setObserver(position);
        camera.update();
    }

    public void keyEvents() {
        movement = new Vector(0, 0, 0);
        if (Keys.D.isPressed()) {
            movement = movement.addVector(orientation.getRight().multiplyScalar(movementSpeed));
        } else if (Keys.A.isPressed()) {
            movement = movement.addVector(orientation.getRight().multiplyScalar(-movementSpeed));
        }

        if (Keys.SPACE.isPressed()) {
            movement = movement.addVector(orientation.getUp().multiplyScalar(movementSpeed));
        } else if (Keys.SHIFT.isPressed()) {
            movement = movement.addVector(orientation.getUp().multiplyScalar(-movementSpeed));
        }

        if (Keys.W.isPressed()) {
            movement = movement.addVector(orientation.getForward().multiplyScalar(movementSpeed));
        } else if (Keys.S.isPressed()) {
            movement = movement.addVector(orientation.getForward().multiplyScalar(-movementSpeed));
        }

        if (Keys.CTRL.isPressed()) {
            movementSpeed = 2;
        } else {
            movementSpeed = 0.1;
        }
        if(Keys.UP.isPressed()){
            orientation.rotate(-0.01,Point3d.Y);
        }
        if(Keys.DOWN.isPressed()){
            orientation.rotate(0.01,Point3d.Y);
        }
        if(Keys.RIGHT.isPressed()){
            orientation.rotate(0.01,Point3d.Z);
        }
        if(Keys.LEFT.isPressed()){
            orientation.rotate(-0.01,Point3d.Z);
        }
        if(Keys.E.isPressed()){
            orientation.rotate(0.01,Point3d.X);
        }
        if(Keys.Q.isPressed()){
            orientation.rotate(-0.01,Point3d.X);
        }
    }



    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }
}
