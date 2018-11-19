package com.springboot.basics.database.springbootdatabase.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.basics.database.springbootdatabase.entity.Person;

//Repository
@Repository
//Transaction Mgmt
@Transactional
public class PersonJpaRepository {
	
	//Connect to the DB
	@PersistenceContext
	EntityManager entityManager;
	public Person findById(int id)
	{
		return entityManager.find(Person.class, id); //JPA
		
	}
	
	public Person update(Person person)
	{
		return entityManager.merge(person);
	}

	public Person insert(Person person)
	{
		return entityManager.merge(person);
	}
	public void deleteById(int id)
	{
		Person person = findById(id);
		entityManager.remove(person);
	}
	
	public List<Person> findAll()
	{
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons",Person.class);
		return namedQuery.getResultList();
	}
}
