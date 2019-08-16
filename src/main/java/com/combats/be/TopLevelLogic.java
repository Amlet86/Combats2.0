package com.combats.be;

import static com.combats.Properties.*;
import static com.combats.Utils.getCurrentTime;
import static com.combats.Utils.waiting;

/**
 * Set System properties for configure game
 */
public class TopLevelLogic extends BaseLevelLogic {

    public void game(){
        startBrowser();
        login();
        battles();
        endBrowser();
    }

    private void startBrowser() {
        new ConfigBrowser(isHeadless());
    }

    private void login() {
        loginInGame();
    }

    private void battles(){
        while (getCurrentTime() <= 23) {
            if (getTypeOfGame()) {
                fightOfChaos();
                waiting(220, 240);
            } else
                walkingDownTheDungeons();
        }
    }

    private void endBrowser() {
        quitWebDriver();
    }

}