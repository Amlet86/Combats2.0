package com.combats.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;
import static com.combats.utils.Utils.*;

public class GoToBattlePage extends BasePage {

    @FindBy(css = "[value='Поединки']")
    private SelenideElement battles;

    @FindBy(xpath = "//*[.='Хаотичные']")
    private SelenideElement chaosBattle;

    @FindBy(css = "[value='Обновить']")
    private SelenideElement refreshBtn;

    @FindBy(css = "[name=confirm1]")
    private SelenideElement confirm;

    @FindBy(xpath = "//*[.='Подать заявку на хаотичный бой']")
    private SelenideElement applicationChaos;

    @FindBy(css = "[name=open]")
    private SelenideElement open;

    private By goCombat = By.cssSelector("[name=gocombat]");

    public BattlePage enterToChaos() {
        humanClick(battles);
        if(chaosBattle.isDisplayed()) {
            humanClick(chaosBattle);
            while (refreshBtn.isDisplayed()) {
                if (confirm.isDisplayed()) {
                    int number = chooseRadioWithMinTime();
                    if (number >= 0) {
                        $$(goCombat).get(number).click();
                        humanClick(confirm);
                    }
                }
                if (applicationChaos.isDisplayed()) {
                    applicationChaos.click();
                    $("[name=startime2]").selectOptionByValue("300");
                    $("[name=levellogin1]").selectOptionByValue("3");
                    open.click();
                }
                if (refreshBtn.isDisplayed())
                    refreshBtn.click();
                waitAboutSomeSeconds(10);
            }
        }
        return page(BattlePage.class);
    }

}
