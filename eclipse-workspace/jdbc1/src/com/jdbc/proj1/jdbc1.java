package com.jdbc.proj1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc1 {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet resultSet=null;

		String sql_query="SELECT * FROM Employee";
		
		try {
			 con=MyConnection.connect();
		
			stmt=con.createStatement();
			
			resultSet=stmt.executeQuery(sql_query);
			
			while(resultSet.next())
			{
				System.out.println(
									resultSet.getInt("Id")+","
									+ resultSet.getString("name")+","
									+ resultSet.getString("email")+","
									+ resultSet.getString("mobile")
								  );
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
			
			
		finally
		{
			MyConnection.disconnect(resultSet,stmt,con);
		}
		
	}

}
