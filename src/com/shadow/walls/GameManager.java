package com.shadow.walls;

import com.shadow.walls.engine.movement.EPlayerInput;
import com.shadow.walls.engine.movement.MoveHandler;
import com.shadow.walls.engine.movement.PlayerInput;
import com.shadow.walls.levels.LevelObject;

import java.io.IOException;

import static com.shadow.walls.Walls.*;

public class GameManager {
    public static boolean gameIsDone = false;
    public static void Start() throws IOException, InterruptedException {
        currentLevel = 0;

        // region Start

        print("Welcome to Walls!", 100);
        print("Before we start, are you new?", 100);
        char in = PlayerInput.getYN();

        switch (in) {
            case 'y' -> startTutorial();
            case'n' -> startMain(false);
        }

        // endregion
    }

    public static void startTutorial() throws IOException, InterruptedException {
        print("Okay, since you're new here, I'll help you out.", 2000);
        print("To get a grasp on things before you go off on you're own,", 2500);
        print("We'll  start with a simple level.", 2000);
        print("Like this!", 0);

        levels.get(currentLevel).print();

        print("Now the object of the game is simple.", 2000);
        print("Get to the Star.", 1500);
        print("The controls are simple", 250);
        print("   W   \n A * D\n   S\n\n R is to reset", 2000);
        print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nNow you try getting to the goal...", 250);

        levels.get(currentLevel).print();

        while (!levelIsDone()) {
            EPlayerInput input = PlayerInput.getIn();
            MoveHandler.movePlayer(input);

            levels.get(currentLevel).print();
        }

        finishLevel();

        print("Easy right?", 2000);
        print("Not really...", 2000);
        print("Now we get to the real game.", 2000);
        print("As the name of this game suggests, this game has com.shadow.walls.", 2000);
        print("Like these!");

        keyLevels.get(currentLevel).print();

        print(2000, "Now. since the creator just made a super simple puzzle game, he was sad.", 2000);
        print("So, com.shadow.walls are now temporarily invisible...", 2000);
        print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nPoof!");

        levels.get(currentLevel).print();

        print(2000, "As you move, the world is revealed to you!");
        print("Try this level.");

        levels.get(currentLevel).print();

        while (!levelIsDone()) {
            EPlayerInput input = PlayerInput.getIn();
            MoveHandler.movePlayer(input);

            levels.get(currentLevel).print();
        }

        finishLevel();

        print("That's all for the tutorial,\nthanks for downloading and enjoy!", 2000);

        startMain(true);
    }

    public static void startMain(boolean fromTutorial) throws IOException {
        if(!fromTutorial) {
            print("I guess you don't need me.");
            print("I'll be taking my leave now");
            print("Enjoy, I guess :(...");
        }

        levels.get(currentLevel).print();
        while (!gameIsDone) {
            if (currentLevel == Const.LevelAmount - 1) {
                finishGame();
                gameIsDone = true;
                return;
            }
            else if (levelIsDone()) {
                finishLevel();
                print("Level" + currentLevel);
                levels.get(currentLevel).print();
            }

            EPlayerInput input = PlayerInput.getIn();
            MoveHandler.movePlayer(input);

            print("Level" + currentLevel);
            levels.get(currentLevel).print();
        }
    }

    public static boolean levelIsDone() {
        if (levels.get(currentLevel).playerX == keyLevels.get(currentLevel).goalX) {
            return levels.get(currentLevel).playerY == keyLevels.get(currentLevel).goalY;
        }

        return false;
    }

    public static void finishLevel() {
        currentLevel += 1;
        MoveHandler.showAround(levels.get(currentLevel).playerX, levels.get(currentLevel).playerY, levels.get(currentLevel).get());
    }

    private static void finishGame() {
        /* TODO: below is a placeholder; remove later */
        LevelObject nlvl = new LevelObject();
        nlvl.fill('#');
        nlvl.print();
        /* TODO: above is a placeholder; remove later */
    }

    private static void print(String out) {
        System.out.println(out);
    }
    private static void print(String out, int wait) throws InterruptedException {
        System.out.println(out);
        Thread.sleep(wait);
    }
    private static void print(int wait, String out) throws InterruptedException {
        Thread.sleep(wait);
        System.out.println(out);
    }
    private static void print(int i, String s, int j) throws InterruptedException {
        Thread.sleep(i);
        System.out.println(s);
        Thread.sleep(j);
    }
    private static void print(String s,int wait, boolean isLine) throws InterruptedException {
        if(isLine)
            System.out.println(s);
        else
            System.out.print(s);

        Thread.sleep(wait);
    }
}
