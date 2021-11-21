package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Rooms;


public interface RoomRepository extends JpaRepository<Rooms, Integer>{

}
