package com.amky.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.amky.dao.RestaurantTransactionDAO;
import com.amky.model.Customer;
import com.amky.model.RestaurantTransaction;
import com.amky.model.RestaurantTransactions;

@RestController
//@RequestMapping(path = "/restaurantTransactions")
public class RestaurantTransactionController {
	  @Autowired
	    private RestaurantTransactionDAO restaurantTransactionDao;
	     
	    @GetMapping(path="/restaurantTransactions", produces = "application/json")
	    public RestaurantTransactions getRestaurantTransactions()
	    {
	        return restaurantTransactionDao.getAllRestaurantTransactions();
	    }
	     
	    @PostMapping(path= "/addRestaurantTransaction", consumes = "application/json", produces = "application/json")
	    public ResponseEntity<Object> addRestaurantTransaction(@RequestBody RestaurantTransaction restaurantTransaction)
	    {
	        Integer id = restaurantTransactionDao.getAllRestaurantTransactions().getRestaurantTrasactionlist().size() + 1;
	        restaurantTransaction.setId(id);
	         
	        restaurantTransactionDao.addRestaurantTransaction(restaurantTransaction);
	         
	        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	                                    .path("/{id}")
	                                    .buildAndExpand(restaurantTransaction.getId())
	                                    .toUri();
	         
	        return ResponseEntity.created(location).build();
	    }
	    @PostMapping(path= "/updateRestaurantTransaction", consumes = "application/json", produces = "application/json")
	    public ResponseEntity<Object> updateRestaurantTransaction(@RequestBody RestaurantTransaction restaurantTransaction)
	    {
	    	
	    	System.out.println("EMP ID:"+restaurantTransaction.getId());
	         
	    	
	    	restaurantTransactionDao.updateRestaurantTransaction(restaurantTransaction);
	         
	        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	                                    .path("/{id}")
	                                    .buildAndExpand(restaurantTransaction.getId())
	                                    .toUri();
	         
	        return ResponseEntity.created(location).build();
	    }
}
