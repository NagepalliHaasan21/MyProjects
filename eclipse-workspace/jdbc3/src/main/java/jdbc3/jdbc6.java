package jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class jdbc6 
{
	private static ResultSetMetaData rsmd;
	private static ResultSet resultset;


	public static void main(String[] args)
	{
		Connection con;
		Statement stmt;
		String url="jdbc:mysql://localhost:3306/world";
		String username="root";
		String password="Haasan@21";
		
		String select="SELECT * FROM CITY";
		
		try
		{
			//load
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establish
			con = DriverManager.getConnection(url,username,password);
			//create stmt
			stmt=con.createStatement();
			
			resultset=stmt.executeQuery(select); 
			
			rsmd=resultset.getMetaData();
			
			for(int i=1;i<=rsmd.getColumnCount();i++)
			{
				System.out.println("Column "+i);
				System.out.println("Column Name : "+rsmd.getColumnName(i));
				System.out.println("Column Label : "+rsmd.getColumnLabel(i));
				System.out.println("Column Type : "+rsmd.getColumnType(i));
				System.out.println("Column Type Name : "+rsmd.getColumnTypeName(i));
				System.out.println("\n\n\n");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
