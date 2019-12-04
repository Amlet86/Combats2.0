package com.combats.be;

import static com.combats.utils.MapNavigator.prepareRoadFile;
import static com.combats.utils.Properties.getTypeOfGame;
import static com.combats.utils.Properties.isHeadless;
import static com.combats.utils.Utils.hasGameTime;
import static com.combats.utils.Utils.waiting;

public class TopLevelLogic extends BaseLevelLogic {

    private void configurationBrowser() {
        new ConfigBrowser(isHeadless());
    }

    private void actionsInGame() {
        if (getTypeOfGame()) {
            PvP();
            waiting(300, 310);
        } else
            PvE();
    }

    private void endBrowser() {
        quitWebDriver();
    }

    public String game() {
        String endGameMessage = null;
        configurationBrowser();
        startBrowser();
        loginInGame();
        checkSuccessLoginAndWriteUserData();
        prepareRoadFile();
        while (hasGameTime()) {
            try {
                actionsInGame();
                endGameMessage = "There isn't error, the game's end because timeout.";
            } catch (Error e) {
                endGameMessage = e.getMessage();
                break;
            }
        }
        endBrowser();
        return endGameMessage;
    }

}