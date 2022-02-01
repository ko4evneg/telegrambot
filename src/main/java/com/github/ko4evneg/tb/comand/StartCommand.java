package com.github.ko4evneg.tb.comand;

import com.github.ko4evneg.tb.repository.entity.TelegramUser;
import com.github.ko4evneg.tb.service.SendBotMessageService;
import com.github.ko4evneg.tb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Start {@link Command}.
 */
public class StartCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public final static String START_MESSAGE = "Hi! I am @ko4eneg bot!";

    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                (user) -> {
                    user.setActive(true);
                    telegramUserService.save(user);
                },
                () -> {
                    TelegramUser user = new TelegramUser();
                    user.setActive(true);
                    user.setChatId(chatId);
                    telegramUserService.save(user);
                }
        );
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
