package com.adi.persistence.gateways.impl;

import com.adi.configuration.errorHandling.DBException;
import com.adi.configuration.errorHandling.EntityNotFoundException;
import com.adi.persistence.gateways.interfaces.CatalogItemRepositoryGateway;
import com.adi.persistence.model.CatalogItem;
import com.adi.persistence.repo.CatalogItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.adi.configuration.errorHandling.ErrorConstants.ERROR_DELETING_FROM_DB;
import static com.adi.configuration.errorHandling.ErrorConstants.ERROR_RETRIEVING_FROM_DB;
import static com.adi.configuration.errorHandling.ErrorConstants.ERROR_SAVING_TO_DB;

@Service
public class CatalogItemRepositoryGatewayImpl implements CatalogItemRepositoryGateway {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogItemRepositoryGatewayImpl.class);

    @Autowired
    private CatalogItemRepository catalogItemRepository;

    @Override
    public CatalogItem findById(Long catalogItemId) {
        Optional<CatalogItem> optionalCatalogItem;
        try {
            optionalCatalogItem = catalogItemRepository.findById(catalogItemId);
            if (!optionalCatalogItem.isPresent()) {
                throw new EntityNotFoundException("CatalogItem with id: " + catalogItemId + " not found");
            }
        } catch (Exception e) {
            throw new DBException(ERROR_RETRIEVING_FROM_DB + " " + e.getLocalizedMessage());
        }
        LOGGER.debug("retrieved catalog item id from db: {}", catalogItemId);
        return optionalCatalogItem.get();
    }

    @Override
    public CatalogItem removeItem(Long catalogItemId) {
        CatalogItem catalogItemToRemove = findById(catalogItemId);
        try {
            catalogItemRepository.delete(catalogItemToRemove);
        } catch (Exception e) {
            throw new DBException(ERROR_DELETING_FROM_DB + " " + e.getLocalizedMessage());
        }
        return catalogItemToRemove;
    }

    @Override
    public CatalogItem replaceItem(CatalogItem catalogItem) {
        removeItem(catalogItem.getId());
        return addItem(catalogItem, false);

    }

    @Override
    public CatalogItem addItem(CatalogItem item, boolean isNew) {
        try {
            item = catalogItemRepository.save(item);
        } catch (Exception e) {
            throw new DBException(ERROR_SAVING_TO_DB + " " + e.getLocalizedMessage());
        }
        String logMSG = isNew ? "saved new Item id {}, to the catalog" : "update Item id {} in the catalog";
        LOGGER.debug(logMSG, item.getId());
        return item;
    }
}
