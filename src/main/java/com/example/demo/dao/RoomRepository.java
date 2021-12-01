package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Rooms;
import com.example.demo.entities.User;


public interface RoomRepository extends JpaRepository<Rooms, Integer>{
	@Query("select u from Rooms u where u.cId = :cId")
	public List<Rooms> getUserByCId(@Param("cId") int cId);
}
