package com.DAO.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
	private static Connection con;

	public static Connection connect()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DAOExmp","root","Haasan@21");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
