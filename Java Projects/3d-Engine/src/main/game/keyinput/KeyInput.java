package main.game.keyinput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class KeyInput implements KeyListener {

    private final Map<Integer, Keys> keys;

    public KeyInput() {
        this.keys = new HashMap<>();
        for (Keys key : Keys.values()) {
            keys.put(key.getKeyCode(), key);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Keys key = keys.get(e.getKeyCode());
        if (key != null) {
            key.setPressed(true);
            key.setPressedOneTick(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Keys key = keys.get(e.getKeyCode());
        if (key != null) {
            key.setPressed(false);
            key.setPressedOneTick(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not implemented
    }
}
