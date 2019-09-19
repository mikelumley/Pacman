package com.pacman.core;

public interface IMonsterController {
    GameAction getNextDirection(Board board, Coordinates currentPosition);
}
