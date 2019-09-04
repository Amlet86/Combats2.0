package com.combats.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapNavigator {

    private static final String ROAD_SUN_CITY_FILE_PATH = "RoadOfSunCity.txt";
    public static final ArrayList<String> CURRENT_ROAD = new ArrayList<>();

    public static void prepaireRoadFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(ROAD_SUN_CITY_FILE_PATH))) {
            while (br.ready())
                CURRENT_ROAD.add(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
