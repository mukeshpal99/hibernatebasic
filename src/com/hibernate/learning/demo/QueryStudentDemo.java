package com.hibernate.learning.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.learning.demo.entity.Student;

public class QueryStudentDemo {

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
			
			// start a transaction
			session.beginTransaction();
			
			// query student
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display student
			for(Student tempStudent: theStudents)
			{
				System.out.println(tempStudent);
			}
			
			theStudents = session.createQuery("from Student where id=5").getResultList();
			
			// display student
			for(Student tempStudent: theStudents)
			{
				System.out.println(tempStudent);
			}
			
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
