package com.adi.services.interfaces;

import com.adi.persistence.model.CatalogItem;

public interface GetItemFromCatalogService {
    CatalogItem retrieve(Long itemId);
}
