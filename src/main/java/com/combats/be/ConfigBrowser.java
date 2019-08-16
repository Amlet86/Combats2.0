package com.combats.be;

import io.github.bonigarcia.wdm.WebDriverManager;

import static com.codeborne.selenide.Configuration.*;

class ConfigBrowser {

    ConfigBrowser(boolean headlessValue) {
        if (!headlessValue) {
            startMaximized = true;
            holdBrowserOpen = true;
        } else {
            browserSize = "1600x900";
        }
        browser = "chrome";
        headless = headlessValue;
        savePageSource = false;
        reportsFolder = "fails";
        timeout = 20000;

        WebDriverManager.chromedriver().setup();
    }

}
