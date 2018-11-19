package com.springboot.basics.database.springbootdatabase.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.basics.database.springbootdatabase.entity.Person;

@Repository
public class PersonJdbcDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	//select * from person
	public List<Person> findAll()
	{
		return(jdbcTemplate.query("select * from PERSON",
				new BeanPropertyRowMapper<Person>(Person.class)));
	}
	public Person findById(int id)
	{
		return(jdbcTemplate.queryForObject("select * from PERSON where id = ?",
				new Object[] {id},
				new BeanPropertyRowMapper<Person>(Person.class)));
	}

}
