public class Main {
    public static void main(String[] args) {
        IInputService inputService = new ConsoleInputService();
        IOutputService outputService = new ConsoleOutputService();
        IMonsterController monsterController = new RandomMonsterController();

        ((ConsoleInputService)inputService).setConsoleToRawMode();
        Game game = new Game(inputService, outputService, monsterController);
        game.play();
        ((ConsoleInputService)inputService).setConsoleToCookedMode();
    }
}
