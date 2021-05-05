package com.adi.services.interfaces;

import com.adi.persistence.model.CatalogItem;

public interface RemoveItemFromCatalogService {
    CatalogItem removeItem(Long itemId);
}
