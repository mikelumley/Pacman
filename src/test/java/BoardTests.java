import com.pacman.core.Board;
import com.pacman.core.Coordinates;
import com.pacman.core.GameObject;
import com.pacman.core.Tile;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BoardTests {

    @Test
    public void Given_BoardWithPacmanAtMiddle_When_FindingPacman_Then_ReturnMiddlePosition() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.PACMAN), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)}
        });
        Coordinates result = board.findPacman();
        Coordinates expected = new Coordinates(1,1);
        assertEquals(expected, result);
    }

    @Test
    public void Given_BoardWithNoPacman_When_FindingPacman_Then_ReturnNull() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)}
        });
        Coordinates result = board.findPacman();
        Coordinates expected = null;
        assertEquals(expected, result);
    }

    @Test
    public void Given_BoardWithMonsters_When_FindingMonsters_Then_ReturnTheirPositions() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.MONSTER), new Tile(GameObject.MONSTER)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.MONSTER)}
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
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)}
        });

        ArrayList<Coordinates> result = board.findMonsters();
        Coordinates[] resultAsArray = new Coordinates[result.size()];
        result.toArray(resultAsArray);

        Coordinates[] expected = {};
        assertArrayEquals(expected, resultAsArray);
    }
}
