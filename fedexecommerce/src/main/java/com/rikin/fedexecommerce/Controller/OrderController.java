package com.rikin.fedexecommerce.Controller;

import com.rikin.fedexecommerce.model.Orders;
import com.rikin.fedexecommerce.service.OrderService;
import com.rikin.fedexecommerce.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/submitOrder")
    public String submitOrder(@RequestBody Orders order){
        orderService.saveOrder(order);
        return "Your Order is saved";
    }

}
