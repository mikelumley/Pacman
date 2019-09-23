package com.pacman.utils;

import com.pacman.core.Board;
import com.pacman.core.GameObject;
import com.pacman.core.Tile;

import java.util.ArrayList;

public class BoardFactory {

    public static Board createBoardFromChars(char[][] boardAsChars) {
        // TODO: 2019-09-09 Add validation
        int numberOfRows = boardAsChars.length;
        int numberOfCols = boardAsChars[0].length;
        Tile[][] tiles = new Tile[numberOfRows][numberOfCols];

        for(int i = 0; i < numberOfRows; i++) {
            for(int j = 0; j < numberOfCols; j++) {
                char currentChar = boardAsChars[i][j];
                if (currentChar == 'P') {
                    tiles[i][j] = new Tile(GameObject.PACMAN);
                }
                else if (currentChar == ' ') {
                    tiles[i][j] = new Tile();
                }
                else if (currentChar == '.') {
                    tiles[i][j] = new Tile(GameObject.FOOD);
                }
                else if (currentChar == 'W') {
                    tiles[i][j] = new Tile(GameObject.WALL);
                }
                else if (currentChar == 'M') {
                    tiles[i][j] = new Tile(GameObject.MONSTER);
                    tiles[i][j].addObjectToTile(GameObject.FOOD);
                }
            }
        }
        return new Board(tiles);
    }

    public static Board initialiseBoard() {
        char[] row1 = {'W', '.', '.', '.', '.', 'W', '.'};
        char[] row2 = {'W', 'M', '.', 'P', '.', '.', '.'};
        char[] row3 = {'.', '.', 'W', '.', '.', 'W', '.'};
        char[] row4 = {'.', '.', 'W', '.', '.', 'W', '.'};
        char[] row5 = {'.', '.', 'W', '.', '.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3, row4, row5};
        return createBoardFromChars(boardAsChar);
    }
}
