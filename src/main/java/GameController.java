import java.util.ArrayList;

public class GameController implements IGameController {

    private Direction pacmanDirection = Direction.UP;

    @Override
    public boolean isGameOver(Board board) {
        return board.calculateScore() == 7;
    }

    @Override
    public Board movePacman(Board board, Direction userInputDirection) {
        Position currentPosition = board.findPacman();
        if (userInputDirection != null)
            this.pacmanDirection = userInputDirection;
        Position nextPosition = this.calculateNextPosition(board, currentPosition, this.pacmanDirection);
        this.moveGameObject(board, GameObject.PACMAN, currentPosition, nextPosition);
        return board;
    }

    @Override
    public Board moveMonsters(Board board, IMonsterController monsterController) {
        ArrayList<Position> monsterPositions = board.findMonsters();

        for(Position currentPosition : monsterPositions) {
            Direction monsterDirection = monsterController.getNextDirection(board, currentPosition);
            Position nextPosition = this.calculateNextPosition(board, currentPosition, monsterDirection);
            this.moveGameObject(board, GameObject.MONSTER, currentPosition, nextPosition);
        }
        return board;
    }

    private Position calculateNextPosition(Board board, Position currentPosition, Direction direction) {
        int nextXPosition = 0;
        int nextYPosition = 0;

        switch (direction) {
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
        return new Position(nextXPosition, nextYPosition);
    }

    private void moveGameObject(Board board, GameObject gameObject, Position currentPosition, Position nextPosition) {
        Tile currentTile = board.getTile(currentPosition);
        Tile nextTile = board.getTile(nextPosition);

        if (nextTile.getObjectOnTile() != GameObject.WALL) {
            currentTile.setObjectOnTile(GameObject.EMPTY);
            nextTile.setObjectOnTile(gameObject);
            if (gameObject == GameObject.PACMAN)
                currentTile.setFoodOnTile(false);
        }
    }
}
