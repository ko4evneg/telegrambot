package com.github.ko4evneg.tb.comand;

import com.github.ko4evneg.tb.repository.entity.TelegramUser;
import com.github.ko4evneg.tb.service.SendBotMessageService;
import com.github.ko4evneg.tb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Start {@link Command}.
 */
public class StatCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public final static String STAT_MESSAGE = "Bot users list: ";

    public StatCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        List<TelegramUser> users = telegramUserService.getAllActiveUsers();
        List<String> stringUsers = users.stream().map(TelegramUser::getChatId).collect(Collectors.toList());
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),
                STAT_MESSAGE + System.lineSeparator() + stringUsers);
    }
}
