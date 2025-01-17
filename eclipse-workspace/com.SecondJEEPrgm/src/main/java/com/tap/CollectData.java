package com.tap;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CollectData extends HttpServlet
{
	private Connection con;
	private PreparedStatement pstmt;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		String city = req.getParameter("city");
		String password = req.getParameter("password");
		
		String insert = "insert into customer(username,email,mobile,address,city,password) values(?,?,?,?,?,?)";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","Haasan@21");
			
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1,username);
			pstmt.setString(2,email);
			pstmt.setString(3,mobile);
			pstmt.setString(4,address);
			pstmt.setString(5,city);
			pstmt.setString(6,password);
			
			int x= pstmt.executeUpdate();
			
			
			if(x==0)
			{
				resp.sendRedirect("failure.html");
			}
			else
			{
				resp.sendRedirect("success.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}