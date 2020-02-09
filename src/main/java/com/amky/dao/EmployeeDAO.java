package com.amky.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.amky.model.*;

@Repository
public class EmployeeDAO {
	private static Employees list = new Employees();
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * static { list.getEmployeeList().add(new Employee(1, "Lokesh", "Gupta",
	 * "lgupta@gmail.com")); list.getEmployeeList().add(new Employee(2, "Alex",
	 * "Kolenchiskey", "abc@gmail.com")); list.getEmployeeList().add(new Employee(3,
	 * "David", "Kameron", "titanic@gmail.com")); }
	 * 
	 * public Employees getAllEmployees() { return list; }
	 */

	public Employees getAllEmployees() {
		List employeeListFromQuery;

		employeeListFromQuery = jdbcTemplate.query("select * from emplyee.employee",
				(rs, rowNum) -> new Employee(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("email")));

		list.setEmployeeList(null);
		for (int i = 0; i < employeeListFromQuery.size(); i++) {
			list.getEmployeeList().add((Employee) employeeListFromQuery.get(i));
			System.out.println(employeeListFromQuery.get(i).toString());

		}
		return list;
	}

	public void addEmployee(Employee employee) {
		// list.getEmployeeList().add(employee);
		System.out.println("Inserting an employee" + employee.getFirstName() + " " + employee.getLastName() + " "
				+ employee.getEmail() + " " + employee.getId());
		String insertSql = "Insert Into employee (" + " firstName, " + " lastName, " + "email) " + "VALUES (?, ?, ?)";
		Object[] params = new Object[] { employee.getFirstName(), employee.getLastName(), employee.getEmail() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER };
		int row = jdbcTemplate.update(insertSql, params, types);
		System.out.println(row + " row inserted.");
	}

	public void updateEmployee1(Employee employee) {
        System.out.println("Updating an employee");
         String updateSql =
                 "update employee set firstname=?, lastName=?, email=? where id=?";
         
         Object[] params = new Object[] { employee.getFirstName(),
                                          employee.getLastName(),
                                          employee.getEmail(),
                                         employee.getId()
                                        };
         
        // define SQL types of the arguments
    int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER };
 
    int row = jdbcTemplate.update(updateSql, params, types);
    System.out.println(row + " row updated    .");
    }
	
	public void updateEmployee(Employee employee) {
		System.out.println("Updating an employee");
		String updateSql = "update employee set firstName=?, lastName=?, email=? where id=?";
		Object[] params = new Object[] { employee.getFirstName(), employee.getLastName(), employee.getEmail(),
				employee.getId() };

		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER };

		int row = jdbcTemplate.update(updateSql, params, types);
		System.out.println(row + " row updated  .");
	}
}
