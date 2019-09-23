package com.pacman.input;

import com.pacman.core.GameAction;

public class InputAdaptor {
    private static final int EXIT_CODE = 3;
    private static final int W_CODE = 119;
    private static final int S_CODE = 115;
    private static final int A_CODE = 97;
    private static final int D_CODE = 100;

    public GameAction inputToAction(int characterCode) {
        switch (characterCode) {
            case EXIT_CODE:
                return GameAction.EXIT;
            case W_CODE:
                return GameAction.UP;
            case S_CODE:
                return GameAction.DOWN;
            case A_CODE:
                return GameAction.LEFT;
            case D_CODE:
                return GameAction.RIGHT;
            default:
                return GameAction.NO_INPUT;
        }
    }
}
