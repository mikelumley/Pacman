public class BoardUpdater implements IBoardUpdater {

    @Override
    public Tile[][] movePacman(Tile[][] board, Direction direction) {
        Position pacmanPosition = this.findPacman(board);
        switch (direction) {
            case UP:
                board[pacmanPosition.getX()][pacmanPosition.getY()].setObjectOnTile(GameObject.EMPTY);
                board[pacmanPosition.getX() - 1][pacmanPosition.getY()].setObjectOnTile(GameObject.PACMAN);
                break;
            case DOWN:
                board[pacmanPosition.getX()][pacmanPosition.getY()].setObjectOnTile(GameObject.EMPTY);
                board[pacmanPosition.getX() + 1][pacmanPosition.getY()].setObjectOnTile(GameObject.PACMAN);
                break;
            case LEFT:
                board[pacmanPosition.getX()][pacmanPosition.getY()].setObjectOnTile(GameObject.EMPTY);
                board[pacmanPosition.getX()][pacmanPosition.getY() - 1].setObjectOnTile(GameObject.PACMAN);
                break;
            case RIGHT:
                board[pacmanPosition.getX()][pacmanPosition.getY()].setObjectOnTile(GameObject.EMPTY);
                board[pacmanPosition.getX()][pacmanPosition.getY() + 1].setObjectOnTile(GameObject.PACMAN);
                break;
        }
        return board;
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
