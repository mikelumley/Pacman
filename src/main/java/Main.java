import com.pacman.core.*;
import com.pacman.input.ConsoleKeyboardInputService;
import com.pacman.input.IInputService;
import com.pacman.output.ConsoleOutputService;
import com.pacman.output.IOutputService;

public class Main {
    public static void main(String[] args) {
        IInputService inputService = new ConsoleKeyboardInputService();
        IOutputService outputService = new ConsoleOutputService();
        IGameController gameController = new GameController();
        IMonsterController monsterController = new RandomMonsterController();

        try {
            inputService.openInputService();

            Game game = new Game(inputService, outputService, gameController, monsterController);
            int finalScore = game.play();
            outputService.displayFinalScore(finalScore);
        } finally {
            inputService.closeInputService();
        }
    }
}
