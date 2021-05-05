package com.adi.controller;

import com.adi.persistence.model.CatalogItem;
import com.adi.services.interfaces.BuyItemFromCatalogService;
import com.adi.services.interfaces.GetItemFromCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
public class CustomerController {

    @Autowired
    private GetItemFromCatalogService getItemFromCatalogService;

    @Autowired
    private BuyItemFromCatalogService buyItemFromCatalogService;

    @GetMapping("/queryItem/{id}")
    public ResponseEntity<CatalogItem> getItem(@PathVariable("id") Long itemId) {
        CatalogItem result = getItemFromCatalogService.retrieve(itemId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/buyItem/{id}/quantity/{amount}")
    public ResponseEntity<CatalogItem> buyItem(@PathVariable("id") Long itemId, @PathVariable("amount") int amount, @RequestHeader("userId") Long userId) {
        CatalogItem result = buyItemFromCatalogService.buy(itemId, amount, userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

