package com.dao.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.dao.impl.StudentDAOImpl;
import com.dao.interfaces.StudentDAO;
import com.dao.model.Student;

public class Launch
{
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) 
	{
		StudentDAO sdao=new StudentDAOImpl();
		
		System.out.println("Welcome to Student App\n Enter your choice\n"
						+  "1. Insert Student\n"
				        +  "2. View Student List\n"
						+  "3. View Specific Student\n"
				        +  "4. Update Student\n"
						+  "5. Delete Student");
		
		int ch = sc.nextInt();
		
		switch(ch)
		{
		case 1:
			System.out.println("Enter ID : ");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Name : ");
			String name=sc.nextLine();
			System.out.println("Enter Marks : ");
			int marks=sc.nextInt();
			
			
			System.out.println(sdao.insert(new Student(id,name,marks))==1?"Success" : "Failure");
			break;
			
		case 2:
			for(Student s : sdao.fetchAll())
			{
				System.out.println(s);
			}
			break;
			
		case 3:
			System.out.println("Enter ID : ");
			id=sc.nextInt();
			System.out.println(sdao.fetchOne(id));
			break;
			
		case 4:
			System.out.println("Enter ID : ");
			id=sc.nextInt();
			System.out.println("Enter Marks : ");
			marks=sc.nextInt();
			System.out.println(sdao.update(id,marks)==1?"Update Success" : "Update Failure");
			break;
			
		case 5:
			System.out.println("Enter ID : ");
			id=sc.nextInt();
			System.out.println(sdao.delete(id)==1?"Delete Success" : "Delete Failure");
		}	
	}
}
//System.out.println("Update processed with status : " + sdao.update(2,99));
		//Student s=new Student(1,"Haasan",21);	
