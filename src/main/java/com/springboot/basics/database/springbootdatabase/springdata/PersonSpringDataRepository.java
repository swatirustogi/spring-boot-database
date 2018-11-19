package com.springboot.basics.database.springbootdatabase.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.basics.database.springbootdatabase.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {

}
