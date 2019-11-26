package com.combats.telegram;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class PropertiesOfTelegramBot {

    /**
     * https://ru.stackoverflow.com/questions/839400/telegramapirequestexception-%D0%BF%D1%80%D0%B8-%D0%B7%D0%B0%D0%BF%D1%83%D1%81%D0%BA%D0%B5-telegram-%D0%B1%D0%BE%D1%82%D0%B0
     */
    private static void setVPNThroughTOR() {
        System.getProperties().put("proxySet", "true");
        System.getProperties().put("socksProxyHost", "127.0.0.1");
        System.getProperties().put("socksProxyPort", "9150");
    }

    public static Bot startTelegramBot() {
        setVPNThroughTOR();

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        Bot bot = new Bot();
        try {
            telegramBotsApi.registerBot(bot);
        } catch (
            TelegramApiRequestException e) {
            e.printStackTrace();
        }
        return bot;
    }

}
