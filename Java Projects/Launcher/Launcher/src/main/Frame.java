package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Frame extends JFrame {
    private JPanel panel;
    private JButton downloadAndRunButton;
    private JTextField a3DEngineLauncherTextField;

    public Frame(){
        setContentPane(panel);
        setTitle("Launcher");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        downloadAndRunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    URL url = new URL("https://fabulous-puffpuff-8f0c55.netlify.app/resources/jar/3d-Engine.jar");
                    ReadableByteChannel rbc = Channels.newChannel(url.openStream());
                    FileOutputStream fos = new FileOutputStream(System.getProperty("user.home") + "/Downloads/downloaded.jar");
                    fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                    Desktop.getDesktop().open(new File(System.getProperty("user.home") + "/Downloads/downloaded.jar"));
                }catch(Exception er){
                    JOptionPane.showMessageDialog(null, "Something went wrong\n"+er,"ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
