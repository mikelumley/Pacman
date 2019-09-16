import java.util.ArrayList;

public class GameController implements IGameController {

    public boolean isGameOver() {
        return false;
    }

    @Override
    public Board movePacman(Board board, Direction direction) {
        Position currentPosition = board.findPacman();
        Position nextPosition = this.calculateNextPosition(board, currentPosition, direction);
        board.moveGameObject(GameObject.PACMAN, currentPosition, nextPosition);
        return board;
    }

    @Override
    public Board moveMonsters(Board board, IMonsterController monsterController) {
        ArrayList<Position> monsterPositions = board.findMonsters();

        for(Position currentPosition : monsterPositions) {
            Direction direction = monsterController.getNextDirection(board, currentPosition);
            Position nextPosition = this.calculateNextPosition(board, currentPosition, direction);
            board.moveGameObject(GameObject.MONSTER, currentPosition, nextPosition);
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
}
