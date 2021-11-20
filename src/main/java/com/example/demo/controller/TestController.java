package com.example.demo.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;
import com.example.demo.helper.Message;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.example.demo.dao.UserRepository;
//import com.example.demo.entities.User;


@Controller
public class TestController {
	
@Autowired
private BCryptPasswordEncoder passwordEncoder;
	

	
@Autowired
private UserRepository userRepository;	
	
	
@RequestMapping(value={"/","home"})
public String start() {
	return "hotel";
}

@RequestMapping(value= {"/signup"})
public String signup(Model model) {
	
	model.addAttribute("user",new User());
	return "signup";
}

@RequestMapping(value= {"/hotel"})
public String hotel() {
	return "hotel";
}

@GetMapping("/login")
public String login() {
	return "login";
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

@RequestMapping(value={"/user/data"})
public String userdashboard(){
	return "userdashboard";
}



//@Autowired
//private UserRepository userRepository;


//@GetMapping(value= {"/test"})
//@ResponseBody
//public String test() {
//	
//	User user=new User();
//	user.setName("Soham Kayal");
//	user.setEmail("sohamk4103@gmail.com");
//	
//	userRepository.save(user);
//	
//	return "Working";
//}


//handler for registering user
@RequestMapping(value= {"/do_register"},method=RequestMethod.POST)
public String registerUser(@ModelAttribute("user") User user,Model model,HttpSession session) {
	
	user.setRole("ROLE_USER");
	user.setEnabled(true);
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	System.out.println("USER "+user);
	
	User result= this.userRepository.save(user);
	
	model.addAttribute("user", new User());
	session.setAttribute("message", new Message("Successfully Registered","alert-success"));
	return "signup";
}


}
