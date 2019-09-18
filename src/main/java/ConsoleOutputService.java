public class ConsoleOutputService implements IOutputService {
    @Override
    public void displayBoard(Board board) {
        // Clear terminal
        System.out.print("\033[H\033[2J");

        System.out.print("Score: " + board.calculateScore() + "\r\n\r\n");

        for(Tile[] row : board.getTiles()) {
            for(Tile tile : row) {
                if (tile.getObjectOnTile() == GameObject.PACMAN)
                    System.out.print(this.getPacmanSymbol(board.getPacmanDirection()));
                else if (tile.getObjectOnTile() == GameObject.EMPTY && tile.hasFood())
                    System.out.print('.');
                else if (tile.getObjectOnTile() == GameObject.WALL)
                    System.out.print('=');
                else if (tile.getObjectOnTile() == GameObject.MONSTER)
                    System.out.print('M');
                else
                    System.out.print(' ');
            }
            System.out.print("\r\n");
        }
        System.out.print("\r\n");
    }

    private char getPacmanSymbol(Direction pacmanDirection) {
        switch (pacmanDirection) {
            default:
            case UP :
                return 'v';
            case DOWN :
                return '^';
            case LEFT :
                return '>';
            case RIGHT :
                return '<';
        }
    }
}
