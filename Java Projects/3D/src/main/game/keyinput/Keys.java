package main.game.keyinput;

import java.awt.event.KeyEvent;

public enum Keys {
    A(false, KeyEvent.VK_A),
    F(false, KeyEvent.VK_F),
    D(false, KeyEvent.VK_D),
    W(false, KeyEvent.VK_W),
    S(false, KeyEvent.VK_S),
    E(false, KeyEvent.VK_E),
    Q(false, KeyEvent.VK_Q),
    R(false, KeyEvent.VK_R),
    UP(false, KeyEvent.VK_UP),
    DOWN(false, KeyEvent.VK_DOWN),
    RIGHT(false, KeyEvent.VK_RIGHT),
    LEFT(false, KeyEvent.VK_LEFT),
    ESC(false, KeyEvent.VK_ESCAPE),
    SPACE(false, KeyEvent.VK_SPACE),
    CTRL(false, KeyEvent.VK_CONTROL),
    SHIFT(false, KeyEvent.VK_SHIFT);

    private final int keyCode;
    private boolean pressed;

    private Keys(boolean pressed, int keyCode) {
        this.pressed = pressed;
        this.keyCode = keyCode;

    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public int getKeyCode() {
        return keyCode;
    }
}
