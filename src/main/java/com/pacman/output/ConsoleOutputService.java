package com.pacman.output;

public class ConsoleOutputService implements IOutputService {

    @Override
    public void displayBoard(String boardAsString, int score) {
        // Clear terminal
        System.out.print("\033[H\033[2J");
        System.out.print("Score: " + score + "\r\n\r\n");
        System.out.print(boardAsString + "\r\n");
    }

    @Override
    public void displayFinalScore(int finalScore) {
        System.out.print("Final score was: " + finalScore + "\r\n");
    }


}
