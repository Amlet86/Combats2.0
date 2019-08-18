package com.combats.be;

import static com.combats.Properties.getTypeOfGame;
import static com.combats.Properties.isHeadless;
import static com.combats.Utils.hasGameTime;

/**
 * Set System properties for configure game
 */
public class TopLevelLogic extends BaseLevelLogic {

    public void game() {
        startBrowser();
        login();
        while (hasGameTime()) {
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
        if (getTypeOfGame())
            fightOfChaos();
        else
            walkingDownTheDungeons();
    }

    private void endBrowser() {
        quitWebDriver();
    }

}