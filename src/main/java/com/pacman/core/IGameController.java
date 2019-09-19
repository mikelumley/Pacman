package com.pacman.core;

public interface IGameController {
    boolean isGameOver(Board board);
    Board movePacman(Board board, GameAction gameAction);
    Board moveMonsters(Board board, IMonsterController monsterController);
}
