package main;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLOutput;
import java.util.Arrays;
import main.window.Frame;

public class UpdateCheck {

    public UpdateCheck(){
        try {
            String localHash = getHash(System.getProperty("user.home") + "/Documents/GitHub/3d-Engine/resources/jar/3d-Engine.jar");
            downloadFile("https://fabulous-puffpuff-8f0c55.netlify.app/resources/jar/3d-Engine.jar",System.getProperty("user.home") + "/Downloads");
            String serverHash = System.getProperty("user.home") + "/Downloads";
            if(localHash==serverHash){
                Frame frame = new Frame();
                frame.startGame();
            }else{
                JOptionPane.showMessageDialog(null,"old version");
            }
        }catch(Exception er){
            JOptionPane.showMessageDialog(null, "Something went wrong\n"+er,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getHash(String path){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(Files.readAllBytes(Paths.get(path)));
            byte[] digest = md.digest();
            return (Arrays.toString(digest));
        }catch(Exception er) {
            JOptionPane.showMessageDialog(null, "Something went wrong\n" + er, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    private void downloadFile(String src,String dest){
        try {
            URL url = new URL(src);
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(dest);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            Desktop.getDesktop().open(new File(dest));
        }catch(Exception er){
            JOptionPane.showMessageDialog(null, "Something went wrong\n"+er,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
