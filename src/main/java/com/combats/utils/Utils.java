package com.combats.utils;

import com.codeborne.selenide.SelenideElement;

import java.util.Date;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$$;
import static com.combats.utils.Properties.getEndTimeOfTheGame;
import static java.lang.Double.parseDouble;
import static java.lang.Thread.sleep;

public class Utils {

    public static boolean hasGameTime() {
        if(getEndTimeOfTheGame().getHours() != 0 && getEndTimeOfTheGame().getMinutes() != 0)
            return new Date().before(getEndTimeOfTheGame());
        else
            return true;
    }

    public static int chooseRadioWithMinTime() {
        int minTime = -1;
        int iterator = 0;
        double tmpTime = 5;
        try {
            for (SelenideElement element : $$("[action='zayavka.pl'] > .dsc > i > b")) {
                double time = parseDouble(element.getText());
                if (time <= tmpTime) {
                    tmpTime = time;
                    minTime = iterator;
                }
                iterator++;
            }
            return minTime;
        } catch (NumberFormatException e) {
            e.getStackTrace();
            return -1;
        }
    }

    private static int getRandomMultiplyThousand(int from, int to) {
        return new Random().nextInt(to * 1000 - from * 1000) + from * 1000;
    }

    public static void waitAboutSomeSeconds(int seconds){
        int minWaitTime = (int) (seconds * 1000 / 1.1);
        int maxWaitTime = (int) (seconds * 1000 / 0.9);
        int exactWaitTime = new Random().nextInt(maxWaitTime - minWaitTime) + minWaitTime;
        try {
            sleep(exactWaitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
