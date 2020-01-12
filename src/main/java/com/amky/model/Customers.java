package com.amky.model;

import java.util.ArrayList;
import java.util.List;

public class Customers {
	 private List<Customer> customerList;
     
	    public List<Customer> getCustomerList() {
	        if(customerList == null) {
	            customerList = new ArrayList<Customer>();
	        }
	        return customerList;
	    }
	  
	    public void setCustomerList(List<Customer> customerList) {
	        this.customerList = customerList;
	       
	        }
	    public int getCount() {
	    	if(customerList !=null)
	    		return customerList.size();
	    		else
	    			return 0;
	    }
}
