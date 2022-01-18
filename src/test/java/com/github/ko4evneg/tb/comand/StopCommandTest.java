package com.github.ko4evneg.tb.comand;

import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing for StopCommand")
public class StopCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return "/stop";
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }

    @Override
    String getCommandMessage() {
        return StopCommand.STOP_MESSAGE;
    }
}
