package com.amky.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.amky.dao.CustomerDAO;
import com.amky.model.Customer;
import com.amky.model.Customers;
@RestController
//@RequestMapping(path = "/customers")
public class CustomerController {
	@Autowired
    private CustomerDAO customerDao;
     
    @GetMapping(path="/customers", produces = "application/json")
    
    public Customers getCustomers()
    {
        return customerDao.getAllCustomers();
    }
     
    @PostMapping(path= "/addCustomer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer)
    {
        Integer id = customerDao.getAllCustomers().getCustomerList().size() + 1;
        customer.setId(id);
         
        customerDao.addCustomer(customer);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(customer.getId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
    @PostMapping(path= "/updateCustomer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer)
    {
    	
    	System.out.println("EMP ID:"+customer.getId());
         
    	
        customerDao.updateCustomer(customer);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(customer.getId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
    @PostMapping(path= "/validateCredentials", consumes = "application/json", produces = "application/json")
    public Customers validateCustomer(@RequestBody Customer customer)
    {
    	System.out.println("Customer Username "+customer.getUsername())
    	return customerDao.validateCredentials(customer)
        
    }
    }
}
