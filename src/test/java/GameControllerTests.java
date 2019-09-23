import com.pacman.core.*;
import org.junit.Test;
import com.pacman.utils.BoardFactory;

import static org.junit.Assert.*;

public class GameControllerTests {

    @Test
    public void Given_BoardWithPacmanAtMiddle_When_PlayerSelectsUp_Then_PacmanMovesUp() {
        Board startingBoard = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });

        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, GameAction.UP);

        Board expected = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddle_When_PlayerSelectsDown_Then_PacmanMovesDown() {
        Board startingBoard = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });

        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, GameAction.DOWN);

        Board expected = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)}
        });
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddle_When_PlayerSelectsLeft_Then_PacmanMovesLeft() {
        Board startingBoard = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });

        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, GameAction.LEFT);

        Board expected = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddle_When_PlayerSelectsRight_Then_PacmanMovesRight() {
        Board startingBoard = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });

        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, GameAction.RIGHT);

        Board expected = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleTop_When_PlayerSelectsUp_Then_PacmanMovesToMiddleBottom() {
        Board startingBoard = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });

        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, GameAction.UP);

        Board expected = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)}
        });
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleBottom_When_PlayerSelectsDown_Then_PacmanMovesToMiddleTop() {
        Board startingBoard = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)}
        });

        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, GameAction.DOWN);

        Board expected = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleLeft_When_PlayerSelectsLeft_Then_PacmanMovesToMiddleRight() {
        Board startingBoard = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });

        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, GameAction.LEFT);

        Board expected = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleRight_When_PlayerSelectsLeft_Then_PacmanMovesToMiddleLeft() {
        Board startingBoard = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });

        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, GameAction.LEFT);

        Board expected = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleAndWallInMiddleTop_When_PlayerSelectsUP_Then_PacmanStays() {
        Board startingBoard = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.WALL), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });

        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, GameAction.UP);

        Board expected = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.WALL), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleAndWallInMiddleBottom_When_PlayerSelectsDown_Then_PacmanStays() {
        Board startingBoard = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.WALL), new Tile(GameObject.EMPTY)}
        });

        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, GameAction.DOWN);

        Board expected = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.WALL), new Tile(GameObject.EMPTY)}
        });
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleAndWallInMiddleLeft_When_PlayerSelectsLeft_Then_PacmanStays() {
        Board startingBoard = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.WALL), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });

        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, GameAction.LEFT);

        Board expected = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.WALL), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }
    @Test
    public void Given_BoardWithPacmanAtMiddleAndWallInMiddleRight_When_PlayerSelectsRight_Then_PacmanStays() {
        Board startingBoard = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.WALL)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });

        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, GameAction.RIGHT);

        Board expected = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.WALL)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithMonsterAtMiddle_When_MonsterControllerSelectsUp_Then_MonsterMovesToMiddleTop() {
        Board startingBoard = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.MONSTER), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });

        GameController updater = new GameController();
        IMonsterController monsterController = new StubMonsterController(GameAction.UP);
        Board result = updater.moveMonsters(startingBoard, monsterController);

        Board expected = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.MONSTER), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithMonsterAtMiddle_When_MonsterControllerSelectsDown_Then_MonsterMovesToMiddleBottom() {
        Board startingBoard = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.MONSTER), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });

        GameController updater = new GameController();
        IMonsterController monsterController = new StubMonsterController(GameAction.DOWN);
        Board result = updater.moveMonsters(startingBoard, monsterController);

        Board expected = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.MONSTER), new Tile(GameObject.EMPTY)}
        });
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithMonsterAtMiddle_When_MonsterControllerSelectsLeft_Then_MonsterMovesToMiddleLeft() {
        Board startingBoard = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.MONSTER), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });

        GameController updater = new GameController();
        IMonsterController monsterController = new StubMonsterController(GameAction.LEFT);
        Board result = updater.moveMonsters(startingBoard, monsterController);

        Board expected = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.MONSTER), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithMonsterAtMiddle_When_MonsterControllerSelectsRight_Then_MonsterMovesToMiddleRight() {
        Board startingBoard = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.MONSTER), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });

        GameController updater = new GameController();
        IMonsterController monsterController = new StubMonsterController(GameAction.RIGHT);
        Board result = updater.moveMonsters(startingBoard, monsterController);

        Board expected = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.MONSTER)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithMonsterAtMiddle_When_MonsterMoves_Then_MonsterDoesNotEatFood() {
        Board startingBoard = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.MONSTER, true), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)}
        });

        GameController updater = new GameController();
        IMonsterController monsterController = new StubMonsterController(GameAction.UP);
        Board result = updater.moveMonsters(startingBoard, monsterController);

        Board expected = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.MONSTER, true), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)}
        });
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWith2Monsters_When_MonsterMovesOntoOtherMonster_Then_MonsterStays() {
        Board startingBoard = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.WALL, false), new Tile(GameObject.MONSTER, true), new Tile(GameObject.MONSTER, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)}
        });
        GameController updater = new GameController();
        IMonsterController monsterController = new StubMonsterController(GameAction.LEFT);
        Board result = updater.moveMonsters(startingBoard, monsterController);

        Board expected = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.WALL, false), new Tile(GameObject.MONSTER, true), new Tile(GameObject.MONSTER, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)}
        });
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithFoodLeft_When_CheckingIfGameOver_Then_ReturnFalse() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.PACMAN, true), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)}
        });
        GameController updater = new GameController();
        assertFalse(updater.isGameOver(board));
    }

    @Test
    public void Given_BoardWithNoFoodLeft_When_CheckingIfGameOver_Then_ReturnTrue() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });
        GameController updater = new GameController();
        assertTrue(updater.isGameOver(board));
    }

    @Test
    public void Given_BoardWithNoFoodLeftAndMonster_When_CheckingIfGameOver_Then_ReturnTrue() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.MONSTER)}
        });
        GameController updater = new GameController();
        assertTrue(updater.isGameOver(board));
    }

    @Test
    public void Given_BoardWithFoodAndMonsterAtePacman_When_CheckingIfGameOver_Then_ReturnTrue() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.MONSTER)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });
        GameController updater = new GameController();
        board = updater.moveMonsters(board, new StubMonsterController(GameAction.LEFT));
        assertTrue(updater.isGameOver(board));
    }

    @Test
    public void Given_BoardWithFoodAndPacmanMoveOntoMonster_When_CheckingIfGameOver_Then_ReturnTrue() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.MONSTER)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        });
        GameController updater = new GameController();
        board = updater.movePacman(board, GameAction.RIGHT);
        assertTrue(updater.isGameOver(board));
    }
}
