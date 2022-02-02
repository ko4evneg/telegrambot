package com.github.ko4evneg.tb.service;

import com.github.ko4evneg.tb.repository.entity.TelegramUser;

import java.util.List;
import java.util.Optional;

public interface TelegramUserService {
    void save(TelegramUser telegramUser);
    List<TelegramUser> getAllActiveUsers();
    Optional<TelegramUser> findByChatId(String chatId);
}
