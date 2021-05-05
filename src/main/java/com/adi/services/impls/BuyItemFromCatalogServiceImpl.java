package com.adi.services.impls;

import com.adi.configuration.errorHandling.OutOfStockException;
import com.adi.persistence.gateways.interfaces.CatalogItemRepositoryGateway;
import com.adi.persistence.gateways.interfaces.SystemIdentityRepositoryGateway;
import com.adi.persistence.model.CatalogItem;
import com.adi.persistence.model.User;
import com.adi.services.interfaces.BuyItemFromCatalogService;
import com.adi.services.interfaces.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyItemFromCatalogServiceImpl implements BuyItemFromCatalogService {

    @Autowired
    private CatalogItemRepositoryGateway catalogItemRepositoryGateway;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private SystemIdentityRepositoryGateway systemIdentityRepositoryGateway;

    @Override
    public CatalogItem buy(Long itemId, int quantity, Long userId) {
        CatalogItem catalogItem = catalogItemRepositoryGateway.findById(itemId);
        int itemAmountInStock = catalogItem.getAmountLeft();
        if (itemAmountInStock == 0) {
            throw new OutOfStockException("item is out of stock");
        }
        if (itemAmountInStock < quantity) {
            throw new OutOfStockException("The quantity that you want is more then the amount of stock by: " + (quantity - itemAmountInStock));
        }
        User user = systemIdentityRepositoryGateway.findById(userId);
        paymentService.pay(user.getPaymentMethod(), catalogItem.getPrice(), quantity);
        catalogItem.setAmountLeft(itemAmountInStock - quantity);
        return catalogItemRepositoryGateway.replaceItem(catalogItem);
    }
}
