package com.github.ko4evneg.tb.comand;

import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing for HelpCommand")
public class HelpCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return "/help";
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }

    @Override
    String getCommandMessage() {
        return HelpCommand.HELP_MESSAGE;
    }
}
