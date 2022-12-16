package main.game.window;

import main.game.GameLoop;
import main.game.keyinput.KeyHandler;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author fredrik.cewersbredbe
 */
public class Panel extends JPanel {

    private final int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().height/1.3);
    private final double aspectRatio = 2;
    private final int width = (int) (height * aspectRatio);
    private GameLoop gameLoop;
    private KeyHandler keyHandler;
    private Frame frame;

    public Panel(Frame frame) {
        this.frame = frame;
        this.keyHandler = new KeyHandler();
        gameLoop = new GameLoop(frame,this, keyHandler);
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(width, height));
        this.addKeyListener(keyHandler);
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

    public GameLoop getGameLoop() {
        return gameLoop;
    }
}
