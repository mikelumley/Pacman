public class Main {
    public static void main(String[] args) {
        IInputService inputService = new ConsoleInputService();
        IOutputService outputService = new ConsoleOutputService();
        IMonsterController monsterController = new RandomMonsterController();

        Game game = new Game(inputService, outputService, monsterController);
        int score = game.play();

        System.out.println("You won!");
        System.out.println("Your score was: " + score);
    }
}
