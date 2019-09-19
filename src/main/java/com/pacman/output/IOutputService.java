package com.pacman.output;

import com.pacman.core.Board;

public interface IOutputService {
    void displayBoard(Board board);
    void displayFinalScore(int finalScore);
}
