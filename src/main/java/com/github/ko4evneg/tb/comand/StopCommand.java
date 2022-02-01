package com.github.ko4evneg.tb.comand;

import com.github.ko4evneg.tb.service.SendBotMessageService;
import com.github.ko4evneg.tb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Stop {@link Command}.
 */
public class StopCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public final static String STOP_MESSAGE = "OK, now I stop working!";

    public StopCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
        telegramUserService.findByChatId(update.getMessage().getChatId().toString()).ifPresent((user) -> {
            user.setActive(false);
            telegramUserService.save(user);
        });
    }
}
