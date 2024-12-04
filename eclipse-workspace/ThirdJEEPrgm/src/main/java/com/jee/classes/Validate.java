package com.jee.classes;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Validate extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String name = req.getParameter("name");
		if(name.equals(null) && name.length()<2)
		{
			resp.sendRedirect("error.html");
		}
		else
		{
			resp.sendRedirect("CollectData");
		}
	}
}
