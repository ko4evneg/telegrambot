package com.github.ko4evneg.tb.comand;

import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing for NoCommand")
public class NoCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return "";
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }

    @Override
    String getCommandMessage() {
        return NoCommand.NO_MESSAGE;
    }
}
