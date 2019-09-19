package com.pacman.core;

import java.util.ArrayList;

public class Board {
    private Tile[][] tiles;
    private int numberOfRows;
    private int numberOfCols;
    private GameAction lastAction = GameAction.UP;

    public Board(Tile[][] tiles) {
        this.tiles = tiles;
        this.numberOfRows = tiles.length;
        this.numberOfCols = tiles[0].length;
    }

    public Tile[][] getTiles() {
        return this.tiles;
    }

    public Tile getTile(Coordinates position) {
        return this.tiles[position.getX()][position.getY()];
    }

    public int getNumberOfRows() {
        return this.numberOfRows;
    }

    public int getNumberOfCols() {
        return this.numberOfCols;
    }

    public GameAction getLastAction() {
        return this.lastAction;
    }

    public void setLastAction(GameAction gameAction) {
        this.lastAction = gameAction;
    }

    public Coordinates findPacman() {
        for(int i = 0; i < this.numberOfRows; i++) {
            for(int j = 0; j < this.numberOfCols; j++) {
                Tile currentTile = this.tiles[i][j];
                boolean tileHasPacman = currentTile.getObjectOnTile() == GameObject.PACMAN;
                if (tileHasPacman) {
                    return new Coordinates(i, j);
                }
            }
        }
        return null;
    }

    public ArrayList<Coordinates> findMonsters() {
        ArrayList<Coordinates> monsterPositions = new ArrayList<>();
        for(int i = 0; i < this.numberOfRows; i++) {
            for(int j = 0; j < this.numberOfCols; j++) {
                Tile currentTile = this.tiles[i][j];
                boolean tileHasMonster = currentTile.getObjectOnTile() == GameObject.MONSTER;
                if (tileHasMonster) {
                    monsterPositions.add(new Coordinates(i, j));
                }
            }
        }
        return monsterPositions;
    }

    public int findFoodRemaining() {
        int food = 0;
        for (Tile[] row : this.tiles) {
            for (Tile currentTile : row) {
                boolean tileIsEmptyAndHasFood = currentTile.getObjectOnTile() == GameObject.EMPTY && currentTile.hasFood();
                if (tileIsEmptyAndHasFood) {
                    food++;
                }
            }
        }
        return food;
    }

    public int calculateScore() {
        int score = 0;
        for (Tile[] row : this.tiles) {
            for (Tile currentTile : row) {
                boolean tileIsEmptyAndNoFood = currentTile.getObjectOnTile() == GameObject.EMPTY && !currentTile.hasFood();
                if (tileIsEmptyAndNoFood)
                    score++;
            }
        }
        return score;
    }
}
