package com.pacman.output;

import com.pacman.core.GameState;

public interface IOutputService {
    void displayBoard(GameState gameState, int score);
    void displayFinalScore(int finalScore);
}
