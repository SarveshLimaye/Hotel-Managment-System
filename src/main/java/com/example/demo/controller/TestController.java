package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
@RequestMapping(value={"/","home"})
public String start() {
	return "index";
}

@RequestMapping(value= {"/signup"})
public String signup() {
	return "signup";
}

@RequestMapping(value= {"/hotel"})
public String hotel() {
	return "hotel";
}
@RequestMapping(value={"/room_reservation"})
public String room_reservation(){
	return "room_reservation";
}
@RequestMapping(value={"/facilities"})
public String facilities(){
	return "facilities";
}
@RequestMapping(value={"/restaurant"})
public String restaurant(){
	return "restaurant";
}
}
