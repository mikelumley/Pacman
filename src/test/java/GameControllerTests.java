import org.junit.Test;

import static org.junit.Assert.*;

public class GameControllerTests {

    @Test
    public void Given_BoardWithPacmanAtMiddle_When_PlayerSelectsUp_Then_PacmanMovesUp() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'P', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Board startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, Direction.UP);

        char[] expectedRow1 = {' ', 'P', ' '};
        char[] expectedRow2 = {' ', ' ', ' '};
        char[] expectedRow3 = {' ', ' ', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Board expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddle_When_PlayerSelectsDown_Then_PacmanMovesDown() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'P', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Board startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, Direction.DOWN);

        char[] expectedRow1 = {' ', ' ', ' '};
        char[] expectedRow2 = {' ', ' ', ' '};
        char[] expectedRow3 = {' ', 'P', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Board expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddle_When_PlayerSelectsLeft_Then_PacmanMovesLeft() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'P', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Board startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, Direction.LEFT);

        char[] expectedRow1 = {' ', ' ', ' '};
        char[] expectedRow2 = {'P', ' ', ' '};
        char[] expectedRow3 = {' ', ' ', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Board expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddle_When_PlayerSelectsRight_Then_PacmanMovesRight() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'P', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Board startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, Direction.RIGHT);

        char[] expectedRow1 = {' ', ' ', ' '};
        char[] expectedRow2 = {' ', ' ', 'P'};
        char[] expectedRow3 = {' ', ' ', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Board expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleTop_When_PlayerSelectsUp_Then_PacmanMovesToMiddleBottom() {
        char[] row1 = {' ', 'P', ' '};
        char[] row2 = {' ', ' ', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Board startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, Direction.UP);

        char[] expectedRow1 = {' ', ' ', ' '};
        char[] expectedRow2 = {' ', ' ', ' '};
        char[] expectedRow3 = {' ', 'P', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Board expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleBottom_When_PlayerSelectsDown_Then_PacmanMovesToMiddleTop() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', ' ', ' '};
        char[] row3 = {' ', 'P', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Board startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, Direction.DOWN);

        char[] expectedRow1 = {' ', 'P', ' '};
        char[] expectedRow2 = {' ', ' ', ' '};
        char[] expectedRow3 = {' ', ' ', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Board expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleLeft_When_PlayerSelectsLeft_Then_PacmanMovesToMiddleRight() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {'P', ' ', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Board startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, Direction.LEFT);

        char[] expectedRow1 = {' ', ' ', ' '};
        char[] expectedRow2 = {' ', ' ', 'P'};
        char[] expectedRow3 = {' ', ' ', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Board expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleRight_When_PlayerSelectsLeft_Then_PacmanMovesToMiddleLeft() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', ' ', 'P'};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Board startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, Direction.RIGHT);

        char[] expectedRow1 = {' ', ' ', ' '};
        char[] expectedRow2 = {'P', ' ', ' '};
        char[] expectedRow3 = {' ', ' ', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Board expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleAndWallInMiddleTop_When_PlayerSelectsUP_Then_PacmanStays() {
        char[] row1 = {'.', 'W', '.'};
        char[] row2 = {'.', 'P', '.'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Board startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, Direction.UP);
        Board expected = BoardFactory.createBoardFromChars(boardAsChar);
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleAndWallInMiddleBottom_When_PlayerSelectsDown_Then_PacmanStays() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'.', 'P', '.'};
        char[] row3 = {'.', 'W', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Board startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, Direction.DOWN);
        Board expected = BoardFactory.createBoardFromChars(boardAsChar);
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleAndWallInMiddleLeft_When_PlayerSelectsLeft_Then_PacmanStays() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'W', 'P', '.'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Board startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, Direction.LEFT);
        Board expected = BoardFactory.createBoardFromChars(boardAsChar);
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }
    @Test
    public void Given_BoardWithPacmanAtMiddleAndWallInMiddleRight_When_PlayerSelectsRight_Then_PacmanStays() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'.', 'P', 'W'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Board startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        Board result = updater.movePacman(startingBoard, Direction.RIGHT);
        Board expected = BoardFactory.createBoardFromChars(boardAsChar);
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithMonsterAtMiddle_When_MonsterControllerSelectsUp_Then_MonsterMovesToMiddleTop() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'M', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Board startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        IMonsterController monsterController = new StubMonsterController(Direction.UP);
        Board result = updater.moveMonsters(startingBoard, monsterController);

        char[] expectedRow1 = {' ', 'M', ' '};
        char[] expectedRow2 = {' ', ' ', ' '};
        char[] expectedRow3 = {' ', ' ', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Board expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithMonsterAtMiddle_When_MonsterControllerSelectsDown_Then_MonsterMovesToMiddleBottom() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'M', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Board startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        IMonsterController monsterController = new StubMonsterController(Direction.DOWN);
        Board result = updater.moveMonsters(startingBoard, monsterController);

        char[] expectedRow1 = {' ', ' ', ' '};
        char[] expectedRow2 = {' ', ' ', ' '};
        char[] expectedRow3 = {' ', 'M', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Board expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithMonsterAtMiddle_When_MonsterControllerSelectsLeft_Then_MonsterMovesToMiddleLeft() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'M', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Board startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        IMonsterController monsterController = new StubMonsterController(Direction.LEFT);
        Board result = updater.moveMonsters(startingBoard, monsterController);

        char[] expectedRow1 = {' ', ' ', ' '};
        char[] expectedRow2 = {'M', ' ', ' '};
        char[] expectedRow3 = {' ', ' ', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Board expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithMonsterAtMiddle_When_MonsterControllerSelectsRight_Then_MonsterMovesToMiddleRight() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'M', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Board startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        IMonsterController monsterController = new StubMonsterController(Direction.RIGHT);
        Board result = updater.moveMonsters(startingBoard, monsterController);

        char[] expectedRow1 = {' ', ' ', ' '};
        char[] expectedRow2 = {' ', ' ', 'M'};
        char[] expectedRow3 = {' ', ' ', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Board expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithMonsterAtMiddle_When_MonsterMoves_Then_MonsterDoesNotEatFood() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'.', 'M', '.'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Board startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        IMonsterController monsterController = new StubMonsterController(Direction.UP);
        Board result = updater.moveMonsters(startingBoard, monsterController);

        char[] expectedRow1 = {'.', 'M', '.'};
        char[] expectedRow2 = {'.', '.', '.'};
        char[] expectedRow3 = {'.', '.', '.'};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Board expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWith2Monsters_When_MonsterMovesOntoOtherMonster_Then_MonsterStays() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'W', 'M', 'M'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Board startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        IMonsterController monsterController = new StubMonsterController(Direction.LEFT);
        Board result = updater.moveMonsters(startingBoard, monsterController);

        char[] expectedRow1 = {'.', '.', '.'};
        char[] expectedRow2 = {'W', 'M', 'M'};
        char[] expectedRow3 = {'.', '.', '.'};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Board expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected.getTiles(), result.getTiles());
    }

    @Test
    public void Given_BoardWithFoodLeft_When_CheckingIfGameOver_Then_ReturnFalse() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'.', 'P', '.'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Board board = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        assertFalse(updater.isGameOver(board));
    }

    @Test
    public void Given_BoardWithNoFoodLeft_When_CheckingIfGameOver_Then_ReturnTrue() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'P', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Board board = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        assertTrue(updater.isGameOver(board));
    }

    @Test
    public void Given_BoardWithNoFoodLeftAndMonster_When_CheckingIfGameOver_Then_ReturnTrue() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'P', ' '};
        char[] row3 = {' ', ' ', 'M'};
        char[][] boardAsChar = {row1, row2, row3};
        Board board = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        assertTrue(updater.isGameOver(board));
    }

    @Test
    public void Given_BoardWithFoodAndMonsterAtePacman_When_CheckingIfGameOver_Then_ReturnTrue() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'P', 'M'};
        char[] row3 = {' ', '.', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Board board = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        board = updater.moveMonsters(board, new StubMonsterController(Direction.LEFT));
        assertTrue(updater.isGameOver(board));
    }

    @Test
    public void Given_BoardWithFoodAndPacmanMoveOntoMonster_When_CheckingIfGameOver_Then_ReturnTrue() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'P', 'M'};
        char[] row3 = {' ', '.', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Board board = BoardFactory.createBoardFromChars(boardAsChar);
        GameController updater = new GameController();
        board = updater.movePacman(board, Direction.RIGHT);
        assertTrue(updater.isGameOver(board));
    }
}
