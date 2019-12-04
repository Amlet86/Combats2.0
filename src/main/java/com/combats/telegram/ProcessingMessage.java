package com.combats.telegram;

import java.util.Date;

import com.combats.be.TopLevelLogic;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.combats.utils.Properties.setTelegramChatId;

public class ProcessingMessage extends AbstractMessage {

    private String startBrowserAndGame() {
        TopLevelLogic topLevelLogic = new TopLevelLogic();
        return topLevelLogic.game();
    }

    private SendMessage sendText(Update update) {
        SendMessage sendMessage = prepareMessage(update);
        String question = update.getMessage().getText();
        if (question.contains("What time is it?"))
            sendMessage.setText(new Date().toString());
        else if (question.contains("Who are you?"))
            sendMessage.setText("Just a dumb piece of iron.");
        else if (question.contains("Start the game.")) {
            setTelegramChatId(update.getMessage().getChatId().toString());
            String endGameMessage = startBrowserAndGame();
            sendMessage.setText(endGameMessage);
        } else if (question.contains("Give me a screenshot.")) {
            sendMessage.setText("Mock");
        } else
            sendMessage.setText("I don't understand you.");
        return sendMessage;
    }

    public SendMessage processing(Update update) {
        String inputMessage = update.getMessage().getText();
        if (inputMessage.contains("menu") || inputMessage.contains("Menu"))
            return new Keyboard().sendKeyboard(update);
        else
            return sendText(update);
    }

}
