package com.pacman.input;

import com.pacman.core.GameAction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleKeyboardInputService implements IInputService{
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
    public GameAction getUserInputAction() {
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
                return GameAction.EXIT;
            case W_CODE:
                return GameAction.UP;
            case S_CODE:
                return GameAction.DOWN;
            case A_CODE:
                return GameAction.LEFT;
            case D_CODE:
                return GameAction.RIGHT;
            default:
                return GameAction.NO_INPUT;
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
