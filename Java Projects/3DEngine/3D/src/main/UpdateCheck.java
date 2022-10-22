package main;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Arrays;
import main.window.Frame;

public class UpdateCheck {

    public UpdateCheck(){
        try {
            String localHash = getHash(new java.io.File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getPath());
            File temp = new File(System.getProperty("user.home") + "/Downloads/temp.jar");
            downloadFile("https://fabulous-puffpuff-8f0c55.netlify.app/resources/jar/3d-Engine.jar",temp.getPath());
            String serverHash = getHash(temp.getPath().toString());


            if(localHash.equals(serverHash)){
                Frame frame = new Frame();
                frame.startGame();
            }else{
                int choice = JOptionPane.showConfirmDialog(null,"Update available!\nWould you like to update?","Update Available!",JOptionPane.INFORMATION_MESSAGE);
                if(choice!=0){
                    Frame frame = new Frame();
                    frame.startGame();
                }else{
                    downloadFile("https://fabulous-puffpuff-8f0c55.netlify.app/resources/jar/3d-Engine.jar",System.getProperty("user.dir")+"/"+new java.io.File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getName());
                    Desktop.getDesktop().open(new File(System.getProperty("user.dir")+"/"+new java.io.File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath())));
                }
            }
            java.nio.file.Files.delete(temp.toPath());

        }catch(Exception err){
            JOptionPane.showMessageDialog(null, "error in\n"+err,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getHash(String path){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(Files.readAllBytes(Paths.get(path)));
            byte[] digest = md.digest();
            return (Arrays.toString(digest));
        }catch(Exception er) {
            JOptionPane.showMessageDialog(null, "Error getting hash: " + path + "\n" + er, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    private void downloadFile(String src,String dest){
        try {
            URL url = new URL(src);
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(dest);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }catch(Exception er){
            JOptionPane.showMessageDialog(null, "Error downloading file:" +src + "\n"+er,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
