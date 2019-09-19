import java.util.ArrayList;

public class GameController implements IGameController {

    @Override
    public boolean isGameOver(Board board) {
        int foodRemaining = board.findFoodRemaining();
        return foodRemaining == 0 || board.findPacman() == null;
    }

    @Override
    public Board movePacman(Board board, UserAction userAction) {
        Position currentPosition = board.findPacman();
        if (userAction != null)
            board.setPacmanDirection(userAction);
        Position nextPosition = this.calculateNextPosition(board, currentPosition, board.getPacmanDirection());
        this.moveGameObject(board, GameObject.PACMAN, currentPosition, nextPosition);
        return board;
    }

    @Override
    public Board moveMonsters(Board board, IMonsterController monsterController) {
        ArrayList<Position> monsterPositions = board.findMonsters();
        for(Position currentPosition : monsterPositions) {
            UserAction monsterDirection = monsterController.getNextDirection(board, currentPosition);
            Position nextPosition = this.calculateNextPosition(board, currentPosition, monsterDirection);
            this.moveGameObject(board, GameObject.MONSTER, currentPosition, nextPosition);
        }
        return board;
    }

    private Position calculateNextPosition(Board board, Position currentPosition, UserAction userAction) {
        int nextXPosition = 0;
        int nextYPosition = 0;

        switch (userAction) {
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

        if (this.canMoveOntoTile(gameObject, nextTile)) {
            currentTile.setObjectOnTile(GameObject.EMPTY);
            if (gameObject == GameObject.PACMAN)
                currentTile.setFoodOnTile(false);
            if (nextTile.getObjectOnTile() != GameObject.MONSTER)
                nextTile.setObjectOnTile(gameObject);
        }
    }

    private boolean canMoveOntoTile(GameObject gameObject, Tile nextTile) {
        boolean isNextTileWall = nextTile.getObjectOnTile() == GameObject.WALL;
        boolean isMonster = gameObject == GameObject.MONSTER;
        boolean isNextTileMonster = nextTile.getObjectOnTile() == GameObject.MONSTER;
        return !(isNextTileWall || (isMonster && isNextTileMonster));
    }
}
