package com.github.ko4evneg.tb.comand;

import com.github.ko4evneg.tb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;
/**
 * Start {@link Command}.
 */
public class StartCommand implements Command {
    private final SendBotMessageService sendBotMessageService;

    public final static String START_MESSAGE = "Hi! I am @ko4eneg bot!";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
