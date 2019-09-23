import com.pacman.core.Board;
import com.pacman.core.GameObject;
import com.pacman.core.Tile;
import org.junit.Test;
import com.pacman.utils.BoardFactory;

import java.util.ArrayList;

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
                {new Tile(), new Tile(), new Tile()},
                {new Tile(), new Tile(GameObject.PACMAN), new Tile()},
                {new Tile(), new Tile(), new Tile()}
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
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.PACMAN), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)}
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
                {new Tile(), new Tile(GameObject.WALL), new Tile()},
                {new Tile(), new Tile(GameObject.PACMAN), new Tile()},
                {new Tile(), new Tile(), new Tile()}
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

        ArrayList<GameObject> objectsOnMonsterTile = new ArrayList<>();
        objectsOnMonsterTile.add(GameObject.MONSTER);
        objectsOnMonsterTile.add(GameObject.FOOD);

        Tile[][] expected = {
                {new Tile(), new Tile(objectsOnMonsterTile), new Tile()},
                {new Tile(), new Tile(GameObject.PACMAN), new Tile()},
                {new Tile(), new Tile(), new Tile()}
        };

        assertArrayEquals(expected, result.getTiles());
    }

    @Test
    public void When_CreatingInitialBoard_Then_ReturnBoardOfFoodWithPacmanInMiddle() {
        Board result = BoardFactory.initialiseBoard();
        Tile food = new Tile(GameObject.FOOD);
        Tile pacman = new Tile(GameObject.PACMAN);

        ArrayList<GameObject> objectsOnMonsterTile = new ArrayList<>();
        objectsOnMonsterTile.add(GameObject.MONSTER);
        objectsOnMonsterTile.add(GameObject.FOOD);

        Tile monster = new Tile(objectsOnMonsterTile);
        Tile wall = new Tile(GameObject.WALL);

        Tile[][] expected = {
                {wall, food, food, food, food, wall, food},
                {wall, monster, food, pacman, food, food, food},
                {food, food, wall, food, food, wall, food},
                {food, food, wall, food, food, wall, food},
                {food, food, wall, food, food, food, food},
        };

        assertArrayEquals(expected, result.getTiles());
    }
}
