package com.combats.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;
import static com.combats.utils.Utils.waitAboutSomeSeconds;

public class BasePage implements BaseActions {

    static final String BASE_URL = "http://www.combats.com/";
    static final String FIRST_PART_OF_IMAGES_LOCATOR = "[src='http://img.combats.ru/i/images/subimages/";

    @FindBy(css = "body")
    SelenideElement body;

    @FindBy(css = "span#effs")
    SelenideElement iconsOfEffectsFromUserInformation;

    @FindBy(css = "div#ione")
    SelenideElement frameOfTheCity;

    public void openBasePage() {
        open(BASE_URL);
    }

    void switchToGameFrame() {
        switchTo().frame($("[onload='top.User.Framework.MainOnLoad( )']"));
    }

    @Override
    public void humanClick(SelenideElement element) {
        waitAboutSomeSeconds(1);
        if (element != null && element.isDisplayed()) {
            element.click();
        }
    }

    @Override
    public void humanMoveOnTheMap(CharSequence keyToMove) {
        waitAboutSomeSeconds(1);
        body.sendKeys(keyToMove);
        waitAboutSomeSeconds(1);
    }

}
