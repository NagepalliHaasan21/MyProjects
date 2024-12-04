package jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class jdbc5 
{

	public static void main(String[] args)
	{
		Connection con;
		PreparedStatement pstmt;
		String url="jdbc:mysql://localhost:3306/jdbcnov";
		String username="root";
		String password="Haasan@21";
		
		String update="UPDATE STUDENT SET MARKS=? WHERE ID=?";
		
		Scanner sc=new Scanner(System.in);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcnov","root","Haasan@21");
			
			pstmt=con.prepareStatement(update);
			
			for(int i=1;i<=7;i++)
			{
				System.out.println("Enter the ID");
				int id=sc.nextInt();
				System.out.println("Enter the Marks");
				int marks=sc.nextInt();
				
				pstmt.setInt(1,marks);
				pstmt.setInt(2,id);
				int x=pstmt.executeUpdate();
				pstmt.addBatch();
			}
			int arr[]=pstmt.executeBatch();
			
			for(int i=1;i<arr.length-1;i++)
			{
				System.out.println("Status of query "+i+" is "+arr[i]);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
