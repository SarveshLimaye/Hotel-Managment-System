package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Employee;
import com.example.demo.entities.User;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	@Query("select u from Employee u where u.email = :email")
	public User getEmployeeByUserName(@Param("email") String email);

	public void save(User user);

}
