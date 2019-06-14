package com.combats;

import static java.lang.Boolean.parseBoolean;

public class GameCombatsBot extends BaseCombatsBot {

    public void startBE() {

        String login = System.getProperty("login");
        String password = System.getProperty("password");
        String typeOfGame = (System.getProperty("typeOfGame") != null) ? System.getProperty("typeOfGame") : "chaos";
        String telegramAPI = (System.getProperty("telegramAPI") != null) ? System.getProperty("telegramAPI") : "null";
        String pet = (System.getProperty("pet") != null) ? System.getProperty("pet") : "no";
        boolean headless = (System.getProperty("headless") != null) ? parseBoolean(System.getProperty("headless")) : true;

        preparation(headless);
        loginInGame(login, password);
        while (getCurrentTime() >= 7 && getCurrentTime() <= 23) {
            if (typeOfGame.equals("dungeon"))
                walkingDownTheDungeons(pet, telegramAPI);
            else {
                fightOfChaos(pet, telegramAPI);
                waiting(180, 240);
            }
        }
        end();
    }
}