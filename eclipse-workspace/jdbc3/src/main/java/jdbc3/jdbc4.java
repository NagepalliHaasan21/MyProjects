package jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class jdbc4
{

	public static void main(String[] args)
	{
		Connection con;
		PreparedStatement pstmt;
		String url="jdbc:mysql://localhost:3306/jdbcnov";
		String username="root";
		String password="Haasan@21";
		
		String insert="INSERT INTO STUDENT(ID,NAME,EMAIL,MOBILE) VALUES(?,?,?,?)";
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the ID");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Name");
		String name=sc.nextLine();
		System.out.println("Enter the Email");
		String email=sc.nextLine();
		System.out.println("Enter the Mobile");
		String mobile=sc.nextLine();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcnov","root","Haasan@21");
			
			pstmt=con.prepareStatement(insert);
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setString(3,email);
			pstmt.setString(4,mobile);
			
			int x=pstmt.executeUpdate();
			
			if(x!=0)
			{
				System.out.println("Success");
			}
			else
			{
				System.out.println("Failure");
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
