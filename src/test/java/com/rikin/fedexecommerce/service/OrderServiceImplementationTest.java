package com.rikin.fedexecommerce.service;

import com.rikin.fedexecommerce.model.Orders;
import com.rikin.fedexecommerce.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplementationTest {

    @Mock
    private OrderRepository orderRepository;
    private OrderService underTest;

    @BeforeEach
    void setUp() {
        underTest = new OrderServiceImplementation(orderRepository);
    }

    @Test
    void saveOrder() {
        //given
        Orders order = new Orders(
                2,
                14000
        );

        //when
        underTest.saveOrder(order);

        //then
        ArgumentCaptor<Orders> ordersArgumentCaptor =
                ArgumentCaptor.forClass(Orders.class);
        verify(orderRepository).save(ordersArgumentCaptor.capture());
        Orders capturedOrder = ordersArgumentCaptor.getValue();
        assertThat(capturedOrder).isEqualTo(order);

    }
}