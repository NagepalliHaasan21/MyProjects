package com.tap;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
	
	private Connection con;
	
	private String checkEmail = "SELECT * FROM CUSTOMER WHERE EMAIL=?";
	private PreparedStatement pstmt;
	private ResultSet res;
	
	@Override
	public void init() throws ServletException 
	{
		String url = "jdbc:mysql://localhost:3306/practice";
		String dbUn = "root";
		String dbPwd = "Haasan@21";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,dbUn,dbPwd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{ 
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		try
		{	
			pstmt = con.prepareStatement(checkEmail);
			pstmt.setString(1,email);
			res = pstmt.executeQuery();
			
			if(res.next())
			{
				if(password.equals(res.getString("password")))
				{
					//resp.getWriter().println("Hello "+res.getString("username"));
					//resp.sendRedirect("loginSuccess.html");
					String name = res.getString("username");
					//HttpSession session = req.getSession();
					
					email = res.getString("email");
					String mobile = res.getString("mobile");
					String address = res.getString("address");
					String city = res.getString("city");
					
					//session.setAttribute("name",name);
					req.setAttribute("name",name);
					req.setAttribute("email",email);
					req.setAttribute("mobile",mobile);
					req.setAttribute("address",address);
					req.setAttribute("city",city);
					
					//resp.sendRedirect("home.jsp");
					req.getRequestDispatcher("home.jsp").forward(req, resp);
				}
				else
				{
					resp.sendRedirect("passwordMismatch.html");
				}
			}
			else
			{
				resp.sendRedirect("invalidUser.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy() 
	{
		try
		{
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}






