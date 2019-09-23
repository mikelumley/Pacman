package com.pacman.core;

import com.pacman.input.IInputService;
import com.pacman.input.InputAdaptor;
import com.pacman.output.IOutputService;
import com.pacman.output.OutputAdaptor;
import com.pacman.utils.BoardFactory;

public class Game {

    private static final int TIME_BETWEEN_UPDATES = 500;

    private Board board;
    private IInputService inputService;
    private InputAdaptor inputAdaptor = new InputAdaptor();
    private IOutputService outputService;
    private OutputAdaptor outputAdaptor = new OutputAdaptor();
    private IGameController gameController;
    private IMonsterController monsterController;

    public Game(IInputService inputService, IOutputService outputService,
                IGameController gameController, IMonsterController monsterController) {
        this.board = BoardFactory.initialiseBoard();
        this.inputService = inputService;
        this.outputService = outputService;
        this.gameController = gameController;
        this.monsterController = monsterController;
    }

    public int play() {
        int score = 0;

        while(!this.gameController.isGameOver(this.board)) {
            try {
                Thread.sleep(TIME_BETWEEN_UPDATES);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int characterCode = this.inputService.readUserInput();
            GameAction gameAction = this.inputAdaptor.inputToAction(characterCode);

            if (gameAction == GameAction.EXIT) {
                this.inputService.closeInputService();
                System.out.print("Exiting\r\n");
                System.exit(0);
            }

            this.board = this.gameController.movePacman(this.board, gameAction);
            this.board = this.gameController.moveMonsters(this.board, this.monsterController);

            String boardAsString = this.outputAdaptor.boardToString(board);
            score = this.gameController.calculateScore(this.board);
            this.outputService.displayBoard(boardAsString, score);
        }
        return score;
    }
}
