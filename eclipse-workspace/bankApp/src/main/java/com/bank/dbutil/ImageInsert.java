package com.bank.dbutil;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ImageInsert 
{
	static String query="Update accounttable set image=? where cid=?";
	private static Connection con;
	private static PreparedStatement pstmt;
	public static void main(String[] args)
	{
		try
		{
			int id=1;
			FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\Pictures\\Saved Pictures\\pic.png");
			
			con=DBConnection.connect();
			
			pstmt=con.prepareStatement(query);
			pstmt.setInt(2,id);
			pstmt.setBinaryStream(1,fis);
			
			if(pstmt.executeUpdate()!=0)
			{
				System.out.println("Image inserted");
			}
			else
			{
				System.out.println("Image not inserted");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
