public interface IGameController {
    boolean isGameOver(Board board);
    Board movePacman(Board board, Direction direction);
    Board moveMonsters(Board board, IMonsterController monsterController);
}
