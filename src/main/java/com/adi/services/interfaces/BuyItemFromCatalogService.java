package com.adi.services.interfaces;

import com.adi.persistence.model.CatalogItem;

public interface BuyItemFromCatalogService {
    CatalogItem buy(Long itemId, int quantity, Long userId);
}
