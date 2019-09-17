public class Game {

    private IGameController gameController = new GameController();
    private Board board;
    private IInputService inputService;
    private IMonsterController monsterController;

    public Game(IInputService inputService, IMonsterController monsterController) {
        this.board = BoardFactory.initialiseBoard();
        this.inputService = inputService;
        this.monsterController = monsterController;
    }

    public int play() {
        while(!this.gameController.isGameOver(this.board)) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Clear terminal
            // TODO: 2019-09-16 Move to output service
            System.out.print("\033[H\033[2J");

            this.board = this.gameController.movePacman(this.board, this.inputService.getUserInputDirection());
            this.board = this.gameController.moveMonsters(this.board, this.monsterController);

            System.out.print("Score: " + this.board.calculateScore() + "\r\n");
            this.printBoard();
        }
        // TODO: 2019-09-17 Better way to do this?
        ((ConsoleInputService)this.inputService).setConsoleToCookedMode();
        return this.board.calculateScore();
    }

    private void printBoard() {
        for(Tile[] row : this.board.getTiles()) {
            for(Tile tile : row) {
                if (tile.getObjectOnTile() == GameObject.PACMAN)
                    System.out.print('P');
                else if (tile.getObjectOnTile() == GameObject.EMPTY && tile.hasFood())
                    System.out.print('.');
                else if (tile.getObjectOnTile() == GameObject.WALL)
                    System.out.print('W');
                else if (tile.getObjectOnTile() == GameObject.MONSTER)
                    System.out.print('M');
                else
                    System.out.print(' ');
            }
            System.out.print("\r\n");
        }
        System.out.print("\r\n");
    }
}
