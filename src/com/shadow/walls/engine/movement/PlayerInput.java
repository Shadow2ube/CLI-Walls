package com.shadow.walls.engine.movement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayerInput {
    public static EPlayerInput getIn() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in = reader.readLine();

        EPlayerInput input = switch (in) {
            case "w" -> EPlayerInput.UP;
            case "a" -> EPlayerInput.LEFT;
            case "s" -> EPlayerInput.DOWN;
            case "d" -> EPlayerInput.RIGHT;
            case "r" -> EPlayerInput.RESET;
            default -> EPlayerInput.RETRYIN;
        };

        if(input == EPlayerInput.RETRYIN) {
            input = getIn();
        }
        return input;
    }

    public static char getYN() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in = reader.readLine();
        char cin;
        switch (in) {
            case "Y", "y", "yes", "Yes", "YEs", "YES", "yES", "yeS", "YeS" -> cin = 'y';
            case "N", "n", "NO", "No", "nO", "no" -> cin = 'n';
            default -> {
                cin = 't';
                System.out.println("That's not an answer!");
                System.out.println("Usage: { yes / y / no / n }");
            }
        }

        if(cin == 't') {
            cin = getYN();
        }

        return cin;
    }
}
