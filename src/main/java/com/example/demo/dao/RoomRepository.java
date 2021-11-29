package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Rooms;
import com.example.demo.entities.User;


public interface RoomRepository extends JpaRepository<Rooms, Integer>{
}
