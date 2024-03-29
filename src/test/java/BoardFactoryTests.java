import com.pacman.core.Board;
import com.pacman.core.GameObject;
import com.pacman.core.Tile;
import org.junit.Test;
import com.pacman.utils.BoardFactory;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BoardFactoryTests {
    @Test
    public void When_CreatingInitialBoard_Then_ReturnBoardOfFoodWithPacmanInMiddle() {
        Board result = BoardFactory.initialiseBoard();
        Tile food = new Tile(GameObject.FOOD);
        Tile pacman = new Tile(GameObject.PACMAN);

        Tile monster = new Tile(new ArrayList<>(Arrays.asList(GameObject.FOOD, GameObject.MONSTER)));
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
