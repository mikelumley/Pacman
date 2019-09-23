package com.pacman.core;

import java.util.ArrayList;
import java.util.Objects;

public class Tile {

    private ArrayList<GameObject> objectsOnTile;

    public Tile() {
        this.objectsOnTile = new ArrayList<>();
    }

    public Tile(GameObject objectOnTile) {
        this.objectsOnTile = new ArrayList<>();
        this.objectsOnTile.add(objectOnTile);
    }

    public Tile(ArrayList<GameObject> objectsOnTile) {
        this.objectsOnTile = objectsOnTile;
    }

    public ArrayList<GameObject> getObjectsOnTile() {
        return this.objectsOnTile;
    }

    public void addObjectToTile(GameObject objectToAdd) {
        this.objectsOnTile.add(objectToAdd);
    }

    public void removeObjectFromTile(GameObject objectToRemove) {
        this.objectsOnTile.remove(objectToRemove);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Tile tile = (Tile) obj;
        return Objects.equals(objectsOnTile, tile.objectsOnTile);
    }
}
