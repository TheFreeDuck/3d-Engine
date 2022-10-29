package main.game.world3d.shapes;

import main.game.math.Vertex;

import java.awt.*;

public class Line {
    Vertex vtx1;
    Vertex vtx2;

    public Line(Vertex vtx1, Vertex vtx2) {
        this.vtx1 = vtx1;
        this.vtx2 = vtx2;
    }

    public void draw(Graphics g){
        g.drawLine((int) vtx1.getP2d().getX(), (int) vtx1.getP2d().getY(), (int) vtx2.getP2d().getX(), (int) vtx2.getP2d().getY());
    }
}
