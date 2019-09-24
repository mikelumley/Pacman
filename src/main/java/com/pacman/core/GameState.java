package com.pacman.core;

public class GameState {
    private Board board;
    private GameAction currentAction = GameAction.UP;
    private boolean pacmanMouthOpen = true;

    public GameState(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameAction getCurrentAction() {
        return this.currentAction;
    }

    public void setCurrentAction(GameAction currentAction) {
        this.currentAction = currentAction;
    }

    public boolean isPacmanMouthOpen() {
        return this.pacmanMouthOpen;
    }

    public void setPacmanMouthOpen(boolean pacmanManMouthOpen) {
        this.pacmanMouthOpen = pacmanManMouthOpen;
    }
}
