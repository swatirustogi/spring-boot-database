package com.springboot.basics.database.springbootdatabase.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.basics.database.springbootdatabase.entity.Person;

@Repository
public class PersonJdbcDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
		
	
	class PersonRowMapper implements RowMapper<Person>
	{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Person person = new Person();
			person.setId(rs.getInt("ID"));
			person.setName(rs.getString("NAME"));
			person.setLocation(rs.getString("LOCATION"));
			person.setbirthdate(rs.getTimestamp("BIRTHDATE"));
			
			return null;
		}
		
	}
	//select * from person
	public List<Person> findAll()
	{
		return(jdbcTemplate.query("select * from PERSON",new PersonRowMapper()));
	}
	public Person findById(int id)
	{
		return(jdbcTemplate.queryForObject("select * from PERSON where id = ?",
				new Object[] {id},
				new BeanPropertyRowMapper<Person>(Person.class)));
	}
	public int deleteById(int id)
	{
		return(jdbcTemplate.update("delete from PERSON where id =?" , 
				new Object[] {id}));
	}
	public int insert(Person person)
	{
		return(jdbcTemplate.update("INSERT INTO PERSON (id, name, location, birthdate) " + 
				"VALUES(?, ?, ?,?)",new Object[] {person.getId(),person.getName(),
				person.getLocation(),new java.sql.Timestamp(person.getbirthdate().getTime())}));
		
	}
	
	public int update(Person person)
	{
		return(jdbcTemplate.update("UPDATE PERSON "
				+ "set name = ?, location = ?, birthdate = ?" + " where id = ?", 
				new Object[] {person.getName(),person.getLocation(),
						new java.sql.Timestamp(person.getbirthdate().getTime()), person.getId()}));
	}	
	
	
}	