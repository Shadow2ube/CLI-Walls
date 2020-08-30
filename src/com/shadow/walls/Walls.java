package com.shadow.walls;

import com.shadow.walls.levels.LevelObject;
import com.shadow.walls.levels.Levels;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Walls {
    public static int currentLevel = 0;

    public static List<LevelObject> keyLevels = new ArrayList<>();
    public static List<LevelObject> levels = new ArrayList<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        Levels.loadLevels();
        GameManager.Start();
    }

    public static void cls() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
