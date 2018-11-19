package com.springboot.basics.database.springbootdatabase.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
@NamedQuery(name="find_all_persons", query="select p from Person p")
public class Person {
	@Id
	@GeneratedValue
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="LOCATION")
	private String location;
	@Column(name="BIRTHDATE")
	private Date birthdate;
	
	public Person() {}
	
	public Person(int id, String name, String location, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthdate = birthdate;	
		
	}
	
	public Person(String name, String location, Date birthdate) {
		super();
		this.name = name;
		this.location = location;
		this.birthdate = birthdate;	
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getbirthdate() {
		return birthdate;
	}
	public void setbirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", location=" + location + ", birthdate=" + birthdate + "]\n";
	}
	
	
	
	
}
