public interface IGameController {
    Board movePacman(Board board, Direction direction);
    Board moveMonsters(Board board, IMonsterController monsterController);
}
