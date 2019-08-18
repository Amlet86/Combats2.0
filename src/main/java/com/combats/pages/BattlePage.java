package com.combats.pages;

import com.codeborne.selenide.SelenideElement;
import com.mashape.unirest.http.Unirest;
import org.openqa.selenium.support.FindBy;

import java.time.LocalTime;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.combats.Properties.getPet;
import static com.combats.Properties.getTelegramAPI;
import static com.combats.Utils.getRandomInt;
import static com.combats.Utils.waiting;

public class BattlePage extends BasePage {

    @FindBy(css = "[action=commit]")
    private SelenideElement commitBtn;

    @FindBy(css = ".UserBattleKick")
    private SelenideElement battleKick;

    @FindBy(css = "[action=gameover]")
    private SelenideElement gameover;

    @FindBy(css = "button.userbattlekick")
    private SelenideElement battleKick2;

    @FindBy(css = "button.UserBattleEnd")
    private SelenideElement battleEnd;

    @FindBy(css = ".UserBattleResources button")
    private List<SelenideElement> anyBattleMethods;

    @FindBy(css = ".UserBattleMethod")
    private List<SelenideElement> activeBattleMethods;

    @FindBy(css = ".UserBattleAttack button.UserBattleRadio")
    private List<SelenideElement> attackRadios;

    @FindBy(css = ".UserBattleDefend button.UserBattleRadio")
    private List<SelenideElement> defendRadios;

    @FindBy(css = "td.UserBattleError")
    private SelenideElement text;

    public BattlePage() {
    }

    public void fight() {
        switchTo().defaultContent();
        commitBtn.waitUntil(visible, 25000);
        while (commitBtn.isDisplayed() || battleKick.isDisplayed()) {
            if (battleKick.isDisplayed()) {
                body.pressEnter();
            }
            if (commitBtn.isDisplayed()) {
                if ($(".UserBattleMethod").isDisplayed()) {
                    if (getPet())
                        activeBattleMethods.get(0).click();
                    else {
                        if (anyBattleMethods.size() != 12)
                            activeBattleMethods.get(0).click();
                        else if (!activeBattleMethods.get(0).equals(anyBattleMethods.get(11)))
                            activeBattleMethods.get(0).click();
                    }
                    waiting(1, 2);
                }
                if (attackRadios.get(1).isDisplayed())
                    body.sendKeys(String.valueOf(getRandomInt(1, 6)));
                if (attackRadios.size() > 6)
                    body.sendKeys(String.valueOf(getRandomInt(1, 6)));
                if (defendRadios.get(1).isDisplayed())
                    defendRadios.get(getRandomInt(0, 5)).click();
                if (commitBtn.isDisplayed()) {
                    body.pressEnter();
                }
            }
            waiting(1, 2);
        }
        getMessage();
        exitBattle();
    }

    private void getMessage() {
        if (text.isDisplayed()) {
            String message = text.getText();
            if (getTelegramAPI() == null)
                System.out.println(LocalTime.now() + " " + message);
            else
                Unirest.get("https://api.telegram.org/" + getTelegramAPI() +
                        "/sendMessage?chat_id=391800117&text=" + LocalTime.now() + " " + message);
        }
    }

    private StartPage exitBattle() {
        if (gameover.isDisplayed())
            gameover.click();
        if (battleEnd.isDisplayed())
            battleEnd.click();
        return page(StartPage.class);
    }

}
