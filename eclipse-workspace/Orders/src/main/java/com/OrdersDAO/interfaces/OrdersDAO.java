package com.OrdersDAO.interfaces;

import java.util.ArrayList;

import com.OrdersDAO.model.Orders;

public interface OrdersDAO 
{
	int insertOrder(Orders o);
	int deleteOrder(int orderid);
	ArrayList<Orders> fetchAllOrders();
	Orders fetchOrderByid(Orders o);
}
