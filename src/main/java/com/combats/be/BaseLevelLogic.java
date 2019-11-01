package com.combats.be;

import com.codeborne.selenide.WebDriverRunner;
import com.combats.pages.CityPage;
import com.combats.pages.LoginPage;
import com.combats.utils.FileWorker;

import static com.combats.utils.Properties.getUserLogin;
import static com.combats.utils.Properties.getUserPassword;
import static com.combats.utils.Utils.waiting;

class BaseLevelLogic {

    void loginInGame() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterToMainPage()
            .login(getUserLogin(), getUserPassword());
    }

    void checkSuccessLoginAndWriteUserData() {
        if (!WebDriverRunner.getWebDriver().getTitle().equals("Произошла ошибка"))
            FileWorker.writeUserDataFile();
        else {
            waiting(3);
            quitWebDriver();
        }
    }

    void PvP() {
        CityPage cityPage = new CityPage();
        cityPage.exitFromBattle()
            .moveInTheCity()
            .enterToPvPBattle()
            .fight();
        waiting(300, 310);
    }

    void PvE() {
        CityPage cityPage = new CityPage();
        cityPage.exitFromBattle()
            .switchToTheDungeon()
            .walkOnTheDungeon()
            .fight();
    }

    void quitWebDriver() {
        if (WebDriverRunner.hasWebDriverStarted())
            WebDriverRunner.getWebDriver().quit();
    }

}

