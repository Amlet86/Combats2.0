package com.combats.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.combats.utils.Utils.waitAboutSomeSeconds;

class BasePage implements BaseActions {

    static final String BASE_URL = "http://www.combats.com/";

    @FindBy(css = "body")
    SelenideElement body;

    @FindBy(css = "span#effs")
    private SelenideElement iconsOfEffectsFromUserInformation;

    void switchToGameFrame() {
        switchTo().frame($("[onload='top.User.Framework.MainOnLoad( )']"));
    }

    @Override
    public void humanClick(SelenideElement element) {
        waitAboutSomeSeconds(1);
        if (element.isDisplayed()) {
            element.click();
        }
    }

    @Override
    public void humanMoveOnTheMap(CharSequence keyToMove) {
        waitAboutSomeSeconds(2);
        body.sendKeys(keyToMove);
    }

}
