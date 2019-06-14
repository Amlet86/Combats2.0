package com.combats.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.combats.BaseCombatsBot.waiting;

public class DungeonsPage {

    @FindBy(css = "div#room")
    private SelenideElement map;

    public BattlePage testInTheDungeon() {
        while (map.isDisplayed()) {
            $("body").sendKeys("f");
            waiting(1, 2);
            $("body").sendKeys("z");
            waiting(1, 2);
            $("body").sendKeys("w");
            waiting(2, 3);
        }
        return page(BattlePage.class);
    }
}
