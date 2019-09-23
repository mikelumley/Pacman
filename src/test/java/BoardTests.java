import com.pacman.core.Board;
import com.pacman.core.Coordinates;
import com.pacman.core.GameObject;
import com.pacman.core.Tile;
import org.junit.Test;
import com.pacman.utils.BoardFactory;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BoardTests {

    @Test
    public void Given_BoardWithPacmanAtMiddle_When_FindingPacman_Then_ReturnMiddlePosition() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.PACMAN, true), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)}
        });
        Coordinates result = board.findPacman();
        Coordinates expected = new Coordinates(1,1);
        assertEquals(expected, result);
    }

    @Test
    public void Given_BoardWithNoPacman_When_FindingPacman_Then_ReturnNull() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)}
        });
        Coordinates result = board.findPacman();
        Coordinates expected = null;
        assertEquals(expected, result);
    }

    @Test
    public void Given_BoardWithMonsters_When_FindingMonsters_Then_ReturnTheirPositions() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.MONSTER, true), new Tile(GameObject.MONSTER, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.MONSTER, true)}
        });

        ArrayList<Coordinates> result = board.findMonsters();
        Coordinates[] resultAsArray = new Coordinates[result.size()];
        result.toArray(resultAsArray);

        Coordinates[] expected = {new Coordinates(1,1), new Coordinates(1,2), new Coordinates(2,2)};
        assertArrayEquals(expected, resultAsArray);
    }

    @Test
    public void Given_BoardWithNoMonsters_When_FindingMonsters_Then_ReturnEmptyList() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)}
        });

        ArrayList<Coordinates> result = board.findMonsters();
        Coordinates[] resultAsArray = new Coordinates[result.size()];
        result.toArray(resultAsArray);

        Coordinates[] expected = {};
        assertArrayEquals(expected, resultAsArray);
    }

    @Test
    public void Given_BoardWithNoFoodEaten_When_CalculatingScore_Then_Return0() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.PACMAN, false), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)}
        });
        int result = board.calculateScore();
        assertEquals(0, result);
    }

    @Test
    public void Given_BoardWith1FoodEaten_When_CalculatingScore_Then_Return1() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.PACMAN, false), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, false), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)}
        });
        int result = board.calculateScore();
        assertEquals(1, result);
    }

    @Test
    public void Given_BoardWith1FoodEatenAndWall_When_CalculatingScore_Then_Return1() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.PACMAN, false), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.WALL, false), new Tile(GameObject.EMPTY, false), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)}
        });
        int result = board.calculateScore();
        assertEquals(1, result);
    }

    @Test
    public void Given_BoardWith1FoodEatenAndMonster_When_CalculatingScore_Then_Return1() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.PACMAN, false), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.MONSTER, true), new Tile(GameObject.EMPTY, false), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)}
        });
        int result = board.calculateScore();
        assertEquals(1, result);
    }
}
