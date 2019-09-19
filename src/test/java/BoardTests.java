import com.pacman.core.Board;
import com.pacman.core.Coordinates;
import org.junit.Test;
import com.pacman.utils.BoardFactory;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BoardTests {

    @Test
    public void Given_BoardWithPacmanAtMiddle_When_FindingPacman_Then_ReturnMiddlePosition() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'.', 'P', '.'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Board board = BoardFactory.createBoardFromChars(boardAsChar);
        Coordinates result = board.findPacman();
        Coordinates expected = new Coordinates(1,1);
        assertEquals(expected, result);
    }

    @Test
    public void Given_BoardWithNoPacman_When_FindingPacman_Then_ThrowExpection() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'.', '.', '.'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Board board = BoardFactory.createBoardFromChars(boardAsChar);
        Coordinates result = board.findPacman();
        Coordinates expected = null;
        assertEquals(expected, result);
    }

    @Test
    public void Given_BoardWithMonsters_When_FindingMonsters_Then_ReturnTheirPositions() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'.', 'M', 'M'};
        char[] row3 = {'.', '.', 'M'};
        char[][] boardAsChar = {row1, row2, row3};
        Board board = BoardFactory.createBoardFromChars(boardAsChar);

        ArrayList<Coordinates> result = board.findMonsters();
        Coordinates[] resultAsArray = new Coordinates[result.size()];
        result.toArray(resultAsArray);

        Coordinates[] expected = {new Coordinates(1,1), new Coordinates(1,2), new Coordinates(2,2)};
        assertArrayEquals(expected, resultAsArray);
    }

    @Test
    public void Given_BoardWithNoMonsters_When_FindingMonsters_Then_ReturnEmptyList() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'.', '.', '.'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Board board = BoardFactory.createBoardFromChars(boardAsChar);

        ArrayList<Coordinates> result = board.findMonsters();
        Coordinates[] resultAsArray = new Coordinates[result.size()];
        result.toArray(resultAsArray);

        Coordinates[] expected = {};
        assertArrayEquals(expected, resultAsArray);
    }

    @Test
    public void Given_BoardWithNoFoodEaten_When_CalculatingScore_Then_Return0() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'.', 'P', '.'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Board board = BoardFactory.createBoardFromChars(boardAsChar);
        int result = board.calculateScore();
        assertEquals(0, result);
    }

    @Test
    public void Given_BoardWith1FoodEaten_When_CalculatingScore_Then_Return1() {
        char[] row1 = {'.', 'P', '.'};
        char[] row2 = {'.', ' ', '.'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Board board = BoardFactory.createBoardFromChars(boardAsChar);
        int result = board.calculateScore();
        assertEquals(1, result);
    }

    @Test
    public void Given_BoardWith1FoodEatenAndWall_When_CalculatingScore_Then_Return1() {
        char[] row1 = {'.', 'P', '.'};
        char[] row2 = {'W', ' ', '.'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Board board = BoardFactory.createBoardFromChars(boardAsChar);
        int result = board.calculateScore();
        assertEquals(1, result);
    }

    @Test
    public void Given_BoardWith1FoodEatenAndMonster_When_CalculatingScore_Then_Return1() {
        char[] row1 = {'.', 'P', '.'};
        char[] row2 = {'M', ' ', '.'};
        char[] row3 = {'.', '.', '.'};
        char[][] boardAsChar = {row1, row2, row3};
        Board board = BoardFactory.createBoardFromChars(boardAsChar);
        int result = board.calculateScore();
        assertEquals(1, result);
    }
}
