package com.demo.jpa.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);
    List<User> findByAge(Integer age);
    List<User> findByNameAndAge(String name, Integer age);
    
}
