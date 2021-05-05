package com.adi.controller;

import com.adi.persistence.model.CatalogItem;
import com.adi.services.interfaces.AddItemToCatalogService;
import com.adi.services.interfaces.RemoveItemFromCatalogService;
import com.adi.services.interfaces.ReplaceItemInCatalogService;
import com.adi.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manageStore")
public class OwnerManagementSystemController {

    @Autowired
    private AddItemToCatalogService addItemToCatalogService;

    @Autowired
    private RemoveItemFromCatalogService removeItemFromCatalogService;

    @Autowired
    private ReplaceItemInCatalogService replaceItemInCatalogService;

    @Autowired
    private UserService userService;

    @PostMapping("/addItem")
    public ResponseEntity<CatalogItem> addItem(@RequestHeader("userId") Long userId, @RequestBody CatalogItem catalogItem) {
        userService.validateRole(userId);
        CatalogItem result = addItemToCatalogService.addItemToCatalog(catalogItem);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/removeItem/{id}")
    public ResponseEntity<CatalogItem> removeItem(@RequestHeader("userId") Long userId, @PathVariable("id") Long itemId) {
        userService.validateRole(userId);
        CatalogItem result = removeItemFromCatalogService.removeItem(itemId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("/replaceItem")
    public ResponseEntity<CatalogItem> replaceItem(@RequestHeader("userId") Long userId, @RequestBody CatalogItem catalogItem) {
        userService.validateRole(userId);
        CatalogItem result = replaceItemInCatalogService.replace(catalogItem);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

