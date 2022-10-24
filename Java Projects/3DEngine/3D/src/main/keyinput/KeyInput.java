package main.keyinput;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Fredrik
 */
public class KeyInput extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        for (Keys key : Keys.values()) {
            if(e.getKeyCode() == key.getKeyCode()){
                key.setPressed(true);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        for (Keys key : Keys.values()) {
            if (e.getKeyCode() == key.getKeyCode()) {
                key.setPressed(false);
            }
        }
    }
}
