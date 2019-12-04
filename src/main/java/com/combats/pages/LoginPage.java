package com.combats.pages;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    public void login(String login, String password) {
        $("[name=login]").setValue(login);
        $("[name=psw]").setValue(password);
        $("[value=' Войти ']").click();
    }

}
