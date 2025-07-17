package com.example.sistemalanchonete.controller;

import com.example.sistemalanchonete.models.Item;
import com.example.sistemalanchonete.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public ResponseEntity<Item> apresentar(@PathVariable Long id){

        Item item = itemRepository.findById(id).get();
        return ResponseEntity.ok(item);

    }

}
