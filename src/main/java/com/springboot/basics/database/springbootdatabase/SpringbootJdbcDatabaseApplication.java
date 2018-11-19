package com.springboot.basics.database.springbootdatabase;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.basics.database.springbootdatabase.entity.Person;
import com.springboot.basics.database.springbootdatabase.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringbootJdbcDatabaseApplication implements CommandLineRunner{

	@Autowired
	PersonJdbcDao dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJdbcDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("All users {}",dao.findAll());
		logger.info("User info {}",dao.findById(10001));
		logger.info("User deleted no of rows deleted {}",dao.deleteById(10002));
		logger.info("inserting User {}",dao.insert(new Person(10004, "Sara", "Toronto",new Date())));
		logger.info("Update User {}",dao.update(new Person(10003, "Peter", "Toronto",new Date())));
		
	}
}
