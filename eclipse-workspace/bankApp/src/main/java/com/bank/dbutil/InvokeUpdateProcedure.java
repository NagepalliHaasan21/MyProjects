package com.bank.dbutil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.Scanner;

public class InvokeUpdateProcedure 
{
	private static Scanner sc=new Scanner(System.in);
	private static Connection con;
	private static CallableStatement callstmt;

	public static void main(String[] args)
	{
		String callProcedure="{call updatebalance(?,?)}";
		
		try
		{
			con=DBConnection.connect();
			callstmt=con.prepareCall(callProcedure);
			
			System.out.println("Enter the Amount to deposit");
			int amount=sc.nextInt();
			System.out.println("Enter the Amount number");
			int accNo=sc.nextInt();
			callstmt.setInt(1,amount);
			callstmt.setInt(2,accNo);
			if(callstmt.execute()==false)
			{
				if(callstmt.getUpdateCount()!=0)
				{
					System.out.println("Balance updated");
				}
				else
				{
					System.out.println("Balance not updated");
				}
			}
			else
			{
				System.out.println("result set is obtained");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
