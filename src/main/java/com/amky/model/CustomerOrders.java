package com.amky.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrders {
	 private List<CustomerOrder> customerOrderList;
     
	    public List<CustomerOrder> getCustomerOrderList() {
	        if(customerOrderList == null) {
	            customerOrderList = new ArrayList<CustomerOrder>();
	        }
	        return customerOrderList;
	    }
	  
	    public void setCustomerOrdersList(List<Employee> employeeList) {
	        this.customerOrderList = customerOrderList;
	       
	        }
	    public int getCount() {
	    	if(customerOrderList !=null)
	    		return customerOrderList.size();
	    		else
	    			return 0;
	    }
}
