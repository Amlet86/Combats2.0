package com.combats.telegram;

import java.util.ArrayList;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

public class Keyboard extends AbstractMessage {

    protected SendMessage sendKeyboard(Update update) {
        SendMessage sendMessage = prepareMessage(update);
        sendMessage.setText("Keyboard up");

        ArrayList<KeyboardRow> keyboard = new ArrayList();
        KeyboardRow firstKeyboardRow = new KeyboardRow();
        KeyboardRow secondKeyboardRow = new KeyboardRow();

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        keyboard.clear();
        firstKeyboardRow.add("What time is it?");
        firstKeyboardRow.add("Who are you?");
        secondKeyboardRow.add("Start the game.");
        secondKeyboardRow.add("Give me a screenshot.");
        keyboard.add(firstKeyboardRow);
        keyboard.add(secondKeyboardRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

}
