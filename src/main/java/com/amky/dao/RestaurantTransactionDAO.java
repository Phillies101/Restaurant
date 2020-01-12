package com.amky.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.amky.model.RestaurantTransaction;
import com.amky.model.RestaurantTransactions;
@Repository
public class RestaurantTransactionDAO {
	private static RestaurantTransactions list = new RestaurantTransactions();
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public RestaurantTransactions getAllRestaurantTransactions() {
    	List restaurantTransactionListFromQuery;
    	
    	restaurantTransactionListFromQuery = jdbcTemplate.query("select * from restauranttransaction.restauranttransaction",
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
     
    public void addRestaurantTransaction(RestaurantTransaction restaurantTransaction) {
        list.getRestaurantTrasactionlist().add(restaurantTransaction);
    	System.out.println("Adding a restaurantTransaction");
    	String insertSql = 
    			"Insert Into restaurantTransaction (" +
    			" date, "+
    			" customer_id, " +
    			"moneyCollected) " +
    			"VALUES (?, ?, ?)";
    	Object[] params = new Object[] {
    			restaurantTransaction.getDate(),
    			restaurantTransaction.getCustomer_id(),
    			restaurantTransaction.getMoneyCollected()
    	};
    	int[] types = new int[] { Types.VARCHAR, Types.INTEGER, Types.DOUBLE};
    	int row = jdbcTemplate.update(insertSql, params, types);
    	System.out.println(row + " row inserted.");
    	}
}
