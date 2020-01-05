package com.amky.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.amky.model.Customer;
import com.amky.model.Customers;

public class CustomerDAO {
	private static Customers list = new Customers();
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public Customers getAllCustomers() {
    	List customerListFromQuery;
    	
    	customerListFromQuery = jdbcTemplate.query("select * from customer.customer",
    					(rs, rowNum ) ->
    						new Customer(
    								rs.getInt("id"),
    								rs.getString("name"),
    								rs.getString("address"),
    								rs.getInt("phone"),
    								rs.getDouble("totalSpend")
    								)
    						);
    						
    					list.setCustomerList(null);
    					for(int i=0;i<customerListFromQuery.size();i++) {
    						list.getCustomerList().add((Customer)customerListFromQuery.get(i));
    						System.out.println(customerListFromQuery.get(i).toString());
    						
    					}
    					return list;
    }
     
    public void addCustomer(Customer customer) {
        list.getCustomerList().add(customer);
    	System.out.println("Adding a customer");
    	String insertSql = 
    			"Insert Into customer (" +
    			" name, "+
    			" address, " +
    			" phone, " +
    			"totalSpend) " +
    			"VALUES (?, ?, ?,?)";
    	Object[] params = new Object[] {
    			customer.getName(),
    			customer.getAddress(),
    			customer.getPhone(),
    			customer.getTotalSpend()
    	};
    	int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
    	int row = jdbcTemplate.update(insertSql, params, types);
    	System.out.println(row + " row inserted.");
    	}
}
