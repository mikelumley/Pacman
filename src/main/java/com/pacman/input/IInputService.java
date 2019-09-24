package com.pacman.input;

import com.pacman.core.GameAction;

public interface IInputService {
    void openInputService();
    GameAction readUserInput();
    void closeInputService();
}
