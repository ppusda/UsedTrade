package com.trade.usedtrade.item.controller;

import com.trade.usedtrade.item.dto.ItemRequest;
import com.trade.usedtrade.item.dto.ItemResponse;
import com.trade.usedtrade.item.service.ItemService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/post")
    public ItemResponse postItemBoard(@RequestBody ItemRequest itemRequest) {
        // 아이템 게시글 작성
        return ItemResponse.from(itemService.postBoard(itemRequest));
    }

    @GetMapping("/post")
    public List<ItemResponse> getItemBoard() {
        // 아이템 게시글 목록 가져오기
        return itemService.getBoard().stream()
                .map(ItemResponse::from)
                .toList();
    }


    @PutMapping("/post/{id}")
    public ItemResponse putItemBoard(@PathVariable(name = "id") Long id, @RequestBody ItemRequest itemRequest) {
        // 아이템 게시글 수정
        return ItemResponse.from(itemService.editBoard(id, itemRequest));
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<Map<String, String>> deleteItemBoard(@PathVariable(name = "id") Long id) {
        // 아이템 게시글 삭제
        itemService.deleteBoard(id);

        Map<String, String> response = new HashMap<>();
        response.put("msg", "삭제 완료");

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(response);
    }
}
