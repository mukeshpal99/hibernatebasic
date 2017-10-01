package com.hibernate.learning.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.learning.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try
		{
			// create a new student object
			System.out.println("creating a new student");
			Date date= null;
			Student tempStudent = new Student("test2", "user2", date, "test2@user2.com");
			
			// start a transaction
			session.beginTransaction();
			
			
			// save the student object
			session.save(tempStudent);
			
			// commit the student object
			session.getTransaction().commit();
			
			// New code to read data
			
			// find out the student primary key
			System.out.println("Saved student primary key: "+tempStudent.getId());
			
			
			// get a new session & start transaction
			 session = factory.getCurrentSession();
			 session.beginTransaction();
			
			// retrieve student base on primary id
			 System.out.println("Getting student with id: "+ tempStudent.getId());
			 Student myStudent = session.get(Student.class, tempStudent.getId());
			 
			 System.out.println("Get Complete: "+myStudent);
			
			// commit the transaction
			 session.getTransaction().commit();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			factory.close();
		}
		
		
	}

}
