package com.RestaurantDAO.interfaces;

import java.util.ArrayList;

import com.RestaurantDAO.interfaces.model.Restaurant;

public interface RestaurantDAO
{
	int insertRes(Restaurant r);
	int deleteRes(int restaurantid);
	ArrayList<Restaurant> fetchAllRes();
	Restaurant fetchRes(int restaurantid);
	int updateRestOnId(Restaurant r);
}
