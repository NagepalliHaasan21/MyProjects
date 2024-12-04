package com.tap.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC1PRACTICE {
	public static void min(String[] args) {
		Connection con;
		Statement stmt;
		ResultSet resultSet;
		String url="jdbc:mysql://localhost:3306/jdbcnov2";
		String username="root";
		String password="Haasan@21";
		String sql_query="SELECR* FROM STUDENT";
	try {
		Class.forName("com.mysql.cj.jdbc1practice.Driver");
		System.out.println("Driver class is loaded");
		con=DriverManager.getConnection(url,username,password);
		System.out.println("Connection to Db is establishes");
		stmt = con.createStatement();
		
		resultSet=stmt.executeQuery(sql_query);
		
		while(resultSet.next()) {
			System.out.println(
						resultSet.getInt(1)+","
						+resultSet.getString(2)+","
						+resultSet.getString(3)+","
						+resultSet.getInt(4)
					);
		}
		
	}
	catch(ClassNotFoundException | SQLException e){
		e.printStackTrace();
	}


  }
}
