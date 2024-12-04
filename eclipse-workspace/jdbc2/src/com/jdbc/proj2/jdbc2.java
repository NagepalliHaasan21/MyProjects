package com.jdbc.proj2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc2 {

	public static void main(String[] args) {
		int status;
		String url="jdbc:mysql://localhost:3306/jdbcnov";
		String username="root";
		String password="Haasan@21";
		Connection con;
		Statement stmt;
		
		String sql_query="INSERT INTO " + "'EMPLOYEE'('id','name','email','mobile')"
				+ "VALUES(7,'Dhoni','dh@gmail.com','7777')";
		
		try
		{

			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,username,password);
			
			stmt=con.createStatement();
			
			status=stmt.executeUpdate(sql_query);
			
			if(status==1)
			{
				System.out.println("Data inserted");
			}
			else {
				System.out.println("Failure to insert data");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
