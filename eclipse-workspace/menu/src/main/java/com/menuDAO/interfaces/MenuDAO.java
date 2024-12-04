package com.menuDAO.interfaces;

import java.util.ArrayList;

import com.menuDAO.model.Menu;

public interface MenuDAO 
{
	int insertMenu(Menu  m);
	int deleteMenu(int menuid);
	ArrayList<Menu> fetchAllMenu();
	ArrayList<Menu> fetchMenuById(int restaurantid);
	Menu fetchMenuByItemId(int menuid);
}
