package com.jcbc.pgm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection 
{
	static Connection con;
	static String url="jdbc:mysql://localhost:3306/jdbcnov";
	static String username="root";
	static String password="Haasan@21";
	static Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loaded");
			
			con=DriverManager.getConnection(url,username,password);
			System.out.println("connection to DB is established");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	static void disconnect(ResultSet resultset,Statement stmt,Connection con) {
		try {
			if(resultset!=null) {
				resultset.close();
				System.out.print("ResultSet is closed");
			}
			else{
				System.out.print("not attempted");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try {
			if(stmt!=null) {
				stmt.close();
				System.out.println("Statement is cosed");
			}
			else {
				System.out.print("statement is null-so didnt attempt to close");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try {
			if(con!=null) {
				con.close();
				System.out.println("connection is closed");
			}
			else {
				System.out.println("connection is null-so didnt attempt to close");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
