package com.github.ko4evneg.tb.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="tg_user")
public class TelegramUser {
    public TelegramUser(String chatId, boolean active) {
        this.chatId = chatId;
        this.active = active;
    }

    public TelegramUser() {
    }

    @Id
    @Column(name = "chat_id")
    private String chatId;

    @Column(name="active")
    private boolean active;
}
