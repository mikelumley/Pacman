import com.pacman.core.Board;
import com.pacman.core.GameObject;
import com.pacman.core.Tile;
import com.pacman.output.OutputAdaptor;
import org.junit.Test;

import static org.junit.Assert.*;

public class OutputAdaptorTests {

    @Test
    public void Given_BoardWithPacmanMonstersWallsFood_When_ConvertingToString_Return_StringOfBoard() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.FOOD), new Tile(GameObject.PACMAN), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.MONSTER), new Tile(), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.WALL)}
        });

        OutputAdaptor outputAdaptor = new OutputAdaptor();
        String result = outputAdaptor.boardToString(board);
        String expected = ".v.\r\n" +
                          "M .\r\n" +
                          "..=\r\n";
        assertEquals(expected, result);
    }
}
