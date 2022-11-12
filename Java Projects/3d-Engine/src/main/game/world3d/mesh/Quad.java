package main.game.world3d.mesh;

import java.awt.*;
import java.util.ArrayList;

public class Quad {

    int edge1;
    int edge2;

    Color color;

    public Quad(int edge1, int edge2) {
        this.edge1 = edge1;
        this.edge2 = edge2;
        color = Color.white;
    }
}
