package com.combats.pages;

import static com.codeborne.selenide.Selenide.*;
import static com.combats.utils.Utils.waitAboutSomeSeconds;

public class StartPage extends BasePage {

    public GoToBattlePage moveInTheCity() {
        exitToBattle();
        switchToGameFrame();
        takeDailyQuest();
        returnFromSoulRavine();
        return page(GoToBattlePage.class);
    }

    private void exitToBattle() {
        if ($(".UserBattleEnd").isDisplayed()) {
            $(".UserBattleEnd").click();
            refresh();
        }
    }

    private void takeDailyQuest() {
        if ($("#dailypopup").isDisplayed())
            $x("//*[.='Взять задание']").click();
    }

    private void returnFromSoulRavine() {
        if ($("[src='http://img.combats.ru/i/images/subimages/sun_109_npc.gif']").isDisplayed()) {
            waitAboutSomeSeconds(14);
            $("[src='http://img.combats.ru/i/images/subimages/sun_new_gate.gif']").click();
            waitAboutSomeSeconds(10);
        }
        if ($$("[src='http://img.combats.ru/i/images/subimages/sn_arrow.gif']").get(1).isDisplayed()) {
            $$("[src='http://img.combats.ru/i/images/subimages/sn_arrow.gif']").get(1).click();
            waitAboutSomeSeconds(10);
        }
        if ($("[src='http://img.combats.ru/i/images/subimages/sn_club.gif']").isDisplayed()) {
            $$("[src='http://img.combats.ru/i/images/subimages/sn_club.gif']").get(3).click();
            waitAboutSomeSeconds(7);
        }
    }

    public DungeonsPage moveInTheDungeon() {
        switchToGameFrame();
        return page(DungeonsPage.class);
    }

}
