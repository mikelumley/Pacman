import org.junit.Test;

import static org.junit.Assert.*;

public class BoardUpdaterTests {

    @Test
    public void Given_33BoardWithPacmanAt11_When_PlayerSelectsUp_Then_PacmanMovesUp() {
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
    public void Given_33BoardWithPacmanAt11_When_PlayerSelectsDown_Then_PacmanMovesDown() {
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
    public void Given_33BoardWithPacmanAt11_When_PlayerSelectsLeft_Then_PacmanMovesLeft() {
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
    public void Given_33BoardWithPacmanAt11_When_PlayerSelectsRight_Then_PacmanMovesRight() {
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
}
