package com.combats.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;
import static com.combats.BaseCombatsBot.waiting;
import static java.lang.Double.parseDouble;

public class GoToBattlePage {

    @FindBy(css = "[value='Поединки']")
    private SelenideElement battles;

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
        if (battles.isDisplayed())
            battles.click();
                $x("//*[.='Хаотичные']").click();

        while (refreshBtn.isDisplayed()) {
            if (confirm.isDisplayed()) {
                int number = chooseRadioWithMinTime();
                if (number >= 0) {
                    $$(goCombat).get(number).click();
                    confirm.click();
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
            waiting(10, 15);
        }
        return page(BattlePage.class);
    }

    private int chooseRadioWithMinTime() {
        int minTime = -1;
        int iterator = 0;
        double tmpTime = 5;
        try {
            for (SelenideElement element : $$("[action='zayavka.pl'] > .dsc > i > b")) {
                double time = parseDouble(element.getText());
                if (time <= tmpTime) {
                    tmpTime = time;
                    minTime = iterator;
                }
                iterator++;
            }
            return minTime;
        } catch (NumberFormatException e) {
            e.getStackTrace();
            return -1;
        }
    }

}
