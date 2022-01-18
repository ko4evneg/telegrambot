package com.github.ko4evneg.tb.bot;

import com.github.ko4evneg.tb.comand.CommandContainer;
import com.github.ko4evneg.tb.service.SendBotMessageService;
import com.github.ko4evneg.tb.service.SendBotMessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Locale;

import static com.github.ko4evneg.tb.comand.CommandName.NO;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    private final static String COMMAND_PREFIX = "/";

    @Value("${bot.username}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;


    private final CommandContainer commandContainer;

    public TelegramBot() {
        commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String chatId = update.getMessage().getChatId().toString();

            if (message.startsWith(COMMAND_PREFIX)) {
                String commandId = message.toLowerCase();
                commandContainer.retrieveCommand(commandId).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }
}
