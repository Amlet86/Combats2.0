package com.combats.be;

import com.codeborne.selenide.WebDriverRunner;
import com.combats.pages.LoginPage;
import com.combats.pages.StartPage;

import static com.combats.Properties.getUserLogin;
import static com.combats.Properties.getUserPassword;
import static com.combats.Utils.waiting;

class BaseLevelLogic {

    static void loginInGame() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterToMainPage()
                .login(getUserLogin(), getUserPassword());
    }

    static void fightOfChaos() {
        StartPage startPage = new StartPage();
        startPage.moveInTheCity()
                .enterToChaos()
                .fight();
        waiting(300, 310);
    }

    static void walkingDownTheDungeons() {
        StartPage startPage = new StartPage();
        startPage.moveInTheDungeon()
                .testInTheDungeon()
                .fight();
    }

    static void quitWebDriver() {
        if (WebDriverRunner.hasWebDriverStarted())
            WebDriverRunner.getWebDriver().quit();
    }

}

