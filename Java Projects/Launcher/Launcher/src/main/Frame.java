package main;

import javax.swing.*;

public class Frame extends JFrame {
    private JPanel panel;
    private JButton button1;

    public Frame(){
        setContentPane(panel);
        setTitle("Launcher");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
