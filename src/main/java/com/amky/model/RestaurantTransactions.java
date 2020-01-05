package com.amky.model;

import java.util.ArrayList;
import java.util.List;

public class RestaurantTransactions {
	private List<RestaurantTransaction> restaurantTrasactionlist;
	
	public List<RestaurantTransaction> getRestaurantTrasactionlist(){
		if(restaurantTrasactionlist == null) {
			restaurantTrasactionlist = new ArrayList<RestaurantTransaction>();
        }
        return restaurantTrasactionlist;
    }
  
    public void setRestaurantTrasactionlist(List<RestaurantTransaction> restaurantTrasactionlist) {
        this.restaurantTrasactionlist = restaurantTrasactionlist;
       
        }
    public int getCount() {
    	if(restaurantTrasactionlist !=null)
    		return restaurantTrasactionlist.size();
    		else
    			return 0;
    }
}
