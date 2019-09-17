import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputService implements IInputService{
    private InputStreamReader consoleInputStream = new InputStreamReader(System.in);
    private BufferedReader bufferedConsoleInputReader = new BufferedReader(consoleInputStream);

    public ConsoleInputService() {
        try {
            String[] knockIntoRawMode = {"/bin/sh", "-c", "stty raw </dev/tty"};
            Runtime.getRuntime().exec(knockIntoRawMode).waitFor();
        } catch (InterruptedException | IOException e) {
            System.err.println("Error: Unable to set console to raw mode");
            e.printStackTrace();
        }
    }

    @Override
    public Direction getUserInputDirection() {
        int characterCode = 0;
        try {
            if (bufferedConsoleInputReader.ready())
                characterCode = bufferedConsoleInputReader.read();
        } catch (IOException e) {
            System.err.println("Error: Unable to read input from console");
            e.printStackTrace();
        }

        switch (characterCode) {
            case 3 :
                this.setConsoleToCookedMode();
                System.out.print("Exiting\r\n");
                System.exit(0);
            case 119 :
                return Direction.UP;
            case 115 :
                return Direction.DOWN;
            case 97 :
                return Direction.LEFT;
            case 100 :
                return Direction.RIGHT;
            default :
                return null;
        }
    }

    public void setConsoleToCookedMode() {
        try {
            String[] knockIntoCookedMode = {"/bin/sh", "-c", "stty cooked </dev/tty"};
            Runtime.getRuntime().exec(knockIntoCookedMode).waitFor();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error: Unable to set console to cooked mode");
            e.printStackTrace();
        }
    }
 }
