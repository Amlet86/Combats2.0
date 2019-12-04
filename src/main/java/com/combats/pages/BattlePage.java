package com.combats.pages;

import java.time.LocalTime;
import java.util.List;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.combats.fe.LoginForm.bot;
import static com.combats.utils.Properties.*;
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

    public void fight() {
        switchTo().defaultContent();
        commitBtn.waitUntil(visible, 25000);
        while (commitBtn.isDisplayed() || battleKick.isDisplayed()) {
            if (commitBtn.isDisplayed()) {
                clickBattleMethods();
                clickAttack();
                clickDefend();
            }
            body.pressEnter();
            waitAboutSomeSeconds(1);
        }
        getMessage();
    }

    private void clickBattleMethods() {
        if ($(".UserBattleMethod").isDisplayed()) {
            if (getPet())
                activeBattleMethods.get(0).click();
            else {
                if (anyBattleMethods.size() != 12 && activeBattleMethods.get(0).isDisplayed())
                    activeBattleMethods.get(0).click();
                else if (!activeBattleMethods.get(0).equals(anyBattleMethods.get(11)) && activeBattleMethods.get(0).isDisplayed())
                    activeBattleMethods.get(0).click();
            }
        }
        waitAboutSomeSeconds(1);
    }

    private void clickAttack() {
        if (attackRadios.get(1).isDisplayed())
            attackRadios.get(getRandomInt(0, 5)).click();
        if (attackRadios.size() > 6)
            body.sendKeys(String.valueOf(getRandomInt(1, 6)));
    }

    private void clickDefend() {
        if (defendRadios.get(1).isDisplayed())
            defendRadios.get(getRandomInt(0, 5)).click();
    }

    private void getMessage() {
        String message = "";
        if (text.isDisplayed()) {
            message = text.getText();
            if (getTelegramBotToken() == null || getTelegramBotName() == null)
                System.out.println(LocalTime.now() + " " + message);
            else
                bot.sendMsg(getTelegramChatId(), message);
        }

    }

}
