package com.github.ko4evneg.tb.repository;

import com.github.ko4evneg.tb.repository.entity.TelegramUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = NONE)
public class TelegramBotRepositoryIT {
    @Autowired
    private TelegramRepository telegramRepository;

    private List<TelegramUser> activeUsers = List.of(
            new TelegramUser("123456789", true),
            new TelegramUser("123456788", true),
            new TelegramUser("123456787", true),
            new TelegramUser("123456786", true),
            new TelegramUser("123456785", true));

    @Test
    @Sql(scripts = {"/sql/clearDb.sql", "/sql/fill_users.sql"})
    public void shouldFindAllActiveUsers() {
        List<TelegramUser> activeUsersFromDb = telegramRepository.findAllByActiveTrue();
        Assertions.assertTrue(activeUsers.containsAll(activeUsersFromDb));
    }

    @Test
    @Sql(scripts = {"/sql/clearDb.sql"})

    public void shouldProperlySaveUser() {
        TelegramUser newUser1 = new TelegramUser("123000999", true);
        TelegramUser newUser2 = new TelegramUser("000000001", false);

        telegramRepository.save(newUser1);
        telegramRepository.save(newUser2);

        Assertions.assertTrue(telegramRepository.findById("123000999").isPresent());
        Assertions.assertTrue(telegramRepository.findById("000000001").isPresent());
        Assertions.assertEquals(newUser1, telegramRepository.findById("123000999").get());
        Assertions.assertEquals(newUser2, telegramRepository.findById("000000001").get());
    }
}
