package com.pacman.output;

public interface IOutputService {
    void displayBoard(String boardAsString, int score);
    void displayFinalScore(int finalScore);
}
