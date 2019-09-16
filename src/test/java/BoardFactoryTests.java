import org.junit.Test;

import static org.junit.Assert.*;

public class BoardFactoryTests {

    @Test
    public void Given_CharBoard_When_CreateTileBoard_Then_ReturnTileBoard() {
        char[] row1 = {' ', ' ', ' '};
        char[] row2 = {' ', 'P', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] charBoard = {row1, row2, row3};
        Board result = BoardFactory.createBoardFromChars(charBoard);
        Tile[][] expected = {
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        };
        assertArrayEquals(expected, result.getTiles());
    }

    @Test
    public void Given_CharBoardWithFood_When_CreateTileBoard_Then_ReturnTileBoardWithFood() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'.', 'P', '.'};
        char[] row3 = {'.', '.', '.'};
        char[][] charBoard = {row1, row2, row3};
        Board result = BoardFactory.createBoardFromChars(charBoard);
        Tile[][] expected = {
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)}
        };

        assertArrayEquals(expected, result.getTiles());
    }

    @Test
    public void Given_CharBoardWithWallMiddleTop_When_CreateTileBoard_Then_ReturnTileBoardWithWallMiddleTop() {
        char[] row1 = {' ', 'W', ' '};
        char[] row2 = {' ', 'P', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] charBoard = {row1, row2, row3};
        Board result = BoardFactory.createBoardFromChars(charBoard);
        Tile[][] expected = {
                {new Tile(GameObject.EMPTY), new Tile(GameObject.WALL), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        };

        assertArrayEquals(expected, result.getTiles());
    }

    @Test
    public void Given_CharBoardWithMonsterMiddleTop_When_CreateTileBoard_Then_ReturnTileBoardWithMonsterMiddleTop() {
        char[] row1 = {' ', 'M', ' '};
        char[] row2 = {' ', 'P', ' '};
        char[] row3 = {' ', ' ', ' '};
        char[][] charBoard = {row1, row2, row3};
        Board result = BoardFactory.createBoardFromChars(charBoard);
        Tile[][] expected = {
                {new Tile(GameObject.EMPTY), new Tile(GameObject.MONSTER), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY)},
                {new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY), new Tile(GameObject.EMPTY)}
        };

        assertArrayEquals(expected, result.getTiles());
    }

    @Test
    public void When_CreatingInitialBoard_Then_ReturnBoardOfFoodWithPacmanInMiddle() {
        Board result = BoardFactory.initialiseBoard();
        Tile[][] expected = {
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.WALL), new Tile(GameObject.PACMAN), new Tile(GameObject.EMPTY, true)},
                {new Tile(GameObject.EMPTY, true), new Tile(GameObject.EMPTY, true), new Tile(GameObject.MONSTER)}
        };

        assertArrayEquals(expected, result.getTiles());
    }
}
