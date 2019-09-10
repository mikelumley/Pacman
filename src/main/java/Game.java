public class Game {

    private BoardUpdater updater = new BoardUpdater();
    private Tile[][] board;

    public Game() {
        this.board = BoardFactory.initialiseBoard();
    }

    public int play() {
        while(true) {
            updater.movePacman(this.board, Direction.UP);
        }
    }

    public void printBoard() {
        for(Tile[] row : this.board) {
            for(Tile tile : row) {
                if (tile.getObjectOnTile() == GameObject.PACMAN)
                    System.out.print('P');
                else if (tile.getObjectOnTile() == GameObject.FOOD)
                    System.out.print('.');
                else
                    System.out.print(' ');
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
