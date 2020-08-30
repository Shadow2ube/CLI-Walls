package com.shadow.walls.engine.movement;

import static com.shadow.walls.Walls.*;

public class MoveHandler {
    // region Player Methods

    public static void movePlayer(EPlayerInput in) {
        switch (in) {
            case UP -> up();
            case DOWN -> down();
            case LEFT -> left();
            case RIGHT -> right();
            case RESET -> reset();
        }
    }

    private static void movePlayer(int x, int y) {
        int lastX = levels.get(currentLevel).playerX;
        int lastY = levels.get(currentLevel).playerY;
        char[][] klvl = keyLevels.get(currentLevel).get();
        char[][] lvl = levels.get(currentLevel).get();

        if(klvl[x][y] == ' ' || klvl[x][y] == '*') {
            lvl[x][y] = 'A';
            lvl[lastX][lastY] = ' ';

        } else return;

        showAround(x, y, lvl);

        levels.get(currentLevel).set(lvl);
    }

    public static void showAround(int x, int y, char[][] lvl) {
        char[][] klvl = keyLevels.get(currentLevel).get();
        lvl[x - 1][y - 1] = klvl[x - 1][y - 1];

        /* Lower Section */
        if(lvl[x + 1][y + 1] != 'A') lvl[x + 1][y + 1]  = klvl[x + 1][y + 1];
        if(lvl[x + 1][y] != 'A') lvl[x + 1][y] = klvl[x + 1][y];
        if(lvl[x + 1][y - 1] != 'A') lvl[x + 1][y - 1] = klvl[x + 1][y - 1];

        /* Mid Section */
        if(lvl[x][y + 1] != 'A') lvl[x][y + 1] = klvl[x][y + 1];
        if(lvl[x][y - 1] != 'A') lvl[x][y - 1] = klvl[x][y - 1];

        /* Upper Section */
        if(lvl[x - 1][y + 1] != 'A') lvl[x - 1][y + 1] = klvl[x - 1][y + 1];
        if(lvl[x - 1][y] != 'A') lvl[x - 1][y] = klvl[x - 1][y];
        if(lvl[x - 1][y - 1] != 'A') lvl[x - 1][y - 1] = klvl[x - 1][y - 1];

        levels.get(currentLevel).set(lvl);
    }

    // endregion

    //region Movement Methods

    public static void up() {
        System.out.println("w");
        movePlayer(levels.get(currentLevel).playerX - 1, levels.get(currentLevel).playerY);
    }
    public static void down() {
        System.out.println("s");
        movePlayer(levels.get(currentLevel).playerX + 1, levels.get(currentLevel).playerY);
    }
    public static void left() {
        System.out.println("a");
        movePlayer(levels.get(currentLevel).playerX, levels.get(currentLevel).playerY - 1);
    }
    public static void right() {
        System.out.println("d");
        movePlayer(levels.get(currentLevel).playerX, levels.get(currentLevel).playerY + 1);
    }
    /* TODO: Sort out resetting level */
    public static void reset() {
        System.out.println("r");
    }

    //endregion
}
