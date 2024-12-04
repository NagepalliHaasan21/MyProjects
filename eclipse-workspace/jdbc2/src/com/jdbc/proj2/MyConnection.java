package com.jdbc.proj2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {
	static Connection con;
	static String url="jdbc:mysql://localhost:3306/jdbcnov";
	static String username="root";
	static String password="Haasan@21";
	
	static Connection connect()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is Loaded");
			
			con=DriverManager.getConnection(url,username,password);
			System.out.println("Connection is established");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
	
	static void disconnect(ResultSet resultSet, Statement stmt, Connection con)
	{
		try
		{
			if(resultSet!=null)
			{
				resultSet.close();
			}
			else
			{
				System.out.println("not attempted");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			if(stmt!=null)
			{
				stmt.close();
				System.out.println("Statement is closed");
			}
			else
			{
				System.out.println("Connection is null- so didn't attempt to close");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try
		{
			if(con!=null)
			{
				con.close();
				System.out.println("Connection is closed");
			}
			else
			{
				System.out.println("Connection is null- so didn't attempt to close");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
