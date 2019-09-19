public class StubMonsterController implements IMonsterController {

    private UserAction userActionToReturn;

    public StubMonsterController(UserAction userActionToReturn) {
        this.userActionToReturn = userActionToReturn;
    }

    @Override
    public UserAction getNextDirection(Board board, Position currentPosition) {
        return this.userActionToReturn;
    }
}
