package com.combats.pages;

import com.codeborne.selenide.SelenideElement;

public interface BaseActions {

    void humanClick(SelenideElement element);
    void humanMoveOnTheMap(CharSequence keyToMove);

}
