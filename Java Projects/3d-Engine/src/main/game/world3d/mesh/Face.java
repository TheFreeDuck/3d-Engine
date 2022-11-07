package main.game.world3d.mesh;

import java.awt.*;

public class Face {
    int V1;
    int V2;
    int V3;

    Color color;

    public Face(int v1, int v2, int v3) {
        V1 = v1;
        V2 = v2;
        V3 = v3;
        color = Color.white;
    }
}
