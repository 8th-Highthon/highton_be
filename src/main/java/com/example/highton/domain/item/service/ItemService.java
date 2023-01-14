package com.example.highton.domain.item.service;

import com.example.highton.domain.account.Account;
import com.example.highton.domain.account.exception.CannotAccessException;
import com.example.highton.domain.account.service.AccountService;
import com.example.highton.domain.item.Item;
import com.example.highton.domain.item.exception.ItemNotFoundException;
import com.example.highton.domain.item.presentation.request.CreateItemRequest;
import com.example.highton.domain.item.presentation.request.DeleteItemRequest;
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

    private final AccountService accountService;

    @Transactional
    public CreateItemResponse create(CreateItemRequest request) {
        Account account = accountService.getAccount();

        Item item = new Item(
                request.getPrice(),
                request.getTitle(),
                request.getDescription(),
                request.getCategory(),
                request.getSellType(),
                account
        );

        itemRepository.save(item);

        return new CreateItemResponse(item.getId());
    }

    public void deleteItem(DeleteItemRequest request) {
        Account account = accountService.getAccount();
        Item item = itemRepository.findById(request.getItemId())
                .orElseThrow(ItemNotFoundException::new);

        if (!account.getId().equals(item.getAccount().getId())) {
            throw new CannotAccessException();
        }

        //TODO 거래내역이 있으면 삭제 금지

        itemRepository.delete(item);
    }

}
