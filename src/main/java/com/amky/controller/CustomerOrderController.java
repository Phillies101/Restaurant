package com.amky.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.amky.dao.CustomerOrderDAO;
import com.amky.model.CustomerOrder;
import com.amky.model.CustomerOrders;

@RestController
//@RequestMapping(path = "/customers")
public class CustomerOrderController {
	@Autowired
    private CustomerOrderDAO customerOrderDao;
     
    @GetMapping(path="/customerOrders", produces = "application/json")
    public CustomerOrders getCustomerOrders()
    {
        return customerOrderDao.getAllCustomerOrders();
    }
     
    @PostMapping(path= "/addCustomerOrder", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addCustomerOrder(@RequestBody CustomerOrder customerOrder)
    {
        Integer id = customerOrderDao.getAllCustomerOrders().getCustomerOrderList().size() + 1;
        customerOrder.setId(id);
         
        customerOrderDao.addCustomer(customerOrder);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(customerOrder.getId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
}
