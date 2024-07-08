package com.trade.usedtrade.item.dto;

import lombok.Builder;

@Builder
public record ItemRequest(
        String username,
        String title,
        String content,
        Long price
) {

}
