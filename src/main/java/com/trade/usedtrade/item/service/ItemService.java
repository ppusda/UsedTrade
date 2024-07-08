package com.trade.usedtrade.item.service;

import com.trade.usedtrade.item.dto.ItemRequest;
import com.trade.usedtrade.item.entity.Item;
import com.trade.usedtrade.item.repository.ItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public Item postBoard(ItemRequest itemRequest) {
        Item item = Item.builder()
                .username(itemRequest.username())
                .title(itemRequest.title())
                .content(itemRequest.content())
                .price(itemRequest.price())
                .build();

        itemRepository.save(item);

        return item;
    }

    public List<Item> getBoard() {
        return itemRepository.findAll();
    }

    @Transactional
    public Item editBoard(Long id, ItemRequest itemRequest) {
        Item item = itemRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        item.editItem(itemRequest.title(),
                itemRequest.content(),
                itemRequest.price(),
                itemRequest.username());

        return item;
    }

    @Transactional
    public void deleteBoard(Long id) {
        itemRepository.deleteById(id);
    }

}
