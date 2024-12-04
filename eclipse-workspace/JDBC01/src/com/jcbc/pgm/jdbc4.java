package com.jcbc.pgm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class jdbc4 
{
	private static PreparedStatement pstmt;
	private static Connection con;
	private static String sql_update;
	public static void main(String[] args)
	{
		String sql_update="UPDATE STUDENT SET MOBILE=? WHERE ID=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the mobile no");
		String mobile=sc.nextLine();
		System.out.println("Enter the id");
		int id=sc.nextInt();
		
		try
		{
			con=MyConnection.connect();
			
			pstmt=con.prepareStatement(sql_update);
			pstmt.setInt(2,id);
			pstmt.setString(1,mobile);
			
			int status=pstmt.executeUpdate();
			
			if(status!=1)
			{
				System.out.println("Fail");
			}
			else
			{
				System.out.println("Success");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
