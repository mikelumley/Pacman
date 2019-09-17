public class Main {
    public static void main(String[] args) {
        ConsoleInputService inputService = new ConsoleInputService();

        Game game = new Game(inputService);
        int score = game.play();

        System.out.println("You won!");
        System.out.println("Your score was: " + score);
    }
}
