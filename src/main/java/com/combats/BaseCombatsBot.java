package com.combats;

import com.codeborne.selenide.WebDriverRunner;
import com.combats.pages.LoginPage;
import com.combats.pages.StartPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static com.codeborne.selenide.Configuration.*;
import static java.lang.Thread.sleep;

public class BaseCombatsBot {

    /*
     * command for launch not compiled from console:
     * mvn exec:java -Dexec.mainClass="com.combats.GameCombatsBot" -Dlogin=login -Dpassword=password
     * -DtelegramAPI=telegramAPI -Dpet=yes/no -Dheadless=true/false
     *
     * command for launch Combats.jar from console:
     * java -Dlogin=login -Dpassword=password -Dpet=yes/no -Dheadless=true/false -jar Combats-version.jar
     *
     */

    static int getCurrentTime(){
        SimpleDateFormat parser = new SimpleDateFormat("HH");
        return Integer.parseInt(parser.format(new Date()));
    }

    static void preparation(boolean headlessValue) {
        if (!headlessValue) {
            startMaximized = true;
            holdBrowserOpen = true;
        } else {
            browserSize = "1600x900";
        }
        browser = "chrome";
        headless = headlessValue;
        savePageSource = false;
        reportsFolder = "fails";
        timeout = 20000;

        WebDriverManager.chromedriver().setup();
    }

    static void loginInGame(String login, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.enterToMainPage()
                .login(login, password);
    }

    static void fightOfChaos(String pet, String telegramAPI) {
        StartPage startPage = new StartPage();
        startPage.moveInTheCity()
                .enterToChaos()
                .fight(pet, telegramAPI);
    }

    static void walkingDownTheDungeons(String pet, String telegramAPI) {
        StartPage startPage = new StartPage();
        startPage.moveInTheDungeon()
                .testInTheDungeon()
                .fight(pet, telegramAPI);
    }

    static void end() {
        WebDriverRunner.getWebDriver().quit();
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

