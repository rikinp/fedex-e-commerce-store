package com.rikin.fedexecommerce.service;

import com.rikin.fedexecommerce.repository.StoreRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StoreServiceImplementationTest {

    @Mock
    private StoreRepository storeRepository;
    private StoreService underTest;

    @BeforeEach
    void setUp() {
        underTest = new StoreServiceImplementation(storeRepository);
    }

    @Test
    void canGetAllStoreItems() {
        //when
        underTest.getAllStoreItems();
        //then
        verify(storeRepository).findAll();
    }
}