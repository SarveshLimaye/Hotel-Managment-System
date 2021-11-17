package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	

}
