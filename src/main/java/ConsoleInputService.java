import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputService implements IInputService{
    private static final int EXIT_CODE = 3;
    private static final int W_CODE = 119;
    private static final int S_CODE = 115;
    private static final int A_CODE = 97;
    private static final int D_Code = 100;

    private InputStreamReader consoleInputStream = new InputStreamReader(System.in);
    private BufferedReader bufferedConsoleInputReader = new BufferedReader(consoleInputStream);

    @Override
    public Direction getUserInputDirection() {
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
                this.setConsoleToCookedMode();
                System.out.print("Exiting\r\n");
                System.exit(0);
            case W_CODE:
                return Direction.UP;
            case S_CODE:
                return Direction.DOWN;
            case A_CODE:
                return Direction.LEFT;
            case D_Code:
                return Direction.RIGHT;
            default :
                return null;
        }
    }

    public void setConsoleToRawMode() {
        try {
            String[] knockIntoRawMode = {"/bin/sh", "-c", "stty raw </dev/tty"};
            Runtime.getRuntime().exec(knockIntoRawMode).waitFor();
        } catch (InterruptedException | IOException e) {
            System.err.println("Error: Unable to set console to raw mode");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void setConsoleToCookedMode() {
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
