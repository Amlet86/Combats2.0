package com.combats.pages;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    public LoginPage enterToMainPage() {
        return open("http://www.combats.com/", LoginPage.class);
    }

    public StartPage login(String login, String password) {
        $("[name=login]").setValue(login);
        $("[name=psw]").setValue(password);
        $("[value=' Войти ']").click();
        return page(StartPage.class);
    }

}
