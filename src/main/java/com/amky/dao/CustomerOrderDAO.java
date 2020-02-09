package com.amky.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.amky.model.Customer;
import com.amky.model.CustomerOrder;
import com.amky.model.CustomerOrders;
import com.amky.model.Employee;

@Repository
public class CustomerOrderDAO {
	private static CustomerOrders list = new CustomerOrders();
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public CustomerOrders getAllCustomerOrders() {
		List customerOrderListFromQuery;

		customerOrderListFromQuery = jdbcTemplate.query("select * from customerOrder.customerOrder",
				(rs, rowNum) -> new CustomerOrder(rs.getInt("id"), rs.getInt("customer_id"), rs.getInt("orderNumber"),
						rs.getString("order"), rs.getInt("totalOrdercost"), rs.getInt("paid")));

		list.setCustomerOrdersList(null);
		for (int i = 0; i < customerOrderListFromQuery.size(); i++) {
			list.getCustomerOrderList().add((CustomerOrder) customerOrderListFromQuery.get(i));
			System.out.println(customerOrderListFromQuery.get(i).toString());

		}
		return list;
	}

	public void addCustomerOrder(CustomerOrder customerOrder) {
		list.getCustomerOrderList().add(customerOrder);
		System.out.println("Adding a customer");
		String insertSql = "Insert Into customer (" + " customer_id, " + " orderNumber, " + " order, "
				+ " totalOrderCost, " + "paid) " + "VALUES (?, ?, ?,?)";
		Object[] params = new Object[] { customerOrder.getCustomer_id(), customerOrder.getOrderNumber(),
				customerOrder.getOrder(), customerOrder.getTotalOrdercost(), customerOrder.getPaid() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		int row = jdbcTemplate.update(insertSql, params, types);
		System.out.println(row + " row inserted.");
	}

	public void updateCustomerOrder(CustomerOrder customerOrder) {
		System.out.println("Updating a customer order");
		String updateSql = "update customerorder set customer_id=?, orderNumber=?, orderItem=?, totalOrdercost=?,paid=? where id=?";
		Object[] params = new Object[] { customerOrder.getCustomer_id(), customerOrder.getOrderNumber(),
				customerOrder.getOrder(),customerOrder.getTotalOrdercost(), customerOrder.getPaid(),
				customerOrder.getId() };
		
		for(int i=0; i<params.length; i++) {
			System.out.println(params[i]);
		}

		int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.VARCHAR,Types.DOUBLE, Types.INTEGER,Types.INTEGER };

		int row = jdbcTemplate.update(updateSql, params, types);
		System.out.println(row + " row updated  .");
	}
}
