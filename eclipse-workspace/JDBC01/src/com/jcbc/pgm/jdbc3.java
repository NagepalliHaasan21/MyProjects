package com.jcbc.pgm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class jdbc3 
{

	private static PreparedStatement pstmt;
	private static Connection con;
	private static ResultSet resultSet;

	public static void main(String[] args)
	{
		String fetchOne="SELECT * FROM STUDENT WHERE id=?";
		
		System.out.println("Enter the ID whose details you need");
		
		int id=new Scanner(System.in).nextInt();
		
		try
		{
			con=MyConnection.connect();
			
			pstmt=con.prepareStatement(fetchOne);
			pstmt.setInt(1,id);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				System.out.println( resultSet.getInt("id")+","
								  + resultSet.getString("name")+","
								  + resultSet.getString("email")+","
								  + resultSet.getString("mobile")
								  );
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
