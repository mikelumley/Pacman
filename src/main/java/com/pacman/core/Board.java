package com.pacman.core;

import java.util.ArrayList;

public class Board {
    private Tile[][] tiles;
    private int numberOfRows;
    private int numberOfCols;

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

    public Coordinates findPacman() {
        for(int i = 0; i < this.numberOfRows; i++) {
            for(int j = 0; j < this.numberOfCols; j++) {
                Tile currentTile = this.tiles[i][j];
                boolean tileHasPacman = currentTile.getObjectsOnTile().contains(GameObject.PACMAN);
                if (tileHasPacman)
                    return new Coordinates(i, j);
            }
        }
        return null;
    }

    public ArrayList<Coordinates> findMonsters() {
        ArrayList<Coordinates> monsterPositions = new ArrayList<>();
        for(int i = 0; i < this.numberOfRows; i++) {
            for(int j = 0; j < this.numberOfCols; j++) {
                Tile currentTile = this.tiles[i][j];
                boolean tileHasMonster = currentTile.getObjectsOnTile().contains(GameObject.MONSTER);
                if (tileHasMonster)
                    monsterPositions.add(new Coordinates(i, j));
            }
        }
        return monsterPositions;
    }

    public int findFoodRemaining() {
        int food = 0;
        for (Tile[] row : this.tiles) {
            for (Tile currentTile : row) {
                boolean tileHasFood = currentTile.getObjectsOnTile().contains(GameObject.FOOD);
                if (tileHasFood)
                    food++;
            }
        }
        return food;
    }

    public boolean isPacmanDead() {
        for(int i = 0; i < this.numberOfRows; i++) {
            for(int j = 0; j < this.numberOfCols; j++) {
                Tile currentTile = this.tiles[i][j];
                boolean tileHasPacman = currentTile.getObjectsOnTile().contains(GameObject.PACMAN);
                boolean tileHasMonster = currentTile.getObjectsOnTile().contains(GameObject.MONSTER);
                if (tileHasPacman && tileHasMonster)
                    return true;
            }
        }
        return false;
    }
}
