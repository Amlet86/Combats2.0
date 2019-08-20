package com.combats.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class DungeonsPage extends BasePage {

    @FindBy(css = "div#room")
    private SelenideElement map;

    public BattlePage inTheDungeon() {
        while (map.isDisplayed()) {
            humanMoveOnTheMap("f");
            humanMoveOnTheMap("z");
            humanMoveOnTheMap("w");
        }
        return page(BattlePage.class);
    }

}
