package com.pacman.utils;

import com.pacman.core.Board;
import com.pacman.core.GameObject;
import com.pacman.core.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class BoardFactory {
    public static Board initialiseBoard() {
        Tile[][] tiles = {
                {new Tile(GameObject.WALL), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.WALL), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.WALL), new Tile(new ArrayList<>(Arrays.asList(GameObject.MONSTER, GameObject.FOOD))), new Tile(GameObject.FOOD), new Tile(GameObject.PACMAN), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.WALL), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.WALL), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.WALL), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.WALL), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.WALL), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)}
        };

        return new Board(tiles);
    }
}
