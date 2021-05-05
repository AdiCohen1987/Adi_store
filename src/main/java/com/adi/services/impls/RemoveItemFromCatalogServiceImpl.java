package com.adi.services.impls;

import com.adi.persistence.gateways.interfaces.CatalogItemRepositoryGateway;
import com.adi.persistence.model.CatalogItem;
import com.adi.services.interfaces.RemoveItemFromCatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveItemFromCatalogServiceImpl implements RemoveItemFromCatalogService {

    @Autowired
    private CatalogItemRepositoryGateway catalogItemRepositoryGateway;

    @Override
    public CatalogItem removeItem(Long itemId) {
        return catalogItemRepositoryGateway.removeItem(itemId);
    }
}
