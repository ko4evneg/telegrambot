package com.github.ko4evneg.tb.comand;

import com.github.ko4evneg.tb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.ko4evneg.tb.comand.CommandName.*;

/**
 * Help {@link Command}.
 */
public class HelpCommand implements Command {
    private final SendBotMessageService sendBotMessageService;

    public final static String HELP_MESSAGE = String.format("<b>Available commands:</b> " +
                    "\n%s - start bot," +
                    "\n%s - stop bot," +
                    "\n%s - get help",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
