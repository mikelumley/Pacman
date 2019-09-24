package com.pacman.core;

public interface IGameController {
    boolean isGameOver(Board board);
    Board movePacman(GameState currentGameState);
    Board moveMonsters(Board board, IMonsterController monsterController);
    int calculateScore(Board board);
}
