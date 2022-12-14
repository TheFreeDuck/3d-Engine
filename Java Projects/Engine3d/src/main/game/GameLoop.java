package main.game;

import main.game.keyinput.KeyHandler;
import main.window.Frame;
import main.window.Panel;
import main.game.world.World;

import java.awt.*;

/**
 * @author Fredrik
 */
public class GameLoop extends Thread {

    int maxFps = 60;
    int ups = 60;
    int currentFps;
    final int SECOND_IN_NANO = 1000000000;
    private boolean running = false;
    private Frame frame;
    private Panel panel;
    private KeyHandler keyHandler;
    private World world;

    public GameLoop(Frame frame, Panel panel, KeyHandler keyHandler) {
        this.panel = panel;
        this.world = new World(frame,panel);
        this.frame = frame;
        this.keyHandler = keyHandler;
    }

    /**
     * handles how the game should be updated and drawn
     * @throws RuntimeException
     */
    @Override
    public void run() throws RuntimeException {
        long lastTime = System.nanoTime();
        long lastFpsCheck = System.nanoTime();
        long currentTime;
        int interval = SECOND_IN_NANO/maxFps;
        int fps = 0;
        while (running) {
            currentTime = System.nanoTime();
            if (currentTime - lastTime >= interval) {
                update();
                panel.paintImmediately(panel.getBounds());
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                fps++;
                lastTime = currentTime;
            }

            if (System.nanoTime() - lastFpsCheck >= SECOND_IN_NANO) {
                currentFps = fps;
                fps = 0;
                lastFpsCheck = System.nanoTime();
            }

            //https://gafferongames.com/post/fix_your_timestep/
        }
    }

    public void draw(Graphics g) {
        world.draw(g);
        drawFps(g);
    }

    /**
     * write how many fps the game loop is getting
     * @param g
     */
    private void drawFps(Graphics g) {
        Font fpsFont = new Font("arial", Font.PLAIN, 15);
        g.setFont(fpsFont);
        g.setColor(Color.green);
        g.drawString("fps: " + currentFps, 3, 15);
    }

    /**
     * updates the game
     */
    public void update() {
        world.keyEvents();
        world.update();
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isRunning() {
        return running;
    }
}
