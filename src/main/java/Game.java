public class Game {

    private IGameController gameController = new GameController();
    private Board board;
    private IInputService inputService;
    private IOutputService outputService;
    private IMonsterController monsterController;

    public Game(IInputService inputService, IOutputService outputService, IMonsterController monsterController) {
        this.board = BoardFactory.initialiseBoard();
        this.inputService = inputService;
        this.outputService = outputService;
        this.monsterController = monsterController;
    }

    public int play() {
        while(!this.gameController.isGameOver(this.board)) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.board = this.gameController.movePacman(this.board, this.inputService.getUserInputDirection());
            this.board = this.gameController.moveMonsters(this.board, this.monsterController);

            this.outputService.displayBoard(this.board);
        }
        // TODO: 2019-09-17 Better way to do this?
        ((ConsoleInputService)this.inputService).setConsoleToCookedMode();
        return this.board.calculateScore();
    }
}
