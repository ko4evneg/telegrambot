package com.github.ko4evneg.tb.comand;

import com.github.ko4evneg.tb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;
/**
 * Stop {@link Command}.
 */
public class StopCommand implements Command {
    private final SendBotMessageService sendBotMessageService;

    public final static String STOP_MESSAGE = "OK, now I stop working!";

    public StopCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}
