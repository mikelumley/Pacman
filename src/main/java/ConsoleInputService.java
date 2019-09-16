import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputService {
    private InputStreamReader consoleInputStream = new InputStreamReader(System.in);
    private BufferedReader bufferedConsoleInputReader = new BufferedReader(consoleInputStream);
    private Direction pacmanDirection = Direction.UP;

    public ConsoleInputService() {
        try {
            String[] knockIntoRawMode = {"/bin/sh", "-c", "stty raw </dev/tty"};
            Runtime.getRuntime().exec(knockIntoRawMode).waitFor();
        } catch (InterruptedException | IOException e) {
            System.err.println("Error: Unable to set console to raw mode");
            e.printStackTrace();
        }
    }

    public Direction getDirection() {
        int characterCodeCode = 0;
        try {
            if (bufferedConsoleInputReader.ready())
                characterCodeCode = bufferedConsoleInputReader.read();
        } catch (IOException e) {
            System.err.println("Error: Unable to read input from console");
            e.printStackTrace();
        }

        switch (characterCodeCode) {
            case 3 :
                this.setConsoleToCookedMode();
                System.out.print("Exiting\r\n");
                System.exit(0);
            case 119 :
                this.pacmanDirection = Direction.UP;
                break;
            case 115 :
                this.pacmanDirection = Direction.DOWN;
                break;
            case 97 :
                this.pacmanDirection = Direction.LEFT;
                break;
            case 100 :
                this.pacmanDirection = Direction.RIGHT;
                break;
        }
        return this.pacmanDirection;
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
