public class StubMonsterController implements IMonsterController {

    private Direction directionToReturn;

    public StubMonsterController(Direction directionToReturn) {
        this.directionToReturn = directionToReturn;
    }

    @Override
    public Direction getNextDirection(Board board, Position currentPosition) {
        return this.directionToReturn;
    }
}
