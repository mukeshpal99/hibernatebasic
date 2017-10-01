package com.hibernate.learning.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.learning.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		
		// create session & start a transaction
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		try
		{
			// create a new student object
			System.out.println("creating a new student");
			Student tempStudent = new Student("user1", "lastname", DateUtils.parseDate("31/12/1998"), "test@user.com");			
			
			// save the student object
			System.out.println("Saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit the student object
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
