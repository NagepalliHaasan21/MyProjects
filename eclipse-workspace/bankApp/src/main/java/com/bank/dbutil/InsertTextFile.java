package com.bank.dbutil;

import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertTextFile
{

	static String query="Update accounttable set about=? where cid=?";
	private static Connection con;
	private static PreparedStatement pstmt;

	public static void main(String[] args)
	{
		try
		{
			int id=1;
			
			FileReader fr=new FileReader("C:\\Users\\DELL\\Documents\\text.txt");
			
			con=DBConnection.connect();
			
			pstmt=con.prepareStatement(query);
			pstmt.setInt(2,id);
			pstmt.setCharacterStream(1,fr);
			
			if(pstmt.executeUpdate()!=0)
			{
				System.out.println("Text inserted");
			}
			else
			{
				System.out.println("Text not inserted");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
