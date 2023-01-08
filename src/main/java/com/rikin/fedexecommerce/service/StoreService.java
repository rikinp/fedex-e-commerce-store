package com.rikin.fedexecommerce.service;

import com.rikin.fedexecommerce.model.StoreItem;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StoreService {
//    public StoreItems saveOrder(StoreItems storeItems);
    public List<StoreItem> getAllStoreItems();
}
