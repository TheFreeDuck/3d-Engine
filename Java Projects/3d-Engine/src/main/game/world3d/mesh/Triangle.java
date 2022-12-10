package main.game.world3d.mesh;

import java.awt.*;

public class Triangle {

    int vertex1;
    int vertex2;
    int vertex3;

    Color color;

    public Triangle(int vertex1, int vertex2, int vertex3) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
        color = Color.white;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
