public class BoardUpdater implements IBoardUpdater {

    private int score = 0;

    public int getScore() {
        return this.score;
    }

    public boolean isGameOver() {
        return score == 8;
    }

    @Override
    public Tile[][] movePacman(Tile[][] board, Direction direction) {
        Position pacmanPosition = this.findPacman(board);
        switch (direction) {
            case UP:
                this.moveUp(board, pacmanPosition);
                break;
            case DOWN:
                this.moveDown(board, pacmanPosition);
                break;
            case LEFT:
                this.moveLeft(board, pacmanPosition);
                break;
            case RIGHT:
                this.moveRight(board, pacmanPosition);
                break;
        }
        return board;
    }

    private void moveUp(Tile[][] board, Position position) {
        int nextXPosition = (position.getX() + board.length - 1) % board.length;
        Position nextPosition = new Position(nextXPosition, position.getY());
        if (this.canMoveToPosition(board, nextPosition)) {
            this.calcScore(board, nextPosition);
            this.moveGameObject(board, GameObject.PACMAN, position, nextPosition);
        }
    }

    private void moveDown(Tile[][] board, Position position) {
        int nextXPosition = (position.getX() + board.length + 1) % board.length;
        Position nextPosition = new Position(nextXPosition, position.getY());
        if (this.canMoveToPosition(board, nextPosition)) {
            this.calcScore(board, nextPosition);
            this.moveGameObject(board, GameObject.PACMAN, position, nextPosition);
        }
    }

    private void moveLeft(Tile[][] board, Position position) {
        int nextYPosition = (position.getY() + board.length - 1) % board.length;
        Position nextPosition = new Position(position.getX(), nextYPosition);
        if (this.canMoveToPosition(board, nextPosition)) {
            this.calcScore(board, nextPosition);
            this.moveGameObject(board, GameObject.PACMAN, position, nextPosition);
        }
    }

    private void moveRight(Tile[][] board, Position position) {
        int nextYPosition = (position.getY() + board.length + 1) % board.length;
        Position nextPosition = new Position(position.getX(), nextYPosition);
        if (this.canMoveToPosition(board, nextPosition)) {
            this.calcScore(board, nextPosition);
            this.moveGameObject(board, GameObject.PACMAN, position, nextPosition);
        }
    }

    private void calcScore(Tile[][] board, Position nextPosition) {
        if (board[nextPosition.getX()][nextPosition.getY()].getObjectOnTile() == GameObject.FOOD)
            score++;
    }

    private boolean canMoveToPosition(Tile[][] board, Position nextPosition) {
        return board[nextPosition.getX()][nextPosition.getY()].getObjectOnTile() != GameObject.WALL;
    }

    private void moveGameObject(Tile[][] board, GameObject gameObject, Position currentPosition, Position nextPosition) {
        board[currentPosition.getX()][currentPosition.getY()].setObjectOnTile(GameObject.EMPTY);
        board[nextPosition.getX()][nextPosition.getY()].setObjectOnTile(gameObject);
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

}
