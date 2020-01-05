package com.amky.model;

public class RestaurantTransaction {
	private int id;
	private String date;
	private int customer_id;
	private double moneyCollected;
	public RestaurantTransaction(){
		
	}
	public RestaurantTransaction(int id, String date, int customer_id,double moneyCollected) {
		this.id=id;
		this.customer_id=customer_id;
		this.moneyCollected=moneyCollected;
		this.date=date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public double getMoneyCollected() {
		return moneyCollected;
	}
	public void setMoneyCollected(double moneyCollected) {
		this.moneyCollected = moneyCollected;
	}
}
