package com.combats.be;

import static com.combats.Properties.*;
import static com.combats.be.Utils.getCurrentTime;
import static com.combats.be.Utils.waiting;

/**
 * Set System properties for configure game
 */
public class TopLevelLogic extends BaseLevelLogic {

    public void startBrowser() {
        new ConfigBrowser(isHeadless());
    }

    public void startGame() {
        loginInGame(getUserLogin(), getUserPassword());
        while (getCurrentTime() <= 23) {
            if (getTypeOfGame()) {
                fightOfChaos();
                waiting(220, 240);
            } else
                walkingDownTheDungeons();
        }
        end();
    }

}