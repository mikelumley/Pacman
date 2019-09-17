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
        Tile food = new Tile(GameObject.EMPTY, true);
        Tile pacman = new Tile(GameObject.PACMAN,false);
        Tile monster = new Tile(GameObject.MONSTER, true);
        Tile wall = new Tile(GameObject.WALL, false);

        Tile[][] expected = {
                {wall, food, food, food, food, wall, food},
                {wall, monster, food, pacman, food, food, food},
                {food, food, monster, food, food, wall, food},
                {food, food, wall, food, food, wall, food},
                {food, food, wall, food, food, food, food},
        };

        assertArrayEquals(expected, result.getTiles());
    }
}
