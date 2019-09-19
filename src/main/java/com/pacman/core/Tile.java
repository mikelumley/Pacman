package com.pacman.core;

public class Tile {

    private GameObject objectOnTile;
    private boolean foodOnTile = false;

    public Tile(GameObject objectOnTile) {
        this.objectOnTile = objectOnTile;
        this.foodOnTile = false;
    }

    public Tile(GameObject objectOnTile, boolean foodOnTile) {
        this.objectOnTile = objectOnTile;
        this.foodOnTile = foodOnTile;
    }

    public GameObject getObjectOnTile() {
        return this.objectOnTile;
    }

    public void setObjectOnTile(GameObject objectOnTile) {
        this.objectOnTile = objectOnTile;
    }

    public boolean hasFood() {
        return this.foodOnTile;
    }

    public void setFoodOnTile(boolean hasFood) {
        this.foodOnTile = hasFood;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Tile tile = (Tile) obj;
        return objectOnTile == tile.objectOnTile;
    }
}
