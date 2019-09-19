import java.util.Random;

public class RandomMonsterController implements IMonsterController {

    private Random random = new Random();
    @Override
    public UserAction getNextDirection(Board board, Position currentPosition) {
        int randomNumber =  this.random.nextInt(4);
        switch (randomNumber) {
            default :
            case 0 :
                return UserAction.UP;
            case 1 :
                return UserAction.DOWN;
            case 2 :
                return UserAction.LEFT;
            case 3 :
                return UserAction.RIGHT;
        }
    }
}
