package com.combats.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;
import static com.combats.BaseCombatsBot.waiting;

public class StartPage extends BasePage {

    private void exitToBattle() {
        if ($(".UserBattleEnd").isDisplayed()) {
            $(".UserBattleEnd").click();
            refresh();
        }
    }

    public GoToBattlePage moveInTheCity() {
        exitToBattle();
        switchToGameFrame();
        if ($("#dailypopup").isDisplayed())
            $x("//*[.='Взять задание']").click();
        waiting(12, 14);
        if ($("[src='http://img.combats.ru/i/images/subimages/sun_109_npc.gif']").isDisplayed()) {
            $("[src='http://img.combats.ru/i/images/subimages/sun_new_gate.gif']").click();
            waiting(8, 10);
        }
        if ($("[src='http://img.combats.ru/i/images/subimages/sn_arrow.gif']").isDisplayed()) {
            $("[src='http://img.combats.ru/i/images/subimages/sn_arrow.gif']").click();
            waiting(10, 15);
        }
        if ($("[src='http://img.combats.ru/i/images/subimages/sn_club.gif']").isDisplayed()) {
            waiting(10, 15);
            $("[src='http://img.combats.ru/i/images/subimages/sn_club.gif']").click();
        }
        return Selenide.page(GoToBattlePage.class);
    }

    public DungeonsPage moveInTheDungeon() {
        switchToGameFrame();
        return Selenide.page(DungeonsPage.class);
    }

}
