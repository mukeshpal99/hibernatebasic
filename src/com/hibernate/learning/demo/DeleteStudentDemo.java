package com.hibernate.learning.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.learning.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			int studentId=3;	
			
			// retrive student based on primary key
			System.out.println("\nGetting the student with id: "+studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			// Delete the student
			System.out.println("Deleting the student: ");
			session.delete(myStudent);
			
			
			// commit the student object
			session.getTransaction().commit();
			
			System.out.println("Done!");
		
			//Alternate delete using update query
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			
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
