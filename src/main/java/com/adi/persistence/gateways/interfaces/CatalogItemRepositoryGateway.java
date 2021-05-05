package com.adi.persistence.gateways.interfaces;

import com.adi.persistence.model.CatalogItem;

public interface CatalogItemRepositoryGateway {

    CatalogItem findById(Long catalogItemId);

    CatalogItem removeItem(Long catalogItemId);

    CatalogItem replaceItem(CatalogItem catalogItem);

    CatalogItem addItem(CatalogItem item, boolean isNew);
}
