package com.springboot.basics.database.springbootdatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.basics.database.springbootdatabase.jdbc.PersonJdbcDao;

@SpringBootApplication
public class SpringbootDatabaseApplication implements CommandLineRunner{

	@Autowired
	PersonJdbcDao dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("All users {}",dao.findAll());
		logger.info("User info {}",dao.findById(10001));
		
	}
}
