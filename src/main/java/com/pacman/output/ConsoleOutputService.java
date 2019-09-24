package com.pacman.output;

import com.pacman.core.*;

public class ConsoleOutputService implements IOutputService {

    private static final char MONSTER = 'M';
    private static final char FOOD = '.';
    private static final char WALL = '=';
    private static final char EMPTY = ' ';
    private static final char PACMAN_OPEN_UP = 'v';
    private static final char PACMAN_OPEN_DOWN = '^';
    private static final char PACMAN_OPEN_LEFT = '>';
    private static final char PACMAN_OPEN_RIGHT = '<';
    private static final char PACMAN_CLOSED_UP_DOWN = '|';
    private static final char PACMAN_CLOSED_LEFT_RIGHT = '-';

    @Override
    public void displayBoard(GameState gameState, int score) {
        String gameStateAsString = this.convertGameStateToString(gameState);
        // Clear terminal
        System.out.print("\033[H\033[2J");
        System.out.print("Score: " + score + "\r\n\r\n");
        System.out.print(gameStateAsString + "\r\n");
    }

    @Override
    public void displayFinalScore(int finalScore) {
        System.out.print("Final score was: " + finalScore + "\r\n");
    }

    private String convertGameStateToString(GameState gameState) {
        StringBuilder boardAsString = new StringBuilder();
        Board board = gameState.getBoard();

        for(Tile[] row : board.getTiles()) {
            for(Tile tile : row) {
                if (tile.getObjectsOnTile().contains(GameObject.PACMAN)) {
                    GameAction currentAction = gameState.getCurrentAction();
                    boolean isMouthOpen = gameState.isPacmanMouthOpen();
                    char pacmanSymbol = this.getPacmanSymbol(currentAction, isMouthOpen);
                    boardAsString.append(pacmanSymbol);
                }
                else if (tile.getObjectsOnTile().contains(GameObject.MONSTER))
                    boardAsString.append(MONSTER);
                else if (tile.getObjectsOnTile().contains(GameObject.FOOD))
                    boardAsString.append(FOOD);
                else if (tile.getObjectsOnTile().contains(GameObject.WALL))
                    boardAsString.append(WALL);
                else
                    boardAsString.append(EMPTY);
            }
            boardAsString.append("\r\n");
        }
        return boardAsString.toString();
    }

    private char getPacmanSymbol(GameAction pacmanDirection, boolean isMouthOpen) {
        if (isMouthOpen) {
            switch (pacmanDirection) {
                default :
                case UP :
                    return PACMAN_OPEN_UP;
                case DOWN :
                    return PACMAN_OPEN_DOWN;
                case LEFT :
                    return PACMAN_OPEN_LEFT;
                case RIGHT :
                    return PACMAN_OPEN_RIGHT;
            }
        }
        else{
            switch (pacmanDirection) {
                default :
                case UP :
                case DOWN :
                    return PACMAN_CLOSED_UP_DOWN;
                case LEFT :
                case RIGHT :
                    return PACMAN_CLOSED_LEFT_RIGHT;
            }
        }
    }
}
