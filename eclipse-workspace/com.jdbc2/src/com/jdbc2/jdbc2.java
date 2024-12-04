package com.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc2 
{

	public static void main(String[] args)
	{
		Connection con=null;
		Statement stmt=null;
		int status;
		String url="jdbc:mysql://localhost:3306/jdbcnov";
		String username="root";
		String password="Haasan@21";
		String sql_query="INSERT INTO " 
							+ "STUDENT(id,name,email,mobile)"
							+ "VALUES(6,'saha','saha@gmail.com','6667777')";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,username,password);
			
			stmt=con.createStatement();
			
			status=stmt.executeUpdate(sql_query);
			
			if(status==1)
			{
				System.out.println("Data inserted");
			}
			else
			{
				System.out.println("Failure to insert data");
			}	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt!=null)
				{
					stmt.close();
					System.out.println("Statement is closed");
				}
				else
				{
					System.out.println("Statement is null- so didn't attempt to close");
				}
			}
			catch(Exception e)
			{
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
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

	}

}
