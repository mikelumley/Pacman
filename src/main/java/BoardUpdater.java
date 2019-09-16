import java.util.ArrayList;

public class BoardUpdater implements IBoardUpdater {

    public boolean isGameOver() {
        return false;
    }

    @Override
    public Tile[][] movePacman(Tile[][] board, Direction direction) {
        Position currentPosition = this.findPacman(board);
        Position nextPosition = this.calcualteNextPosition(board, currentPosition, direction);
        this.moveGameObject(board, GameObject.PACMAN, currentPosition, nextPosition);
        return board;
    }

    @Override
    public Tile[][] moveMonsters(Tile[][] board, IMonsterController monsterController) {
        ArrayList<Position> monsterPositions = this.findMonsters(board);

        for(Position currentPosition : monsterPositions) {
            Direction direction = monsterController.getNextDirection(board, currentPosition);
            Position nextPosition = this.calcualteNextPosition(board, currentPosition, direction);
            this.moveGameObject(board, GameObject.MONSTER, currentPosition, nextPosition);
        }
        return board;
    }

    @Override
    public int calculateScore(Tile[][] board) {
        int score = 0;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j].getObjectOnTile() == GameObject.EMPTY && !board[i][j].hasFood())
                    score++;
            }
        }
        return score;
    }

    private void moveGameObject(Tile[][] board, GameObject gameObject, Position currentPosition, Position nextPosition) {
        if (board[nextPosition.getX()][nextPosition.getY()].getObjectOnTile() != GameObject.WALL) {
            board[currentPosition.getX()][currentPosition.getY()].setObjectOnTile(GameObject.EMPTY);
            board[nextPosition.getX()][nextPosition.getY()].setObjectOnTile(gameObject);
            if (gameObject == GameObject.PACMAN)
                board[currentPosition.getX()][currentPosition.getY()].setFoodOnTile(false);
        }
    }

    private Position calcualteNextPosition(Tile[][] board,  Position currentPosition, Direction direction) {
        int nextXPosition = 0;
        int nextYPosition = 0;

        switch (direction) {
            case UP:
                nextXPosition = (currentPosition.getX() + board.length - 1) % board.length;
                nextYPosition = currentPosition.getY();
                break;
            case DOWN:
                nextXPosition = (currentPosition.getX() + board.length + 1) % board.length;
                nextYPosition = currentPosition.getY();
                break;
            case LEFT:
                nextXPosition = currentPosition.getX();
                nextYPosition = (currentPosition.getY() + board.length - 1) % board.length;
                break;
            case RIGHT:
                nextXPosition = currentPosition.getX();
                nextYPosition = (currentPosition.getY() + board.length + 1) % board.length;
                break;
        }
        return new Position(nextXPosition, nextYPosition);
    }

    private Position findPacman(Tile[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                Tile tile = board[i][j];
                if (tile.getObjectOnTile() == GameObject.PACMAN) {
                    return new Position(i, j);
                }
            }
        }
        throw new RuntimeException("Error: Pacman doesn't exist");
    }

    private ArrayList<Position> findMonsters(Tile[][] board) {
        ArrayList<Position> monsterPositions = new ArrayList<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                Tile tile = board[i][j];
                if (tile.getObjectOnTile() == GameObject.MONSTER) {
                    monsterPositions.add(new Position(i, j));
                }
            }
        }
        return monsterPositions;
    }

}
