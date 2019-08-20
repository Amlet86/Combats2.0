package com.combats.be;

import com.codeborne.selenide.WebDriverRunner;
import com.combats.pages.LoginPage;
import com.combats.pages.StartPage;
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
            FileWorker.writeFile();
        else {
            waiting(3);
            quitWebDriver();
        }
    }

    void fightOfChaos() {
        StartPage startPage = new StartPage();
        startPage.moveInTheCity()
                .enterToChaos()
                .fight();
        waiting(300, 310);
    }

    void fightOfDungeons() {
        StartPage startPage = new StartPage();
        startPage.moveInTheDungeon()
                .inTheDungeon()
                .fight();
    }

    void quitWebDriver() {
        if (WebDriverRunner.hasWebDriverStarted())
            WebDriverRunner.getWebDriver().quit();
    }

}

