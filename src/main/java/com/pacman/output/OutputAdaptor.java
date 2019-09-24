package com.pacman.output;

import com.pacman.core.*;

public class OutputAdaptor {
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
    private boolean isMouthOpen = true;

    public String gameStateToString(GameState gameState) {
        StringBuilder boardAsString = new StringBuilder();
        Board board = gameState.getBoard();

        for(Tile[] row : board.getTiles()) {
            for(Tile tile : row) {
                if (tile.getObjectsOnTile().contains(GameObject.PACMAN))
                    boardAsString.append(this.getPacmanSymbol(gameState.getCurrentAction()));
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

    private char getPacmanSymbol(GameAction pacmanDirection) {
        char pacmanSymbol = PACMAN_OPEN_UP;

        if (isMouthOpen) {
            if (pacmanDirection == GameAction.UP) {
                pacmanSymbol = PACMAN_OPEN_UP;
            }
            else if (pacmanDirection == GameAction.DOWN) {
                pacmanSymbol = PACMAN_OPEN_DOWN;
            }
            else if (pacmanDirection == GameAction.LEFT) {
                pacmanSymbol = PACMAN_OPEN_LEFT;
            }
            else if (pacmanDirection == GameAction.RIGHT) {
                pacmanSymbol = PACMAN_OPEN_RIGHT;
            }
        }
        else{
            if (pacmanDirection == GameAction.UP || pacmanDirection == GameAction.DOWN) {
                pacmanSymbol = PACMAN_CLOSED_UP_DOWN;
            }
            else if (pacmanDirection == GameAction.LEFT || pacmanDirection == GameAction.RIGHT) {
                pacmanSymbol = PACMAN_CLOSED_LEFT_RIGHT;
            }
        }

        isMouthOpen = !isMouthOpen;
        return pacmanSymbol;
    }
}
