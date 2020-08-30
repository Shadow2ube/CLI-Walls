package com.shadow.walls.levels;

import com.shadow.walls.Const;

public class LevelObject {
    private char[][] level;
    public int playerX;
    public int playerY;
    public int goalX;
    public int goalY;

    public LevelObject(char[][] l) { level = l; findPlayer(); findGoal(); }

    public LevelObject() { level = new char[Const.HEIGHT][Const.LENGTH]; }

    /**
     * Prints this map
     */
    public void print() {
        for (int i = 0; i < Const.HEIGHT; i++) {
            for (int j = 0; j < Const.LENGTH; j++) {
                System.out.print(level[i][j]);
            }
            System.out.println();
        }
    }

    public void hide() {
        for (int i = 0; i < Const.HEIGHT; i++) {
            for (int j = 0; j < Const.LENGTH; j++) {
                if (level[i][j] == '#') {
                    level[i][j] = ' ';
                }
            }
        }
    }

    //region "get" Methods

    /**
     * Gets the level as a 2D array
     * @return 2D char array (char[][])
     */
    public char[][] get() {
        return level;
    }

    /**
     * Gets specific object in level
     * @param x Column in level
     * @param y Row in level
     * @return 2D char array (char[][])
     */
    public char get(int x, int y) {
        return level[x][y];
    }

    /**
     * Gets specific row in level
     * @param x Column of level
     * @return char array (char[])
     */
    public char[] get(int x) {
        return level[x];
    }

    //endregion

    //region "set" Methods

    public void fill(char a) {
        for (int i = 0; i < Const.HEIGHT; i++) {
            for (int j = 0; j < Const.LENGTH; j++) {
                if (i == 0 || i == 7) {
                    level[i][j] = '-';
                }
                else if (j == 0 || j == 31) {
                    level[i][j] = '|';
                }
                else {
                    level[i][j] = a;
                }
            }
        }
    }

    public void set(char[][] a) { level = a; findPlayer(); findGoal(); }

    /**
     * Changes a specific character to the defined one
     * @param x Column in level
     * @param y Row in level
     * @param a Character to replacce with
     */
    public void set(int x, int y, char a) {
        level[x][y] = a;
    }

    /**
     * Changes a specific row to the defined one
     * @param x Column in level
     * @param a Row in level
     */
    public void set(int x, char[] a) {
        level[x] = a;
    }

    //endregion

    //region Player Methods

    public void removePlayer() {
        for (int i = 0; i < Const.HEIGHT; i++) {
            for (int j = 0; j < Const.LENGTH; j++) {
                if (level[i][j] == 'A') {
                    level[i][j] = ' ';
                }
            }
        }
    }

    public void findPlayer() {
        for (int i = 0; i < Const.HEIGHT; i++) {
            for (int j = 0; j < Const.LENGTH; j++) {
                if (level[i][j] == 'A') {
                    playerX = i;
                    playerY = j;
                }
            }
        }
    }

    public void findGoal() {
        for (int i = 0; i < Const.HEIGHT; i++) {
            for (int j = 0; j < Const.LENGTH; j++) {
                if(level[i][j] == '*') {
                    goalX = i;
                    goalY = j;
                }
            }
        }
    }

    //endregion
}
