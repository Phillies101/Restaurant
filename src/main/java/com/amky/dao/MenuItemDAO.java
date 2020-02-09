package com.amky.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.amky.model.CustomerOrder;
import com.amky.model.MenuItem;
import com.amky.model.MenuItems;
@Repository
public class MenuItemDAO {
	private static MenuItems list = new MenuItems();
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public MenuItems getAllMenuItems() {
    	List menuItemListFromQuery;
    	
    	menuItemListFromQuery = jdbcTemplate.query("select * from menuitem.menuitem",
    					(rs, rowNum ) ->
    						new MenuItem(
    								rs.getInt("id"),
    								rs.getString("name"),
    								rs.getInt("price"),
    								rs.getInt("available")
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
    			menuItem.getAvailable()
    	};
    	int[] types = new int[] { Types.VARCHAR, Types.DOUBLE, Types.INTEGER};
    	int row = jdbcTemplate.update(insertSql, params, types);
    	System.out.println(row + " row inserted.");
    	}
    public void updateMenuItem(MenuItem menuItem) {
		System.out.println("Updating a menu item");
		String updateSql = "update menuItem set name=?, price=?, available=? where id=?";
		Object[] params = new Object[] { menuItem.getName(), menuItem.getPrice(), menuItem.getAvailable(),
				menuItem.getId() };

		int[] types = new int[] { Types.VARCHAR, Types.DOUBLE, Types.INTEGER,Types.INTEGER};

		int row = jdbcTemplate.update(updateSql, params, types);
		System.out.println(row + " row updated  .");
	}
}
