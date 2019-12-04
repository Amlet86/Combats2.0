package com.combats.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.combats.utils.Properties.getTelegramBotName;
import static com.combats.utils.Properties.getTelegramBotToken;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        ProcessingMessage processingMessage = new ProcessingMessage();
        SendMessage sendMessage = processingMessage.processing(update);
        sendMsg(sendMessage);
    }

    public synchronized void sendMsg(String chatId, String outputMessage) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(outputMessage);
        sendMsg(sendMessage);
    }

    public synchronized void sendMsg(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return getTelegramBotName();
    }

    @Override
    public String getBotToken() {
        return getTelegramBotToken();
    }

}
