package com.bank.dbutil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.Scanner;

public class InvokeProcedure
{
	private static Scanner sc=new Scanner(System.in);
	private static Connection con;
	private static CallableStatement callstmt;

	public static void main(String[] args)
	{
		String callProcedure="{call checkcount(?,?)}";
		
		try
		{
			con=DBConnection.connect();
			callstmt=con.prepareCall(callProcedure);
			
			System.out.println("Enter the Amount over which u want the count");
			int amount=sc.nextInt();
			
			callstmt.setInt(1,amount);
			callstmt.registerOutParameter(2,Types.INTEGER);
			callstmt.execute();
			
			System.out.println("no of users whose balance is over " +
										amount+" are : "+callstmt.getInt(2));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
