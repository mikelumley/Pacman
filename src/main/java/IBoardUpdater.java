public interface IBoardUpdater {
    Tile[][] movePacman(Tile[][] board, Direction direction);
    Tile[][] moveMonsters(Tile[][] board, IMonsterController monsterController);
    int calculateScore(Tile[][] board);
}
