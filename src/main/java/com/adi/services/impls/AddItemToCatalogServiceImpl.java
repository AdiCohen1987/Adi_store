package com.adi.services.impls;

import com.adi.persistence.gateways.interfaces.CatalogItemRepositoryGateway;
import com.adi.persistence.model.CatalogItem;
import com.adi.services.interfaces.AddItemToCatalogService;
import com.adi.services.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class AddItemToCatalogServiceImpl implements AddItemToCatalogService {

    @Autowired
    private CatalogItemRepositoryGateway catalogItemRepositoryGateway;

    @Override
    public CatalogItem addItemToCatalog(CatalogItem newItem) {
        return catalogItemRepositoryGateway.addItem(newItem,true);
    }
}
