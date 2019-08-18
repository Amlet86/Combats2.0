package com.combats;

import java.util.Date;
import java.util.Random;

import static com.combats.Properties.getEndTimeOfTheGame;
import static java.lang.Thread.sleep;

public class Utils {

    public static boolean hasGameTime() {
        if(getEndTimeOfTheGame().getHours() != 0 && getEndTimeOfTheGame().getMinutes() != 0)
            return new Date().before(getEndTimeOfTheGame());
        else
            return true;
    }

    private static int getRandomMultiplyThousand(int from, int to) {
        return new Random().nextInt(to * 1000 - from * 1000) + from * 1000;
    }

    public static int getRandomInt(int from, int to) {
        return new Random().nextInt(to - from) + from;
    }

    public static void waiting(int from, int to) {
        try {
            sleep(getRandomMultiplyThousand(from, to));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waiting(double fTime) {
        int iTime = (int) (fTime * 1000);
        try {
            sleep(iTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String[] getListHours() {
        String[] listHours = new String[24];
        for (int i = 0; i < 24; i++) {
            listHours[i] = String.valueOf(i);
        }
        return listHours;
    }

    public static String[] getListMinutes() {
        return new String[]{"00", "10", "20", "30", "40", "50"};
    }

}
