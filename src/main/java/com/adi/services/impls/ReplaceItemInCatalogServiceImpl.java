package com.adi.services.impls;

import com.adi.persistence.gateways.interfaces.CatalogItemRepositoryGateway;
import com.adi.persistence.model.CatalogItem;
import com.adi.services.interfaces.ReplaceItemInCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplaceItemInCatalogServiceImpl implements ReplaceItemInCatalogService {

    @Autowired
    private CatalogItemRepositoryGateway catalogItemRepositoryGateway;

    @Override
    public CatalogItem replace(CatalogItem item) {
        return catalogItemRepositoryGateway.replaceItem(item);
    }
}
