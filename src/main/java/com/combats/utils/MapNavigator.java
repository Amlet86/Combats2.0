package com.combats.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapNavigator {

    private static final String ROAD_IN_A_DUNGEON_FILE_PATH = "maps/DemonsCityThroughTop.txt";
    public static ArrayList<String> roadMapList = new ArrayList<>();

    public static void prepareRoadFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(ROAD_IN_A_DUNGEON_FILE_PATH))) {
            while (br.ready())
                roadMapList.add(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
