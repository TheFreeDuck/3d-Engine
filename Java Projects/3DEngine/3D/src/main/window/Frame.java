package main.window;

import main.Main;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Objects;

public class Frame extends JFrame {
    private Panel panel;
    private boolean fullscreen;

    public Frame() {
        this.setTitle("3D Engine");
        try {
            Image icon = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("icon.png")));
            this.setIconImage(icon);
        } catch (Exception ignored) {}

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

    public void setFullscreen(Boolean fullscreen){
        if(!this.fullscreen == fullscreen){
            this.fullscreen = fullscreen;
            dispose();
            setUndecorated(fullscreen);
            if(fullscreen){
                setBounds(0,0,Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
            }else{
                pack();
                setLocationRelativeTo(null);
            }

            setVisible(true);
        }

    }

    public Panel getPanel() {
        return panel;
    }

    public boolean isFullscreen() {
        return fullscreen;
    }
}
