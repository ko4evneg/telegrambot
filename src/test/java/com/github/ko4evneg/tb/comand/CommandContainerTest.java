package com.github.ko4evneg.tb.comand;

import com.github.ko4evneg.tb.service.SendBotMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

@DisplayName("Unit-level testing for CommandContainer")
class CommandContainerTest {
    private SendBotMessageService sendBotMessageService;
    private CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        commandContainer = new CommandContainer(sendBotMessageService);
    }

    @Test
    public void shouldGetAllExistingCommands() {
        List<Class> commandlist = List.of(StartCommand.class, StopCommand.class, HelpCommand.class, NoCommand.class);
        Arrays.stream(CommandName.values()).forEach((commandName) -> {
            Command command = commandContainer.retrieveCommand(commandName.getCommandName());
            Assertions.assertTrue(commandlist.contains(command.getClass()));
        });
    }

    @Test
    public void shouldReplyUnknownCommand() {
        List.of("/laper", "/4325t", "/   ").stream()
                .forEach(s -> {
                    Command command = commandContainer.retrieveCommand(s);
                    Assertions.assertTrue(command.getClass() == UnknownCommand.class);
                });
    }
}

