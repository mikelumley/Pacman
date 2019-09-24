package com.pacman.core;

import java.util.ArrayList;

public class GameController implements IGameController {

    @Override
    public boolean isGameOver(Board board) {
        int foodRemaining = board.findFoodRemaining();
        return foodRemaining == 0 || board.findPacman() == null;
    }

    @Override
    public Board movePacman(GameState currentGameState) {
        Board board = currentGameState.getBoard();
        Coordinates currentPosition = board.findPacman();
        Coordinates nextPosition = this.calculateNextPosition(board, currentPosition, currentGameState.getCurrentAction());
        this.moveGameObject(board, GameObject.PACMAN, currentPosition, nextPosition);
        return board;
    }

    @Override
    public Board moveMonsters(Board board, IMonsterController monsterController) {
        ArrayList<Coordinates> monsterPositions = board.findMonsters();
        for(Coordinates currentPosition : monsterPositions) {
            GameAction monsterDirection = monsterController.getNextDirection(board, currentPosition);
            Coordinates nextPosition = this.calculateNextPosition(board, currentPosition, monsterDirection);
            this.moveGameObject(board, GameObject.MONSTER, currentPosition, nextPosition);
        }
        return board;
    }

    @Override
    public int calculateScore(Board board) {
        int score = 0;
        for (Tile[] row : board.getTiles()) {
            for (Tile currentTile : row) {
                boolean tileIsEmptyAndNoFood = currentTile.getObjectsOnTile().size() == 0;
                if (tileIsEmptyAndNoFood)
                    score++;
            }
        }
        return score;
    }

    private Coordinates calculateNextPosition(Board board, Coordinates currentPosition, GameAction gameAction) {
        int nextXPosition = 0;
        int nextYPosition = 0;

        switch (gameAction) {
            case UP:
                nextXPosition = (currentPosition.getX() + board.getNumberOfRows() - 1) % board.getNumberOfRows();
                nextYPosition = currentPosition.getY();
                break;
            case DOWN:
                nextXPosition = (currentPosition.getX() + board.getNumberOfRows() + 1) % board.getNumberOfRows();
                nextYPosition = currentPosition.getY();
                break;
            case LEFT:
                nextXPosition = currentPosition.getX();
                nextYPosition = (currentPosition.getY() + board.getNumberOfCols() - 1) % board.getNumberOfCols();
                break;
            case RIGHT:
                nextXPosition = currentPosition.getX();
                nextYPosition = (currentPosition.getY() + board.getNumberOfCols() + 1) % board.getNumberOfCols();
                break;
        }
        return new Coordinates(nextXPosition, nextYPosition);
    }

    private void moveGameObject(Board board, GameObject gameObject, Coordinates currentPosition, Coordinates nextPosition) {
        Tile currentTile = board.getTile(currentPosition);
        Tile nextTile = board.getTile(nextPosition);

        if (this.canMoveOntoTile(gameObject, nextTile)) {
            currentTile.removeObjectFromTile(gameObject);
            nextTile.addObjectToTile(gameObject);
            if (nextTile.getObjectsOnTile().contains(GameObject.PACMAN) && nextTile.getObjectsOnTile().contains(GameObject.MONSTER))
                nextTile.removeObjectFromTile(GameObject.PACMAN);
            if (gameObject == GameObject.PACMAN)
                currentTile.removeObjectFromTile(GameObject.FOOD);
        }
    }

    private boolean canMoveOntoTile(GameObject gameObject, Tile nextTile) {
        boolean isNextTileWall = nextTile.getObjectsOnTile().contains(GameObject.WALL);
        boolean isMonster = gameObject == GameObject.MONSTER;
        boolean isNextTileMonster = nextTile.getObjectsOnTile().contains(GameObject.MONSTER);
        return !(isNextTileWall || (isMonster && isNextTileMonster));
    }
}
