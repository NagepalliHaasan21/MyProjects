package jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc3 
{

	public static void main(String[] args)
	{	
		Connection con=null;
		Statement stmt=null;
		ResultSet resultSet=null;
		
		String sql_query="SELECT * FROM STUDENT";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcnov","root","Haasan@21");
			
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
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}

}
