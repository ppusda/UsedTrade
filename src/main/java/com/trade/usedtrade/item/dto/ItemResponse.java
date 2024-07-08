package com.trade.usedtrade.item.dto;

import com.trade.usedtrade.item.entity.Item;
import lombok.Builder;

@Builder
public record ItemResponse (
        Long id,
        String username,
        String title,
        String content,
        Long price
) {

    public static ItemResponse from(Item item) {
        return ItemResponse.builder()
                .id(item.getId())
                .username(item.getUsername())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .build();
    }

}
