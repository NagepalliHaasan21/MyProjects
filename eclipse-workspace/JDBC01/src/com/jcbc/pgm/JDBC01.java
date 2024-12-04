package com.jcbc.pgm;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBC01
{
	public static void main(String[] args)
	{
		
		Connection con=null;
		Statement stmt=null;
		ResultSet resultSet=null;
		
		String sql_query="SELECT * FROM STUDENT";
		
		try
		{
			con=MyConnection.connect();
			
			stmt=con.createStatement();
			
			resultSet=stmt.executeQuery(sql_query);
			
			while(resultSet.next())
			{
				System.out.println( resultSet.getInt("id")+","
								  + resultSet.getString("name")+","
								  + resultSet.getString("email")+","
								  + resultSet.getString("mobile")
								  );
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			MyConnection.disconnect(resultSet,stmt,con);
		}
	}
}
