package main.game.keyinput;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Fredrik
 */
public class KeyInput extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        boolean pressedPreviously = false;
        for (Keys key : Keys.values()) {
            key.setPressedOneTick(false);
            if(e.getKeyCode() == key.getKeyCode()){
                key.setPressedOneTick(false);
                key.setPressed(true);
                if(!pressedPreviously){
                    key.setPressedOneTick(true);
                }
                pressedPreviously = true;


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
