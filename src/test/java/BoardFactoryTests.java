import org.junit.Test;

import static org.junit.Assert.*;

public class BoardFactoryTests {

    @Test
    public void Given_CharBoard_When_CreateTileBoard_Then_ReturnTileBoard() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'P', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] charBoard = {row1, row2, row3};
        Tile[][] result = BoardFactory.createBoardFromChars(charBoard);
        Tile[][] expected = {
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        };

        assertArrayEquals(expected, result);
    }
}
