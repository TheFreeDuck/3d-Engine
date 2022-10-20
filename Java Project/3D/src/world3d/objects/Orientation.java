package world3d.objects;

import math.Vector;

public class Orientation {
    private Vector forwardDirection;
    private Vector rightDirection;
    private Vector upDirection;

    public Orientation(Vector forwardDirection, Vector rightDirection) {
        this.forwardDirection = forwardDirection;
        this.rightDirection = rightDirection;
        this.upDirection = forwardDirection.crossProduct(rightDirection);
    }

    public void rotate(double angle,int axis){
        forwardDirection.rotate(angle, axis);
        rightDirection.rotate(angle, axis);
        upDirection = forwardDirection.crossProduct(rightDirection);
        forwardDirection = forwardDirection.unitVector();
        rightDirection = rightDirection.unitVector();
        upDirection = upDirection.unitVector();
    }

    public Vector getUpDirection() {
        upDirection = forwardDirection.crossProduct(rightDirection);
        return upDirection;
    }

    public Vector getForwardDirection() {
        return forwardDirection;
    }

    public Vector getRightDirection() {
        return rightDirection;
    }

}
