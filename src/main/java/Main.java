public class Main {
    public static void main(String[] args) {
        IInputService inputService = new ConsoleInputService();
        IMonsterController monsterController = new RandomMonsterController();

        Game game = new Game(inputService, monsterController);
        int score = game.play();

        System.out.println("You won!");
        System.out.println("Your score was: " + score);
    }
}
