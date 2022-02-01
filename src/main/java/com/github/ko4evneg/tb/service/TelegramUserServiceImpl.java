package com.github.ko4evneg.tb.service;

import com.github.ko4evneg.tb.repository.TelegramRepository;
import com.github.ko4evneg.tb.repository.entity.TelegramUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelegramUserServiceImpl implements TelegramUserService {

    private final TelegramRepository repository;

    public TelegramUserServiceImpl(TelegramRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(TelegramUser telegramUser) {
        repository.save(telegramUser);
    }

    @Override
    public List<TelegramUser> getAllActiveUsers() {
        return repository.findAllByActiveTrue();
    }

    @Override
    public Optional<TelegramUser> findByChatId(String chatId) {
        return repository.findById(chatId);
    }
}
