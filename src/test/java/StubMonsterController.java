import com.pacman.core.Board;
import com.pacman.core.IMonsterController;
import com.pacman.core.Coordinates;
import com.pacman.core.GameAction;

public class StubMonsterController implements IMonsterController {

    private GameAction gameActionToReturn;

    public StubMonsterController(GameAction gameActionToReturn) {
        this.gameActionToReturn = gameActionToReturn;
    }

    @Override
    public GameAction getNextDirection(Board board, Coordinates currentPosition) {
        return this.gameActionToReturn;
    }
}
