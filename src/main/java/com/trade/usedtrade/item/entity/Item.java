package com.trade.usedtrade.item.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;
    private Long price;
    private String username;

    @Builder
    public Item(String title, String content, Long price, String username) {
        this.title = title;
        this.content = content;
        this.price = price;
        this.username = username;
    }

    public void editItem(String title, String content, Long price, String username) {
        this.title = title;
        this.content = content;
        this.price = price;
        this.username = username;
    }
}
