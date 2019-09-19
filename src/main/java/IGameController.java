public interface IGameController {
    boolean isGameOver(Board board);
    Board movePacman(Board board, UserAction userAction);
    Board moveMonsters(Board board, IMonsterController monsterController);
}
