package com.shadow.walls.levels;

import com.shadow.walls.Const;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import static com.shadow.walls.Walls.keyLevels;
import static com.shadow.walls.Walls.levels;

public class Levels {
    private static final Path levelJsonPath = FileSystems.getDefault().getPath("src/com/shadow/walls/levels/level.json").toAbsolutePath();

    @SuppressWarnings("unchecked")
    public static void loadLevels() {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(String.valueOf(levelJsonPath))) {
            Object obj = parser.parse(reader);

            JSONArray levelList = (JSONArray) obj;

            levelList.forEach(lvl -> parseLevel((JSONObject) lvl));

            levels.forEach(LevelObject::hide);
            keyLevels.forEach(LevelObject::removePlayer);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }


    private static void parseLevel(JSONObject level) {
        JSONObject levelObject = (JSONObject) level.get("level");
        char[][] klvl = new char[Const.HEIGHT][Const.LENGTH];
        char[][] lvl = new char[Const.HEIGHT][Const.LENGTH];

        for (int i = 0; i < Const.HEIGHT; i++) {
            String a = (String) levelObject.get("" + i);
            lvl[i] = a.toCharArray();
            klvl[i] = a.toCharArray();
        }

        keyLevels.add(new LevelObject(lvl));
        levels.add(new LevelObject(klvl));
    }
}