package main.game.world3d;

import main.game.math.Vector;

public class Orientation {
    private Vector forward;
    private Vector right;
    private Vector up;

    public Orientation(Vector forward, Vector right) {
        this.forward = forward;
        this.right = right;
        this.up = forward.crossProduct(right);
    }

    public void rotate(double angle,int axis){
        forward.rotate(angle, axis);
        right.rotate(angle, axis);
        up = forward.crossProduct(up);

        forward = forward.unitVector();
        right = right.unitVector();
        up = up.unitVector();
    }

    public Vector getUp() {
        up = forward.crossProduct(right);
        return up;
    }

    public Vector getForward() {
        return forward;
    }

    public Vector getRight() {
        return right;
    }

}
