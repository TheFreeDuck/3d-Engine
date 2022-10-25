package main.window;

import main.game.GameLoop;
import main.keyinput.KeyInput;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.*;

/**
 *
 * @author fredrik.cewersbredbe
 */
public class Panel extends JPanel {

    private final int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().height/1.3);
    private final double aspectRatio = 2 / 1;
    private final int width = (int) (height * aspectRatio);
    private GameLoop gameLoop;
    private KeyInput keyInput;
    private Frame frame;

    public Panel(Frame frame) {
        this.frame = frame;
        this.keyInput = new KeyInput();
        gameLoop = new GameLoop(frame,this, keyInput);
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(width, height));
        this.addKeyListener(keyInput);
        this.setFocusable(true);
    }

    public void startGameLoop() {
        gameLoop.setRunning(true);
        gameLoop.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        gameLoop.draw(g);
    }

    public double getAspectRatio(){
        return (double)getWidth()/getHeight();
    }

}
