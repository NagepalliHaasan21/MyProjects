package com.OrderItemsDAO.interfaces;

import java.util.ArrayList;

import com.OrderItemsDAO.model.OrderItems;

public interface OrderItemsDAO
{
	int insertOrderItems(OrderItems  oi);
	int deleteOrderItems(int orderItemsid);
	ArrayList<OrderItems> fetchAllOrderItems();
	OrderItems fetchOrderItems(OrderItems oi);
}
