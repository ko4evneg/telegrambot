package com.github.ko4evneg.tb.comand;

import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing for UnknownCommand")
public class UnknownCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return "/unkn";
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }

    @Override
    String getCommandMessage() {
        return UnknownCommand.UNKNOWN_MESSAGE;
    }
}
