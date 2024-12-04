package com.dao.interfaces;

import java.util.ArrayList;

import com.dao.model.Student;

public interface StudentDAO
{
	int insert(Student s);
	ArrayList<Student> fetchAll();
	Student fetchOne(int i);
	int update(int id,int marks);
	int delete(int id);
}
