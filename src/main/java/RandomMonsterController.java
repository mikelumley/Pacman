import java.util.Random;

public class RandomMonsterController implements IMonsterController {

    private Random random = new Random();
    @Override
    public Direction getNextDirection(Board board, Position currentPosition) {
        int randomNumber =  this.random.nextInt(4);
        switch (randomNumber) {
            default :
            case 0 :
                return Direction.UP;
            case 1 :
                return Direction.DOWN;
            case 2 :
                return Direction.LEFT;
            case 3 :
                return Direction.RIGHT;
        }
    }
}
