package com.combats.be;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

import static com.codeborne.selenide.Configuration.*;

class ConfigBrowser {

    ConfigBrowser(boolean headlessValue) {
        if (!headlessValue) {
            browserSize = "850x700";
//            startMaximized = true;
            holdBrowserOpen = true;
        } else {
            browserSize = "1600x900";
        }
        headless = headlessValue;
        savePageSource = false;
        reportsFolder = "fails";
        timeout = 20000;

        ChromeDriverManager.chromedriver().version("75.0.3770.140");
        WebDriverManager.chromedriver().setup();
    }

}
