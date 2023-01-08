package com.rikin.fedexecommerce.service;

import com.rikin.fedexecommerce.model.Orders;
import com.rikin.fedexecommerce.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderServiceImplementation implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Orders saveOrder(Orders order) {
        return orderRepository.save(order);
    }
}
