package com.rikin.fedexecommerce.service;

import com.rikin.fedexecommerce.model.StoreItem;
import com.rikin.fedexecommerce.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImplementation implements StoreService{

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<StoreItem> getAllStoreItems() {
        return storeRepository.findAll();
    }
}
