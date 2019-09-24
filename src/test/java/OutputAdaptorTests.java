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
    public void Given_BoardWithPacmanFacingUpAndMouthOpen_When_ConvertingToString_Return_StringOfBoardWithPacmanMouthOpenFacingUp() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.FOOD), new Tile(GameObject.PACMAN), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)}
        });
        GameState gameState = new GameState(board);
        gameState.setCurrentAction(GameAction.UP);
        gameState.setPacmanMouthOpen(true);
        OutputAdaptor outputAdaptor = new OutputAdaptor();
        String result = outputAdaptor.gameStateToString(gameState);
        String expected = ".v.\r\n" +
                          ". .\r\n" +
                          "...\r\n";
        assertEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanFacingDownAndMouthOpen_When_ConvertingToString_Return_StringOfBoardWithPacmanFacingDown() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.FOOD), new Tile(GameObject.PACMAN), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)}
        });
        GameState gameState = new GameState(board);
        gameState.setCurrentAction(GameAction.DOWN);
        gameState.setPacmanMouthOpen(true);
        OutputAdaptor outputAdaptor = new OutputAdaptor();
        String result = outputAdaptor.gameStateToString(gameState);
        String expected = ".^.\r\n" +
                          ". .\r\n" +
                          "...\r\n";
        assertEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanFacingLeftAndMouthOpen_When_ConvertingToString_Return_StringOfBoardWithPacmanFacingLeft() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.FOOD), new Tile(GameObject.PACMAN), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)}
        });
        GameState gameState = new GameState(board);
        gameState.setCurrentAction(GameAction.LEFT);
        gameState.setPacmanMouthOpen(true);
        OutputAdaptor outputAdaptor = new OutputAdaptor();
        String result = outputAdaptor.gameStateToString(gameState);
        String expected = ".>.\r\n" +
                          ". .\r\n" +
                          "...\r\n";
        assertEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanFacingRightAndMouthOpen_When_ConvertingToString_Return_StringOfBoardWithPacmanFacingRight() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.FOOD), new Tile(GameObject.PACMAN), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)}
        });
        GameState gameState = new GameState(board);
        gameState.setCurrentAction(GameAction.RIGHT);
        gameState.setPacmanMouthOpen(true);
        OutputAdaptor outputAdaptor = new OutputAdaptor();
        String result = outputAdaptor.gameStateToString(gameState);
        String expected = ".<.\r\n" +
                          ". .\r\n" +
                          "...\r\n";
        assertEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanFacingUpAndMouthClosed_When_ConvertingToString_Return_StringOfBoardWithPacmanMouthClosedFacingUp() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.FOOD), new Tile(GameObject.PACMAN), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)}
        });
        GameState gameState = new GameState(board);
        gameState.setCurrentAction(GameAction.UP);
        gameState.setPacmanMouthOpen(false);
        OutputAdaptor outputAdaptor = new OutputAdaptor();
        String result = outputAdaptor.gameStateToString(gameState);
        String expected = ".|.\r\n" +
                          ". .\r\n" +
                          "...\r\n";
        assertEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanFacingDownAndMouthClosed_When_ConvertingToString_Return_StringOfBoardWithPacmanMouthClosedFacingDown() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.FOOD), new Tile(GameObject.PACMAN), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)}
        });
        GameState gameState = new GameState(board);
        gameState.setCurrentAction(GameAction.DOWN);
        gameState.setPacmanMouthOpen(false);
        OutputAdaptor outputAdaptor = new OutputAdaptor();
        String result = outputAdaptor.gameStateToString(gameState);
        String expected = ".|.\r\n" +
                          ". .\r\n" +
                          "...\r\n";
        assertEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanFacingLeftAndMouthClosed_When_ConvertingToString_Return_StringOfBoardWithPacmanMouthClosedFacingLeft() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.FOOD), new Tile(GameObject.PACMAN), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)}
        });
        GameState gameState = new GameState(board);
        gameState.setCurrentAction(GameAction.LEFT);
        gameState.setPacmanMouthOpen(false);
        OutputAdaptor outputAdaptor = new OutputAdaptor();
        String result = outputAdaptor.gameStateToString(gameState);
        String expected = ".-.\r\n" +
                          ". .\r\n" +
                          "...\r\n";
        assertEquals(expected, result);
    }

    @Test
    public void Given_BoardWithPacmanFacingRightAndMouthClosed_When_ConvertingToString_Return_StringOfBoardWithPacmanMouthClosedFacingRight() {
        Board board = new Board(new Tile[][]{
                {new Tile(GameObject.FOOD), new Tile(GameObject.PACMAN), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(), new Tile(GameObject.FOOD)},
                {new Tile(GameObject.FOOD), new Tile(GameObject.FOOD), new Tile(GameObject.FOOD)}
        });
        GameState gameState = new GameState(board);
        gameState.setCurrentAction(GameAction.RIGHT);
        gameState.setPacmanMouthOpen(false);
        OutputAdaptor outputAdaptor = new OutputAdaptor();
        String result = outputAdaptor.gameStateToString(gameState);
        String expected = ".-.\r\n" +
                          ". .\r\n" +
                          "...\r\n";
        assertEquals(expected, result);
    }
}
