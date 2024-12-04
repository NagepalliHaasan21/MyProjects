package com.foodappDAOImpl;

import java.util.ArrayList;

import com.foodapp.dao.interfaces.UserDAO;
import com.foodapp.dao.model.User;

public class UserDAOImpl implements UserDAO 
{

	@Override
	public int insertUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<User> fetchAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User fetchUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUser(String email, String password) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
