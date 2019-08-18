package com.combats.be;

import static com.combats.Properties.getTypeOfGame;
import static com.combats.Properties.isHeadless;
import static com.combats.Utils.hasGameTime;
import static com.combats.Utils.waiting;

/**
 * Set System properties for configure game
 */
public class TopLevelLogic extends BaseLevelLogic {

    public void game() {
        while (hasGameTime()) {
            startBrowser();
            login();
            battles();
        }
        endBrowser();
    }

    private void startBrowser() {
        new ConfigBrowser(isHeadless());
    }

    private void login() {
        loginInGame();
    }

    private void battles() {
        if (getTypeOfGame()) {
            fightOfChaos();
            waiting(220, 240);
        } else
            walkingDownTheDungeons();
    }

    private void endBrowser() {
        quitWebDriver();
    }

}