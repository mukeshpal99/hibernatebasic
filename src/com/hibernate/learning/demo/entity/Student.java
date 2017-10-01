package com.hibernate.learning.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.hibernate.learning.demo.DateUtils;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastNAme;
	
	@Column(name="date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Column(name="email")
	private String email;
	
	public Student()
	{
	
	}

	public Student(String firstName, String lastNAme, Date dateOfBirth, String email) {
		super();
		this.firstName = firstName;
		this.lastNAme = lastNAme;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNAme() {
		return lastNAme;
	}
	

	public void setLastNAme(String lastNAme) {
		this.lastNAme = lastNAme;
	}
	
	public Date getDateOfBirth(){
		return dateOfBirth;
	}
	
	public void setDateOfBirth( Date dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastNAme=" + lastNAme + ", email=" + email + 
				", dateOfBirth=" + DateUtils.formatDate(dateOfBirth)+"]";
	}

	

}
