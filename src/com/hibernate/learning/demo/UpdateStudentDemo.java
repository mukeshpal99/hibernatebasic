package com.hibernate.learning.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.learning.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		
		
		
		try
		{
			
			// create session & start transaction
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			int studentId=4;
			
			// retrive student based on primary key
			System.out.println("\nGetting the student with id: "+studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			// update the student
			System.out.println("Updating the student: ");
			myStudent.setFirstName("Support");
			
			
			// commit the student object
			session.getTransaction().commit();
		
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email='support@user.com'").executeUpdate();
			
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
