import com.pacman.core.GameAction;
import com.pacman.input.InputAdaptor;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputAdaptorTests {

    @Test
    public void Given_CharacterCode3_When_ConvertingToAction_Return_ExitAction() {
        InputAdaptor inputAdaptor = new InputAdaptor();
        GameAction result = inputAdaptor.inputToAction(3);
        assertEquals(GameAction.EXIT, result);
    }

    @Test
    public void Given_CharacterCode119_When_ConvertingToAction_Return_UpAction() {
        InputAdaptor inputAdaptor = new InputAdaptor();
        GameAction result = inputAdaptor.inputToAction(119);
        assertEquals(GameAction.UP, result);
    }

    @Test
    public void Given_CharacterCode115_When_ConvertingToAction_Return_DownAction() {
        InputAdaptor inputAdaptor = new InputAdaptor();
        GameAction result = inputAdaptor.inputToAction(115);
        assertEquals(GameAction.DOWN, result);
    }

    @Test
    public void Given_CharacterCode97_When_ConvertingToAction_Return_LeftAction() {
        InputAdaptor inputAdaptor = new InputAdaptor();
        GameAction result = inputAdaptor.inputToAction(97);
        assertEquals(GameAction.LEFT, result);
    }

    @Test
    public void Given_CharacterCode100_When_ConvertingToAction_Return_RightAction() {
        InputAdaptor inputAdaptor = new InputAdaptor();
        GameAction result = inputAdaptor.inputToAction(100);
        assertEquals(GameAction.RIGHT, result);
    }

    @Test
    public void Given_CharacterCode80_When_ConvertingToAction_Return_NoInputAction() {
        InputAdaptor inputAdaptor = new InputAdaptor();
        GameAction result = inputAdaptor.inputToAction(80);
        assertEquals(GameAction.NO_INPUT, result);
    }
}
