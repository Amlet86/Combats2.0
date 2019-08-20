package com.combats.be;

import static com.combats.utils.Properties.getTypeOfGame;
import static com.combats.utils.Properties.isHeadless;
import static com.combats.utils.Utils.hasGameTime;

/**
 * Set System properties for configure game
 */
public class TopLevelLogic extends BaseLevelLogic {

    public void game() {
        startBrowser();
        loginInGame();
        checkSuccessLoginAndWriteUserData();
        while (hasGameTime()) {
            battles();
        }
        endBrowser();
    }

    private void startBrowser() {
        new ConfigBrowser(isHeadless());
    }

    private void battles() {
        if (getTypeOfGame())
            fightOfChaos();
        else
            fightOfDungeons();
    }

    private void endBrowser() {
        quitWebDriver();
    }

}