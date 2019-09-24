import com.pacman.core.*;
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
        GameState gameState = new GameState(board);
        OutputAdaptor outputAdaptor = new OutputAdaptor();
        String result = outputAdaptor.gameStateToString(gameState);
        String expected = ".v.\r\n" +
                          "M .\r\n" +
                          "..=\r\n";
        assertEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanFacingDown_When_ConvertingToString_Return_StringOfBoardWithPacmanFacingDown() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.FOOD), new Tile(GameObject.PACMAN), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)}
        });
        GameState gameState = new GameState(board);
        gameState.setCurrentAction(GameAction.DOWN);
        OutputAdaptor outputAdaptor = new OutputAdaptor();
        String result = outputAdaptor.gameStateToString(gameState);
        String expected = ".^.\r\n" +
                          ". .\r\n" +
                          "...\r\n";
        assertEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanFacingLeft_When_ConvertingToString_Return_StringOfBoardWithPacmanFacingLeft() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.FOOD), new Tile(GameObject.PACMAN), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)}
        });
        GameState gameState = new GameState(board);
        gameState.setCurrentAction(GameAction.LEFT);
        OutputAdaptor outputAdaptor = new OutputAdaptor();
        String result = outputAdaptor.gameStateToString(gameState);
        String expected = ".>.\r\n" +
                ". .\r\n" +
                "...\r\n";
        assertEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanFacingRight_When_ConvertingToString_Return_StringOfBoardWithPacmanFacingRight() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.FOOD), new Tile(GameObject.PACMAN), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)}
        });
        GameState gameState = new GameState(board);
        gameState.setCurrentAction(GameAction.RIGHT);
        OutputAdaptor outputAdaptor = new OutputAdaptor();
        String result = outputAdaptor.gameStateToString(gameState);
        String expected = ".<.\r\n" +
                ". .\r\n" +
                "...\r\n";
        assertEquals(expected, result);
    }
}
