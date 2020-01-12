package com.amky.model;

public class MenuItem {
	private int id;
	private String name;
	private double price;
	private int available;
	public MenuItem(int id, String name, double price, int available) {
		this.id=id;
		this.name=name;
		this.price=price;
		this.available=available;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	

	
}
