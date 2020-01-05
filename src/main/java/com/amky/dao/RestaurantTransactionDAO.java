package com.amky.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.amky.model.RestaurantTransaction;
import com.amky.model.RestaurantTransactions;

public class RestaurantTransactionDAO {
	private static RestaurantTransactions list = new RestaurantTransactions();
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public RestaurantTransactions getAllRestaurantTransactions() {
    	List restaurantTransactionListFromQuery;
    	
    	restaurantTransactionListFromQuery = jdbcTemplate.query("select * from restaurantTransaction.restaurantTransaction",
    					(rs, rowNum ) ->
    						new RestaurantTransaction(
    								rs.getInt("id"),
    								rs.getString("date"),
    								rs.getInt("customer_id"),
    								rs.getDouble("moneyCollected")
    								
    								)
    						);
    						
    					list.setRestaurantTrasactionlist(null);
    					for(int i=0;i<restaurantTransactionListFromQuery.size();i++) {
    						list.getRestaurantTrasactionlist().add((RestaurantTransaction)restaurantTransactionListFromQuery.get(i));
    						System.out.println(restaurantTransactionListFromQuery.get(i).toString());
    						
    					}
    					return list;
    }
     
    public void addEmployee(RestaurantTransaction restaurantTransaction) {
        list.getRestaurantTrasactionlist().add(restaurantTransaction);
    	System.out.println("Adding a menuItem");
    	String insertSql = 
    			"Insert Into menuItem (" +
    			" date, "+
    			" customer_id, " +
    			"available) " +
    			"VALUES (?, ?, ?)";
    	Object[] params = new Object[] {
    			restaurantTransaction.getDate(),
    			restaurantTransaction.getCustomer_id(),
    			restaurantTransaction.getMoneyCollected()
    	};
    	int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
    	int row = jdbcTemplate.update(insertSql, params, types);
    	System.out.println(row + " row inserted.");
    	}
}
