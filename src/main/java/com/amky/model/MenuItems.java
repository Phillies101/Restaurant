package com.amky.model;

import java.util.ArrayList;
import java.util.List;

public class MenuItems {
	 private List<MenuItem> menuItemList;
     
	    public List<MenuItem> getMenuItemList() {
	        if(menuItemList == null) {
	        	menuItemList = new ArrayList<MenuItem>();
	        }
	        return menuItemList;
	    }
	  
	    public void setMenuItemList(List<MenuItem> menuItemList) {
	        this.menuItemList = menuItemList;
	       
	        }
	    public int getCount() {
	    	if(menuItemList !=null)
	    		return menuItemList.size();
	    		else
	    			return 0;
	    }
}
