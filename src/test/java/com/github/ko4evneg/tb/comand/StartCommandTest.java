package com.github.ko4evneg.tb.comand;

import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing for StartCommand")
public class StartCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return "/start";
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService, telegramUserService);
    }

    @Override
    String getCommandMessage() {
        return StartCommand.START_MESSAGE;
    }
}
