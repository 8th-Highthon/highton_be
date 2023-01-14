package com.example.highton.domain.item.repository;

import com.example.highton.domain.item.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
