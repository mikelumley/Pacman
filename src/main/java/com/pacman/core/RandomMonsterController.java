package com.pacman.core;

import java.util.Random;

public class RandomMonsterController implements IMonsterController {

    private static final int NUMBER_OF_DIRECTIONS = 4;

    private Random random = new Random();

    @Override
    public GameAction getNextDirection(Board board, Coordinates currentPosition) {
        int randomNumber =  this.random.nextInt(NUMBER_OF_DIRECTIONS);
        switch (randomNumber) {
            default :
            case 0 :
                return GameAction.UP;
            case 1 :
                return GameAction.DOWN;
            case 2 :
                return GameAction.LEFT;
            case 3 :
                return GameAction.RIGHT;
        }
    }
}
