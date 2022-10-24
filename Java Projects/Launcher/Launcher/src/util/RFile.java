package util;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class RFile extends File {
    public RFile(String pathname) {
        super(pathname);
    }

    public void download(String dest){
        try {
            URL url = new URL(getName());
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(dest);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            Desktop.getDesktop().open(new File(dest));
        }catch(Exception er){
            JOptionPane.showMessageDialog(null, "Something went wrong\n"+er,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
