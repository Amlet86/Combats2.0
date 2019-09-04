package com.combats.pages;

import java.time.LocalTime;
import java.util.List;

import com.codeborne.selenide.SelenideElement;
import com.mashape.unirest.http.Unirest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.combats.utils.Properties.getPet;
import static com.combats.utils.Properties.getTelegramAPI;
import static com.combats.utils.Utils.getRandomInt;
import static com.combats.utils.Utils.waitAboutSomeSeconds;

public class BattlePage extends BasePage {

    private SelenideElement commitBtn = $("[action=commit]");
    private SelenideElement battleKick = $(".UserBattleKick");
    private List<SelenideElement> anyBattleMethods = $$(".UserBattleResources button");
    private List<SelenideElement> activeBattleMethods = $$(".UserBattleMethod");
    private List<SelenideElement> attackRadios = $$(".UserBattleAttack button.UserBattleRadio");
    private List<SelenideElement> defendRadios = $$(".UserBattleDefend button.UserBattleRadio");
    private SelenideElement text = $("td.UserBattleError");

    public BattlePage() {
    }

    public CityPage fight() {
        switchTo().defaultContent();
        commitBtn.waitUntil(visible, 25000);
        while (commitBtn.isDisplayed() || battleKick.isDisplayed()) {
            if (commitBtn.isDisplayed()) {
                clickBattleMethods();
                clickAttack();
                clickDefend();
            }
            body.pressEnter();
            waitAboutSomeSeconds(2);
        }
        getMessage();
        return page(CityPage.class);
    }

    private void clickBattleMethods(){
        if ($(".UserBattleMethod").isDisplayed()) {
            if (getPet())
                activeBattleMethods.get(0).click();
            else {
                if (anyBattleMethods.size() != 12)
                    activeBattleMethods.get(0).click();
                else if (!activeBattleMethods.get(0).equals(anyBattleMethods.get(11)))
                    activeBattleMethods.get(0).click();
            }
            waitAboutSomeSeconds(2);
        }
    }

    private void clickAttack(){
        if (attackRadios.get(1).isDisplayed())
            body.sendKeys(String.valueOf(getRandomInt(1, 6)));
        if (attackRadios.size() > 6)
            body.sendKeys(String.valueOf(getRandomInt(1, 6)));
    }

    private void clickDefend(){
        if (defendRadios.get(1).isDisplayed())
            defendRadios.get(getRandomInt(0, 5)).click();
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

}
