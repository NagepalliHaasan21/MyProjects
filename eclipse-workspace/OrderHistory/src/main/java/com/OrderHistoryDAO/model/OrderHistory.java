package com.OrderHistoryDAO.model;

import java.time.LocalDateTime;

public class OrderHistory 
{
	private int orderhistoryid;
	private int ordersid;
	private int userid;	
	private float totalamount;
	private String status;
	private LocalDateTime orderDate;
	
	public int getOrderhistoryid() {
		return orderhistoryid;
	}
	public void setOrderhistoryid(int orderhistoryid) {
		this.orderhistoryid = orderhistoryid;
	}
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
	public float getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(float totalamount) {
		this.totalamount = totalamount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	
	public OrderHistory() {
		super();
	}
	
	public OrderHistory(int orderhistoryid, int ordersid, int userid, float totalamount, String status,
			LocalDateTime orderDate) {
		super();
		this.orderhistoryid = orderhistoryid;
		this.ordersid = ordersid;
		this.userid = userid;
		this.totalamount = totalamount;
		this.status = status;
		this.orderDate = orderDate;
	}
	
	@Override
	public String toString() 
	{
		return  orderhistoryid + "    " + ordersid + "     " + userid
				+ "    " + totalamount + "    " + status + "     " + orderDate;
	}
}
