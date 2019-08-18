package com.combats.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.combats.Utils.waiting;

class BasePage {

    @FindBy(css = "body")
    SelenideElement body;

    void switchToGameFrame() {
        switchTo().frame($("[onload='top.User.Framework.MainOnLoad( )']"));
        waiting(1, 2);
    }

}
