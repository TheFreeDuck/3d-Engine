package main.game.window;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Frame extends JFrame {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.startGame();
    }

    private Panel panel;
    private boolean fullscreen;

    public Frame() {
        this.setTitle("3D Engine");
        Image icon;
        try {
            icon = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("icon.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.setIconImage(icon);

        this.setResizable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new Panel(this);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        setFullscreen(false);
    }

    public void startGame() {
        panel.startGameLoop();
    }

    public void setFullscreen(Boolean fullscreen) {
        if (!this.fullscreen == fullscreen) {
            this.fullscreen = fullscreen;
            dispose();
            setUndecorated(fullscreen);
            if (fullscreen) {
                setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
                setCursor(getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "null"));
            } else {
                pack();
                setLocationRelativeTo(null);
                setCursor(Cursor.getDefaultCursor());
            }
            setVisible(true);
            setAlwaysOnTop(true);
            setAlwaysOnTop(false);

        }

    }

    public Panel getPanel() {
        return panel;
    }

    public boolean isFullscreen() {
        return fullscreen;
    }
}
