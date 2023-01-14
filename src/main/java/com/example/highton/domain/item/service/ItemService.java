package com.example.highton.domain.item.service;

import com.example.highton.domain.item.Item;
import com.example.highton.domain.item.presentation.request.CreateItemRequest;
import com.example.highton.domain.item.presentation.response.CreateItemResponse;
import com.example.highton.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public CreateItemResponse create(CreateItemRequest request) {
        Item item = new Item(
                request.getPrice(),
                request.getTitle(),
                request.getDescription(),
                request.getCategory(),
                request.getSellType()
        );

        itemRepository.save(item);

        return new CreateItemResponse(item.getId());
    }

}
