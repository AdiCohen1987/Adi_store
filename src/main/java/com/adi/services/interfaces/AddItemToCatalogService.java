package com.adi.services.interfaces;

import com.adi.persistence.model.CatalogItem;

public interface AddItemToCatalogService {
    CatalogItem addItemToCatalog(CatalogItem newItem);
}
