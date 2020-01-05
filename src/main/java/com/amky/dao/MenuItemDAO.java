package com.amky.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.amky.model.MenuItem;
import com.amky.model.MenuItems;

public class MenuItemDAO {
	private static MenuItems list = new MenuItems();
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public MenuItems getAllMenuItems() {
    	List menuItemListFromQuery;
    	
    	menuItemListFromQuery = jdbcTemplate.query("select * from menuItem.menuItem",
    					(rs, rowNum ) ->
    						new MenuItem(
    								rs.getInt("id"),
    								rs.getString("name"),
    								rs.getInt("price"),
    								rs.getBoolean("available")
    								)
    						);
    						
    					list.setMenuItemList(null);
    					for(int i=0;i<menuItemListFromQuery.size();i++) {
    						list.getMenuItemList().add((MenuItem)menuItemListFromQuery.get(i));
    						System.out.println(menuItemListFromQuery.get(i).toString());
    						
    					}
    					return list;
    }
     
    public void addMenuItem(MenuItem menuItem) {
        list.getMenuItemList().add(menuItem);
    	System.out.println("Adding a menuItem");
    	String insertSql = 
    			"Insert Into menuItem (" +
    			" name, "+
    			" price, " +
    			"available) " +
    			"VALUES (?, ?, ?)";
    	Object[] params = new Object[] {
    			menuItem.getName(),
    			menuItem.getPrice(),
    			menuItem.isAvailable()
    	};
    	int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
    	int row = jdbcTemplate.update(insertSql, params, types);
    	System.out.println(row + " row inserted.");
    	}
}
