package com.foodapp.dao.interfaces;

import java.util.ArrayList;

import com.foodapp.dao.model.User;

public interface UserDAO
{
	int insertUser(User u);
	int deleteUser(String email);
	ArrayList<User> fetchAllUsers();
	User fetchUser(String email);
	int updateUser(String email,String password);
}
