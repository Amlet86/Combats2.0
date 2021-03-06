package com.combats.pages;

import java.util.ArrayList;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.combats.utils.MapNavigator.roadMapList;
import static com.combats.utils.Utils.waitAboutSomeSeconds;

public class DungeonsPage extends BasePage {

    private SelenideElement map = $("div#room");
    private SelenideElement imageOfMap = $("div#brodilka");
    private SelenideElement anyNPC = $("h3");

    private ArrayList<SelenideElement> dungeonCases = new ArrayList<SelenideElement>() {{
        add(map);
        add(anyNPC);
    }};

    public BattlePage walkOnTheDungeon() {
        while (AmIInTheDungeon()) {
            if (map.isDisplayed())
                moveOnTheMap();
            else
                waitAboutSomeSeconds(3);
        }
        return page(BattlePage.class);
    }

    private boolean AmIInTheDungeon() {
        boolean inTheDungeon = false;
        for (SelenideElement element : dungeonCases) {
            if (element.isDisplayed())
                inTheDungeon = true;
        }
        return inTheDungeon;
    }

    private void moveOnTheMap() {
        humanMoveOnTheMap("z");
        if (!roadMapList.isEmpty()) {
            humanMoveOnTheMap(roadMapList.get(0));
            if(map.isDisplayed())
            roadMapList.remove(0);
        }
        else
            humanMoveOnTheMap("w");
        humanMoveOnTheMap("f");
    }

}