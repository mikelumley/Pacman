public class Game {

    private GameController updater = new GameController();
    private Board board;

    public Game() {
        this.board = BoardFactory.initialiseBoard();
    }

    public int play() {
        while(!this.updater.isGameOver()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Clear terminal
            System.out.print("\033[H\033[2J");

            this.board = this.updater.movePacman(this.board, Direction.UP);

            System.out.println("Score: " + this.board.calculateScore());
            this.printBoard();
        }
        return this.board.calculateScore();
    }

    private void printBoard() {
        for(Tile[] row : this.board.getTiles()) {
            for(Tile tile : row) {
                if (tile.getObjectOnTile() == GameObject.PACMAN)
                    System.out.print('P');
                else if (tile.hasFood())
                    System.out.print('.');
                else if (tile.getObjectOnTile() == GameObject.WALL)
                    System.out.print('W');
                else
                    System.out.print(' ');
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
