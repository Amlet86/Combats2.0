package com.combats.be;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Utils {

    static int getCurrentTime(){
        SimpleDateFormat parser = new SimpleDateFormat("HH");
        return Integer.parseInt(parser.format(new Date()));
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

}
