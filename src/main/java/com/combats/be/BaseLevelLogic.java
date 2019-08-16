package com.combats.be;

import com.codeborne.selenide.WebDriverRunner;
import com.combats.be.pages.LoginPage;
import com.combats.be.pages.StartPage;

class BaseLevelLogic {

    static void loginInGame(String login, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.enterToMainPage()
                .login(login, password);
    }

    static void fightOfChaos() {
        StartPage startPage = new StartPage();
        startPage.moveInTheCity()
                .enterToChaos()
                .fight();
    }

    static void walkingDownTheDungeons() {
        StartPage startPage = new StartPage();
        startPage.moveInTheDungeon()
                .testInTheDungeon()
                .fight();
    }

    static void end() {
        WebDriverRunner.getWebDriver().quit();
    }

}

