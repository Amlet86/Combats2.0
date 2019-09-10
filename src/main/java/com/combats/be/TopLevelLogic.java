package com.combats.be;

import static com.combats.utils.MapNavigator.prepareRoadFile;
import static com.combats.utils.Properties.getTypeOfGame;
import static com.combats.utils.Properties.isHeadless;
import static com.combats.utils.Utils.hasGameTime;

public class TopLevelLogic extends BaseLevelLogic {

    public void game() {
        startBrowser();
        loginInGame();
        checkSuccessLoginAndWriteUserData();
        prepareRoadFile();
        while (hasGameTime()) {
            actionsInGame();
        }
        endBrowser();
    }

    private void startBrowser() {
        new ConfigBrowser(isHeadless());
    }

    private void actionsInGame() {
        if (getTypeOfGame())
            PvP();
        else
            PvE();
    }

    private void endBrowser() {
        quitWebDriver();
    }

}