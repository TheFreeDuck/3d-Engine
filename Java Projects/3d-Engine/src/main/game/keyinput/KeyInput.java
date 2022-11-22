package main.game.keyinput;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Fredrik
 */
public class KeyInput extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        for (Keys key : Keys.values()) {
            key.setFirstPressed(false);
            if(e.getKeyCode() == key.getKeyCode()){
                key.setPressed(true);
                key.setFirstPressed(true);
            }
        }

    }

    //TODO if tapped

    @Override
    public void keyReleased(KeyEvent e) {
        for (Keys key : Keys.values()) {
            if (e.getKeyCode() == key.getKeyCode()) {
                key.setPressed(false);
            }
        }
    }
}
