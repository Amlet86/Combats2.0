package com.combats.utils;

import java.util.Date;

public class Properties {

    private static boolean headless;
    private static String userLogin;
    private static String userPassword;
    private static boolean typeOfGame;
    private static boolean pet;
    private static Date endTimeOfTheGame = new Date();
    private static String telegramBotName;
    private static String telegramBotToken;
    private static String telegramChatId;

    public static boolean isHeadless() {
        return headless;
    }

    public static void setHeadless(boolean headless) {
        Properties.headless = headless;
    }

    public static String getUserLogin() {
        return userLogin;
    }

    public static void setUserLogin(String userLogin) {
        Properties.userLogin = userLogin;
    }

    public static String getUserPassword() {
        return userPassword;
    }

    public static void setUserPassword(String userPassword) {
        Properties.userPassword = userPassword;
    }

    public static boolean getTypeOfGame() {
        return typeOfGame;
    }

    public static void setTypeOfGame(boolean typeOfGame) {
        Properties.typeOfGame = typeOfGame;
    }

    public static boolean getPet() {
        return pet;
    }

    public static void setPet(boolean pet) {
        Properties.pet = pet;
    }

    public static Date getEndTimeOfTheGame() {
        return endTimeOfTheGame;
    }

    public static void setEndTimeOfTheGame(Object hours, Object minutes) {
        endTimeOfTheGame.setHours(Integer.parseInt(hours.toString()));
        endTimeOfTheGame.setMinutes(Integer.parseInt(minutes.toString()));
    }

    public static String getTelegramBotName() {
        return telegramBotName;
    }

    public static void setTelegramBotName(String telegramBotName) {
        Properties.telegramBotName = telegramBotName;
    }

    public static String getTelegramBotToken() {
        return telegramBotToken;
    }

    public static void setTelegramBotToken(String telegramBotToken) {
        Properties.telegramBotToken = telegramBotToken;
    }

    public static String getTelegramChatId() {
        return telegramChatId;
    }

    public static void setTelegramChatId(String telegramChatId) {
        Properties.telegramChatId = telegramChatId;
    }


}
