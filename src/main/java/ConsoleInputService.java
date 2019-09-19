import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputService implements IInputService{
    private static final int EXIT_CODE = 3;
    private static final int W_CODE = 119;
    private static final int S_CODE = 115;
    private static final int A_CODE = 97;
    private static final int D_CODE = 100;

    private InputStreamReader consoleInputStream = new InputStreamReader(System.in);
    private BufferedReader bufferedConsoleInputReader = new BufferedReader(consoleInputStream);

    @Override
    public void openInputService() {
        try {
            String[] knockIntoRawMode = {"/bin/sh", "-c", "stty raw </dev/tty"};
            Runtime.getRuntime().exec(knockIntoRawMode).waitFor();
        } catch (InterruptedException | IOException e) {
            System.err.println("Error: Unable to set console to raw mode");
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public UserAction getUserInputAction() {
        int characterCode = 0;
        try {
            if (bufferedConsoleInputReader.ready())
                characterCode = bufferedConsoleInputReader.read();
        } catch (IOException e) {
            System.err.println("Error: Unable to read input from console");
            e.printStackTrace();
            System.exit(1);
        }

        switch (characterCode) {
            case EXIT_CODE:
                return UserAction.EXIT;
            case W_CODE:
                return UserAction.UP;
            case S_CODE:
                return UserAction.DOWN;
            case A_CODE:
                return UserAction.LEFT;
            case D_CODE:
                return UserAction.RIGHT;
            default:
                return UserAction.NO_INPUT;
        }
    }

    @Override
    public void closeInputService() {
        try {
            String[] knockIntoCookedMode = {"/bin/sh", "-c", "stty cooked </dev/tty"};
            Runtime.getRuntime().exec(knockIntoCookedMode).waitFor();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error: Unable to set console to cooked mode");
            e.printStackTrace();
            System.exit(1);
        }
    }
 }
