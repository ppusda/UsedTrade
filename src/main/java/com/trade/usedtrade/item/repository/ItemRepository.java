package com.trade.usedtrade.item.repository;

import com.trade.usedtrade.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
