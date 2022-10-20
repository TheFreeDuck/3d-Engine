package main.window;

import main.Main;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Frame extends JFrame {
    private Panel panel;

    public Frame() {

        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(((Main.class.getClassLoader().getResourceAsStream("takagi.wav"))));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e);
        }


        this.setTitle("3D Engine");
        try {
            Image icon = ImageIO.read(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("icon.png")));
            this.setIconImage(icon);
        } catch (Exception ignored) {}

        this.setResizable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new Panel();
        this.add(panel);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void startGame() {
        panel.startGameLoop();
    }
}
