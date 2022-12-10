package main.game.keyinput;

import java.awt.event.KeyEvent;

public enum Keys {
    A(KeyEvent.VK_A),
    F(KeyEvent.VK_F),
    D(KeyEvent.VK_D),
    W(KeyEvent.VK_W),
    S(KeyEvent.VK_S),
    E(KeyEvent.VK_E),
    Q(KeyEvent.VK_Q),
    R(KeyEvent.VK_R),
    UP(KeyEvent.VK_UP),
    DOWN(KeyEvent.VK_DOWN),
    RIGHT(KeyEvent.VK_RIGHT),
    LEFT(KeyEvent.VK_LEFT),
    ESC(KeyEvent.VK_ESCAPE),
    SPACE(KeyEvent.VK_SPACE),
    CTRL(KeyEvent.VK_CONTROL),
    SHIFT(KeyEvent.VK_SHIFT);

    private final int keyCode;
    private boolean pressed;

    private boolean pressedOneTick;

    private Keys(int keyCode) {
        this.keyCode = keyCode;
        this.pressed = false;
        this.pressedOneTick = false;
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

    public boolean isPressedOneTick() {
        return pressedOneTick;
    }

    public void setPressedOneTick(boolean pressedOneTick) {
        this.pressedOneTick = pressedOneTick;
    }
}
