package com.OrdersDAO.model;

import java.time.LocalDateTime;

public class Orders
{
	private int ordersid;
	private int userid;
	private int restaurantid;	
	private LocalDateTime orderDate;
	private float totalAmount;
	private String status;
	private String paymentmode;
	
	public int getOrdersid() {
		return ordersid;
	}
	public void setOrdersid(int ordersid) {
		this.ordersid = ordersid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	
	public Orders() {
		super();
	}
	
	public Orders(int ordersid, int userid, int restaurantid, LocalDateTime orderDate, float totalAmount, String status,
			String paymentmode) {
		super();
		this.ordersid = ordersid;
		this.userid = userid;
		this.restaurantid = restaurantid;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentmode = paymentmode;
	}
	
	@Override
	public String toString() 
	{
		return ordersid + "   " + userid + "    " + restaurantid + "    "
				+ orderDate + "    " + totalAmount + "    " + status + "     " + paymentmode;
	}	
}
