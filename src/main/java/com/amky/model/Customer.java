package com.amky.model;

public class Customer {
	private String username;
	private String password;
	private int id;
	private String name;
	private String address;
	private int phone;
	private double totalSpend;
	public Customer(String username, String password, int id, String name, String address,int phone,double totalSpend) {
		super();
		this.username=username;
		this.password=password;
		this.id=id;
		this.name=name;
		this.address=address;
		this.phone=phone;
		this.totalSpend=totalSpend;
	}
	 public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTotalSpend(double totalSpend) {
		this.totalSpend = totalSpend;
	}
	@Override
	    public String toString() {
	        return "Customer [id=" + id + "name=" + name + "address" + address + ", phone=" + phone + ", totalSpend=" + totalSpend + "]";
	    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public double getTotalSpend() {
		return totalSpend;
	}
	public void setTotalSpend(int totalSpend) {
		this.totalSpend = totalSpend;
	}
	
}
