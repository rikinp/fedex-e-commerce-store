package com.rikin.fedexecommerce.Controller;

import com.rikin.fedexecommerce.model.Orders;
import com.rikin.fedexecommerce.model.StoreItem;
import com.rikin.fedexecommerce.service.OrderService;
import com.rikin.fedexecommerce.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estore")
@CrossOrigin
public class StoreController {

    @Autowired
    private StoreService storeService;

    @CrossOrigin
    @GetMapping("/getAll")
    public List<StoreItem> getAllStoreItems() {
        return storeService.getAllStoreItems();
    }

}
