package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.dbutil.DBConnection;
import com.dao.interfaces.StudentDAO;
import com.dao.model.Student;

public class StudentDAOImpl implements StudentDAO
{
	static ArrayList<Student> studentList = new ArrayList<Student>(); 
	private static final String INSERTQUERY = "insert into student(sid,sname,marks) values(?,?,?)";
	private static final String FETCHALL = "select * from student";
	private static final String FETCHONE = "select * from student where sid=?";
	private static final String UPDATE = "update student set marks=? where sid=?";
	private static final String DELETE = "delete from student where sid=?";
	
	static Connection con;
	
	static
	{
		con=DBConnection.connect();
	}

	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private Student s;

	@Override
	public int insert(Student s) 
	{
		try
		{
			pstmt=con.prepareStatement(INSERTQUERY);
			pstmt.setInt(1,s.getSid());
			pstmt.setString(2,s.getSname());
			pstmt.setInt(3,s.getMarks());
			
			return pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<Student> fetchAll()
	{
		try
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(FETCHALL);
			studentList=extractStudentListFromResultSet(resultSet);
			
//			while(resultSet.next())
//			{
//				studentList.add(
//						new Student(
//									resultSet.getInt("sid"),
//									resultSet.getString("sname"),
//									resultSet.getInt("marks")
//									)
//						);
//			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public Student fetchOne(int id)
	{
		try
		{
			pstmt=con.prepareStatement(FETCHONE);
			pstmt.setInt(1,id);
			resultSet=pstmt.executeQuery();
//			studentList=extractStudentListFromResultSet(resultSet);
			s=extractStudentListFromResultSet(resultSet).get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return s;
	}
	
  ArrayList<Student>extractStudentListFromResultSet(ResultSet resultSet)
  {
	  try
	  {
		  while(resultSet.next())
				{
					studentList.add(
							new Student(
										resultSet.getInt("sid"),
										resultSet.getString("sname"),
										resultSet.getInt("marks")
										)
							);
				}
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return studentList;
  }

	@Override
	public int update(int id, int marks) 
	{
		try
		{
			pstmt=con.prepareStatement(UPDATE);
			pstmt.setInt(1,marks);
			pstmt.setInt(2,id);
			
			return pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id)
	{
		try
		{
			pstmt=con.prepareStatement(DELETE);
			pstmt.setInt(1,id);
			
			return pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}	
	}
}
















