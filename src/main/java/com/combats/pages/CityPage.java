package com.combats.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.combats.utils.Utils.waitAboutSomeSeconds;

public class CityPage extends BasePage {

    private SelenideElement gameover = $("[action=gameover]");
    private SelenideElement buttonExit = $(".userbattlekick title='Выйти'");
    private SelenideElement battleEnd = $("button.UserBattleEnd");

    public CityPage exitFromBattle() {
        humanClick(gameover);
        humanClick(battleEnd);
        switchToGameFrame();
        waitAboutSomeSeconds(10);
        return page(CityPage.class);
    }

    public GoToBattlePage moveInTheCity() {
        takeDailyQuest();
        returnFromSoulGate();
        return page(GoToBattlePage.class);
    }

    private void takeDailyQuest() {
        if ($("#dailypopup").isDisplayed())
            $x("//*[.='Взять задание']").click();
    }

    private void returnFromSoulGate() {
        if ($(FIRST_PART_OF_IMAGES_LOCATOR + "sun_109_npc.gif']").isDisplayed()) {
            waitAboutSomeSeconds(14);
            $(FIRST_PART_OF_IMAGES_LOCATOR + "sun_new_gate.gif']").click();
        }
        if ($$(FIRST_PART_OF_IMAGES_LOCATOR + "sn_arrow.gif']").get(1).isDisplayed()) {
            waitAboutSomeSeconds(10);
            $$(FIRST_PART_OF_IMAGES_LOCATOR + "sn_arrow.gif']").get(1).click();
        }
        if ($(FIRST_PART_OF_IMAGES_LOCATOR + "sn_club.gif']").isDisplayed()) {
            waitAboutSomeSeconds(10);
            $$(FIRST_PART_OF_IMAGES_LOCATOR + "sn_club.gif']").get(3).click();
        }
    }

    public DungeonsPage switchToTheDungeon() {
        return page(DungeonsPage.class);
    }

}
