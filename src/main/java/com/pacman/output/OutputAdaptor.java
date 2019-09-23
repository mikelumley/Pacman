package com.pacman.output;

import com.pacman.core.Board;
import com.pacman.core.GameAction;
import com.pacman.core.GameObject;
import com.pacman.core.Tile;

public class OutputAdaptor {
    private boolean isMouthOpen = true;

    public String boardToString(Board board) {
        StringBuilder boardAsString = new StringBuilder();

        for(Tile[] row : board.getTiles()) {
            for(Tile tile : row) {
                if (tile.getObjectsOnTile().contains(GameObject.PACMAN))
                    boardAsString.append(this.getPacmanSymbol(board.getLastAction()));
                else if (tile.getObjectsOnTile().contains(GameObject.MONSTER))
                    boardAsString.append('M');
                else if (tile.getObjectsOnTile().contains(GameObject.FOOD))
                    boardAsString.append('.');
                else if (tile.getObjectsOnTile().contains(GameObject.WALL))
                    boardAsString.append('=');
                else
                    boardAsString.append(' ');
            }
            boardAsString.append("\r\n");
        }
        return boardAsString.toString();
    }

    private char getPacmanSymbol(GameAction pacmanDirection) {
        char pacmanSymbol = 'v';

        if (isMouthOpen) {
            if (pacmanDirection == GameAction.UP) {
                pacmanSymbol = 'v';
            }
            else if (pacmanDirection == GameAction.DOWN) {
                pacmanSymbol = '^';
            }
            else if (pacmanDirection == GameAction.LEFT) {
                pacmanSymbol = '>';
            }
            else if (pacmanDirection == GameAction.RIGHT) {
                pacmanSymbol = '<';
            }
        }
        else{
            if (pacmanDirection == GameAction.UP || pacmanDirection == GameAction.DOWN) {
                pacmanSymbol = '|';
            }
            else if (pacmanDirection == GameAction.LEFT || pacmanDirection == GameAction.RIGHT) {
                pacmanSymbol = '-';
            }
        }

        isMouthOpen = !isMouthOpen;
        return pacmanSymbol;
    }
}
