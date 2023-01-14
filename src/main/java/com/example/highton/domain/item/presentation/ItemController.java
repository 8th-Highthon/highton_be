package com.example.highton.domain.item.presentation;

import com.example.highton.domain.item.presentation.request.CreateItemRequest;
import com.example.highton.domain.item.presentation.request.DeleteItemRequest;
import com.example.highton.domain.item.presentation.response.CreateItemResponse;
import com.example.highton.domain.item.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = {"물건 관련 API"})
@RequiredArgsConstructor
@RequestMapping("/item")
@RestController
public class ItemController {

    private final ItemService itemService;

    @Operation(summary = "판매 물품 등록")
    @PostMapping
    public CreateItemResponse create(@RequestBody @Valid CreateItemRequest request) {
        return itemService.create(request);
    }

    @Operation(summary = "판매 물품 삭제")
    @DeleteMapping
    public void deleteItem(@RequestBody @Valid DeleteItemRequest request) {
        itemService.deleteItem(request);
    }

}
