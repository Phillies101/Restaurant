package com.amky.model;

public class CustomerOrder {
	private int id;
	private int customer_id;
	private int orderNumber;
	private String order;
	private int totalOrdercost;
	private int paid;
public CustomerOrder() {
	
}
public CustomerOrder(int id,int customer_id,int orderNumber,String order, int totalOrdercost,int paid) {
	this.id=id;
	this.customer_id=customer_id;
	this.orderNumber=orderNumber;
	this.order=order;
	this.totalOrdercost=totalOrdercost;
	this.paid=paid;
}
@Override
public String toString() {
    return "Customer [id=" + id + "customer_id=" + customer_id + "orderNumber" + orderNumber + ", order=" + order + ", total=" + totalOrdercost + ", paid=" + paid + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
public int getOrderNumber() {
	return orderNumber;
}
public void setOrderNumber(int orderNumber) {
	this.orderNumber = orderNumber;
}
public String getOrder() {
	return order;
}
public void setOrder(String order) {
	this.order = order;
}
public int getTotalOrdercost() {
	return totalOrdercost;
}
public void setTotalOrdercost(int totalOrdercost) {
	this.totalOrdercost = totalOrdercost;
}
public int getPaid() {
	return paid;
}
public void setPaid(int paid) {
	this.paid = paid;
}
}