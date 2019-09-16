import org.junit.Test;

import static org.junit.Assert.*;

public class BoardUpdaterTests {

    @Test
    public void Given_BoardWithPacmanAtMiddle_When_PlayerSelectsUp_Then_PacmanMovesUp() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'P', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        Tile[][] result = updater.movePacman(startingBoard, Direction.UP);

        char[] expectedRow1 = {' ', 'P', ' '};
        char[] expectedRow2 = {' ', ' ', ' '};
        char[] expectedRow3 = {' ', ' ', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Tile[][] expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanAtMiddle_When_PlayerSelectsDown_Then_PacmanMovesDown() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'P', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        Tile[][] result = updater.movePacman(startingBoard, Direction.DOWN);

        char[] expectedRow1 = {' ', ' ', ' '};
        char[] expectedRow2 = {' ', ' ', ' '};
        char[] expectedRow3 = {' ', 'P', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Tile[][] expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanAtMiddle_When_PlayerSelectsLeft_Then_PacmanMovesLeft() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'P', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        Tile[][] result = updater.movePacman(startingBoard, Direction.LEFT);

        char[] expectedRow1 = {' ', ' ', ' '};
        char[] expectedRow2 = {'P', ' ', ' '};
        char[] expectedRow3 = {' ', ' ', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Tile[][] expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanAtMiddle_When_PlayerSelectsRight_Then_PacmanMovesRight() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'P', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        Tile[][] result = updater.movePacman(startingBoard, Direction.RIGHT);

        char[] expectedRow1 = {' ', ' ', ' '};
        char[] expectedRow2 = {' ', ' ', 'P'};
        char[] expectedRow3 = {' ', ' ', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Tile[][] expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleTop_When_PlayerSelectsUp_Then_PacmanMovesToMiddleBottom() {
        char[] row1 = {' ', 'P', ' '};
        char[] row2 = {' ', ' ', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        Tile[][] result = updater.movePacman(startingBoard, Direction.UP);

        char[] expectedRow1 = {' ', ' ', ' '};
        char[] expectedRow2 = {' ', ' ', ' '};
        char[] expectedRow3 = {' ', 'P', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Tile[][] expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleBottom_When_PlayerSelectsDown_Then_PacmanMovesToMiddleTop() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', ' ', ' '};
        char[] row3 = {' ', 'P', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        Tile[][] result = updater.movePacman(startingBoard, Direction.DOWN);

        char[] expectedRow1 = {' ', 'P', ' '};
        char[] expectedRow2 = {' ', ' ', ' '};
        char[] expectedRow3 = {' ', ' ', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Tile[][] expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleLeft_When_PlayerSelectsLeft_Then_PacmanMovesToMiddleRight() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {'P', ' ', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        Tile[][] result = updater.movePacman(startingBoard, Direction.LEFT);

        char[] expectedRow1 = {' ', ' ', ' '};
        char[] expectedRow2 = {' ', ' ', 'P'};
        char[] expectedRow3 = {' ', ' ', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Tile[][] expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleRight_When_PlayerSelectsLeft_Then_PacmanMovesToMiddleLeft() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', ' ', 'P'};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        Tile[][] result = updater.movePacman(startingBoard, Direction.RIGHT);

        char[] expectedRow1 = {' ', ' ', ' '};
        char[] expectedRow2 = {'P', ' ', ' '};
        char[] expectedRow3 = {' ', ' ', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Tile[][] expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanAtMiddle_When_PacmanEats1Food_Then_ScoreIncreasesBy1() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'.', 'P', '.'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        Tile[][] board = updater.movePacman(startingBoard, Direction.UP);
        int result = updater.calculateScore(board);
        assertEquals(1, result);
    }

    @Test
    public void Given_BoardWithPacmanAtMiddle_When_PacmanEats2Food_Then_ScoreIncreasesBy2() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'.', 'P', '.'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        Tile[][] board = updater.movePacman(startingBoard, Direction.UP);
        board = updater.movePacman(board, Direction.UP);
        int result = updater.calculateScore(board);
        assertEquals(2, result);
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleAndWallInMiddleTop_When_PlayerSelectsUP_Then_PacmanStays() {
        char[] row1 = {'.', 'W', '.'};
        char[] row2 = {'.', 'P', '.'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        Tile[][] result = updater.movePacman(startingBoard, Direction.UP);
        Tile[][] expected = BoardFactory.createBoardFromChars(boardAsChar);
        assertArrayEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleAndWallInMiddleBottom_When_PlayerSelectsDown_Then_PacmanStays() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'.', 'P', '.'};
        char[] row3 = {'.', 'W', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        Tile[][] result = updater.movePacman(startingBoard, Direction.DOWN);
        Tile[][] expected = BoardFactory.createBoardFromChars(boardAsChar);
        assertArrayEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanAtMiddleAndWallInMiddleLeft_When_PlayerSelectsLeft_Then_PacmanStays() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'W', 'P', '.'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        Tile[][] result = updater.movePacman(startingBoard, Direction.LEFT);
        Tile[][] expected = BoardFactory.createBoardFromChars(boardAsChar);
        assertArrayEquals(expected, result);
    }
    @Test
    public void Given_BoardWithPacmanAtMiddleAndWallInMiddleRight_When_PlayerSelectsRight_Then_PacmanStays() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'.', 'P', 'W'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        Tile[][] result = updater.movePacman(startingBoard, Direction.RIGHT);
        Tile[][] expected = BoardFactory.createBoardFromChars(boardAsChar);
        assertArrayEquals(expected, result);
    }

    @Test
    public void Given_BoardWithMonsterAtMiddle_When_MonsterControllerSelectsUp_Then_MonsterMovesToMiddleTop() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'M', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        IMonsterController monsterController = new StubMonsterController(Direction.UP);
        Tile[][] result = updater.moveMonsters(startingBoard, monsterController);

        char[] expectedRow1 = {' ', 'M', ' '};
        char[] expectedRow2 = {' ', ' ', ' '};
        char[] expectedRow3 = {' ', ' ', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Tile[][] expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected, result);
    }

    @Test
    public void Given_BoardWithMonsterAtMiddle_When_MonsterControllerSelectsDown_Then_MonsterMovesToMiddleBottom() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'M', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        IMonsterController monsterController = new StubMonsterController(Direction.DOWN);
        Tile[][] result = updater.moveMonsters(startingBoard, monsterController);

        char[] expectedRow1 = {' ', ' ', ' '};
        char[] expectedRow2 = {' ', ' ', ' '};
        char[] expectedRow3 = {' ', 'M', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Tile[][] expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected, result);
    }

    @Test
    public void Given_BoardWithMonsterAtMiddle_When_MonsterControllerSelectsLeft_Then_MonsterMovesToMiddleLeft() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'M', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        IMonsterController monsterController = new StubMonsterController(Direction.LEFT);
        Tile[][] result = updater.moveMonsters(startingBoard, monsterController);

        char[] expectedRow1 = {' ', ' ', ' '};
        char[] expectedRow2 = {'M', ' ', ' '};
        char[] expectedRow3 = {' ', ' ', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Tile[][] expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected, result);
    }

    @Test
    public void Given_BoardWithMonsterAtMiddle_When_MonsterControllerSelectsRight_Then_MonsterMovesToMiddleRight() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'M', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        IMonsterController monsterController = new StubMonsterController(Direction.RIGHT);
        Tile[][] result = updater.moveMonsters(startingBoard, monsterController);

        char[] expectedRow1 = {' ', ' ', ' '};
        char[] expectedRow2 = {' ', ' ', 'M'};
        char[] expectedRow3 = {' ', ' ', ' '};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Tile[][] expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected, result);
    }

    @Test
    public void Given_BoardWithMonsterAtMiddle_When_MonsterMoves_Then_MonsterDoesNotEatFood() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'.', 'M', '.'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Tile[][] startingBoard = BoardFactory.createBoardFromChars(boardAsChar);
        BoardUpdater updater = new BoardUpdater();
        IMonsterController monsterController = new StubMonsterController(Direction.UP);
        Tile[][] result = updater.moveMonsters(startingBoard, monsterController);

        char[] expectedRow1 = {'.', 'M', '.'};
        char[] expectedRow2 = {'.', '.', '.'};
        char[] expectedRow3 = {'.', '.', '.'};
        char[][] expectedBoardAsChar = {expectedRow1, expectedRow2, expectedRow3};
        Tile[][] expected = BoardFactory.createBoardFromChars(expectedBoardAsChar);
        assertArrayEquals(expected, result);
    }
}
