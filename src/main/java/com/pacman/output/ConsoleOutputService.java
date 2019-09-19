package com.pacman.output;

import com.pacman.core.Board;
import com.pacman.core.GameObject;
import com.pacman.core.Tile;
import com.pacman.core.GameAction;

public class ConsoleOutputService implements IOutputService {
    private boolean isMouthOpen = true;

    @Override
    public void displayBoard(Board board) {
        // Clear terminal
        System.out.print("\033[H\033[2J");

        System.out.print("Score: " + board.calculateScore() + "\r\n\r\n");

        for(Tile[] row : board.getTiles()) {
            for(Tile tile : row) {
                if (tile.getObjectOnTile() == GameObject.PACMAN)
                    System.out.print(this.getPacmanSymbol(board.getLastAction()));
                else if (tile.getObjectOnTile() == GameObject.EMPTY && tile.hasFood())
                    System.out.print('.');
                else if (tile.getObjectOnTile() == GameObject.WALL)
                    System.out.print('=');
                else if (tile.getObjectOnTile() == GameObject.MONSTER)
                    System.out.print('M');
                else
                    System.out.print(' ');
            }
            System.out.print("\r\n");
        }
        System.out.print("\r\n");
    }

    @Override
    public void displayFinalScore(int finalScore) {
        System.out.println("Final score was: " + finalScore);
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
