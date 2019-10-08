package com.combats.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapNavigator {

    private static final String ROAD_SUN_CITY_FILE_PATH = "SunCityRoadToTheThirthLevel.txt";
    public static final ArrayList<String> ROAD_MAP = new ArrayList<>();

    public static void prepareRoadFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(ROAD_SUN_CITY_FILE_PATH))) {
            while (br.ready())
                ROAD_MAP.add(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
