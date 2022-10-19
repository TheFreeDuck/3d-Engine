package main.game;

import main.keyinput.KeyInput;
import main.window.Panel;

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
    private main.window.Panel panel;
    private KeyInput keyInput;
    private World world;

    public GameLoop(Panel panel, KeyInput keyInput) {
        this.world = new World(panel);
        this.panel = panel;
        this.keyInput = keyInput;
    }

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

    private void drawFps(Graphics g) {
        Font fpsFont = new Font("arial", Font.PLAIN, 20);
        g.setFont(fpsFont);
        g.setColor(Color.green);
        g.drawString("fps: " + currentFps, 3, 20);
    }

    public void update() {
        world.keyEvents();
        world.update();
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

}
