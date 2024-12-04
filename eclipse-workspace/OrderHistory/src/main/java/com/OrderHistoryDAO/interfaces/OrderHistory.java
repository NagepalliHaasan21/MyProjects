package com.OrderHistoryDAO.interfaces;

import java.util.ArrayList;

public interface OrderHistory
{
	int insertOrderHistory(OrderHistory oh);
	int deleteOrderHistory(int orderhistoryid);
	ArrayList<OrderHistory> fetchAllOrderHistory();
	ArrayList<OrderHistory> fetchOrderHistory(int userid);
}
