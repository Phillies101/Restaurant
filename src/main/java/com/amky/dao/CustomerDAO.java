package com.amky.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.amky.model.Customer;
import com.amky.model.Customers;
@Repository
public class CustomerDAO {
	private static Customers list = new Customers();
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public Customers getAllCustomers() {
    	List customerListFromQuery;
    	
    	customerListFromQuery = jdbcTemplate.query("select * from customer.customer",
    					(rs, rowNum ) ->
    						new Customer(
    								rs.getString("username"),
    								rs.getString("password"),
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
    			"Insert Into customer (" +"username"+
    			"password"+
    			" name, "+
    			" address, " +
    			" phone, " +
    			"totalSpend) " +
    			"VALUES (?, ?, ?,?,?,?)";
    	Object[] params = new Object[] {
    			customer.getUsername(),
    			customer.getPassword(),
    			customer.getName(),
    			customer.getAddress(),
    			customer.getPhone(),
    			customer.getTotalSpend()
    	};
    	int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
    	int row = jdbcTemplate.update(insertSql, params, types);
    	System.out.println(row + " row inserted.");
    	}
    public void updateCustomer(Customer customer) {
		System.out.println("Updating an customer");
		String updateSql = "update customer set username=?,password=?, name=?, address=?, phone=?, totalSpend=? where id=?,username=?,password=? ";
		Object[] params = new Object[] { customer.getUsername(),customer.getPassword(), customer.getName(), customer.getAddress(), customer.getPhone(), customer.getTotalSpend(),
				customer.getId() };

		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER };

		int row = jdbcTemplate.update(updateSql, params, types);
		System.out.println(row + " row updated  .");
	}
}
