package com.amky.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.amky.dao.MenuItemDAO;
import com.amky.model.Customer;
import com.amky.model.MenuItem;
import com.amky.model.MenuItems;

@RestController
//@RequestMapping(path = "/menuItems")
public class MenuItemController {
	 @Autowired
	    private MenuItemDAO menuItemDao;
	     
	    @GetMapping(path="/menuItems", produces = "application/json")
	    public MenuItems getMenuItems()
	    {
	        return menuItemDao.getAllMenuItems();
	    }
	     
	    @PostMapping(path= "/addMenuItem", consumes = "application/json", produces = "application/json")
	    public ResponseEntity<Object> addMenuItem(@RequestBody MenuItem menuItem)
	    {
	        Integer id = menuItemDao.getAllMenuItems().getMenuItemList().size() + 1;
	        menuItem.setId(id);
	         
	        menuItemDao.addMenuItem(menuItem);
	         
	        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	                                    .path("/{id}")
	                                    .buildAndExpand(menuItem.getId())
	                                    .toUri();
	         
	        return ResponseEntity.created(location).build();
	    }
	    @PostMapping(path= "/updateMenuItem", consumes = "application/json", produces = "application/json")
	    public ResponseEntity<Object> updateMenuItem(@RequestBody MenuItem menuItem)
	    {
	    	
	    	System.out.println("EMP ID:"+menuItem.getId());
	         
	    	
	        menuItemDao.updateMenuItem(menuItem);
	         
	        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	                                    .path("/{id}")
	                                    .buildAndExpand(menuItem.getId())
	                                    .toUri();
	         
	        return ResponseEntity.created(location).build();
	    }
}
