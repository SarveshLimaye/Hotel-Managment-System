package com.example.demo.controller;



import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.dao.RoomRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Rooms;
import com.example.demo.entities.User;
import com.example.demo.helper.Message;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.example.demo.dao.UserRepository;
//import com.example.demo.entities.User;
import com.nimbusds.jose.shaded.json.parser.ParseException;


@Controller
public class TestController {
	
@Autowired
private BCryptPasswordEncoder passwordEncoder;
	

	
@Autowired
private UserRepository userRepository;	
	
@Autowired
private RoomRepository roomRepository;	

@Autowired
private EmployeeRepository employeeRepository;


@RequestMapping(value={"/","home"},method=RequestMethod.POST)
public String start() {
	return "hotel";
}

@RequestMapping(value= {"/signup"})
public String signup(Model model) {
	
	model.addAttribute("user",new User());
	return "signup";
}

@RequestMapping(value= {"/hotel"},method=RequestMethod.GET)
public String hotel() {
	return "hotel";
}


@RequestMapping(value={"/room_reservation"})
public String room_reservation(Model model){
	model.addAttribute("rooms",new Rooms());
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


	
	


//@RequestMapping(value={"/logout"})
//public String logout(){
//	return "logout";
//}

@RequestMapping(value={"/admin"},method=RequestMethod.GET)
public String admin(Model model){
	 List<User> listEmployees=userRepository.getUserByRole("ROLE_EMPLOYEE");
	 List<User> listUsers = userRepository.findAll();
	 model.addAttribute("listEmployees",listEmployees);
	 model.addAttribute("listUsers", listUsers);
	return "admin";
}

@RequestMapping(value={"/employee"},method=RequestMethod.GET)
public String commonEmployee(Model model,Principal principal){
	String name = principal.getName();
	User user=this.userRepository.getUserByUserName(name);
	
//	 List<User> listUsers = userRepository.findAll();
//	 model.addAttribute("listUsers", listUsers);
	model.addAttribute("employee",user);
	return "employee";
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

@RequestMapping(value= {"/process_reservation"},method=RequestMethod.POST)
public String reserveRoom(@ModelAttribute("rooms") Rooms rooms,Model model,HttpSession session,Principal principal) {
	
	String name = principal.getName();
	User user=this.userRepository.getUserByUserName(name);
	
	int cId=user.getId();
	rooms.setcId(cId);
	user.getRooms().add(rooms);
	
	
	
	if(rooms.getCategory().equals("Luxury Room")) {
		rooms.setPrice(16950);
	}
	else if(rooms.getCategory().equals("Luxury Grande Room City View")) {
		rooms.setPrice(18700);
	}
	
	else if(rooms.getCategory().equals("Luxury Grande Room Sea View")) {
		rooms.setPrice(20825);
	}else {
		rooms.setPrice(0);
	}
	
	System.out.println("Rooms "+rooms);
	String checkIn = rooms.getCheckinDate();
	String checkOut = rooms.getCheckoutDate();
	try {
		Date checkInDate = new SimpleDateFormat("yyyy-MM-dd").parse(checkIn);
		System.out.println("The check in date in date format: "+checkInDate);
		Date checkOutDate = new SimpleDateFormat("yyyy-MM-dd").parse(checkOut);
		System.out.println("The check out date in date format: "+checkOutDate);
		long diff = checkOutDate.getTime() - checkInDate.getTime();
//		System.out.println("The difference between the two dates is: "+diff);
		TimeUnit time = TimeUnit.DAYS; 
        long difference = time.convert(diff, TimeUnit.MILLISECONDS);
        System.out.println("The difference in days is : "+difference);
        rooms.setTotal_days(difference);
//		System.out.println(checkOutDate-checkInDate);
        long a=rooms.getPrice();
        long b=a*difference;
        rooms.setTotal_price(b);
        
	}catch (java.text.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Rooms reservation=this.roomRepository.save(rooms);
	  
	
	model.addAttribute("rooms", new Rooms());
	session.setAttribute("message", new Message("Successfully Registered","alert-success"));
	return "room_reservation";
}





@RequestMapping(value= {"/dashboard"})
public String userDashboardinfo(@ModelAttribute("rooms") Rooms rooms,Model model,HttpSession session,Principal principal) {
	String name = principal.getName();
	
	User user=this.userRepository.getUserByUserName(name);
	model.addAttribute("user", user);
	System.out.println("User "+user);
	return "userdashboard";
}


//handler for deleting user data from admin login
@RequestMapping(value= {"/admin/delete/{cid}"})
public String deleteUser(@PathVariable("cid")Integer cId,Model model,HttpSession session) {
	
	Optional<User> userOptional=this.userRepository.findById(cId);
	User user=userOptional.get();
	
	this.userRepository.delete(user);
	
	session.setAttribute("message", new Message("Contact deleted Successfully...","success"));
	
	return "redirect:/admin";
}

//handler for opening update form for admin
@RequestMapping(value= {"/admin/update/{cid}"})
public String updateUser(@PathVariable("cid")Integer cId,Model model,HttpSession session) {
	Optional<User> userOptional=this.userRepository.findById(cId);
	User user=userOptional.get();
	
//	User userRooms=user.getRooms();
	model.addAttribute("user", user);
	model.addAttribute("userRooms",user.getRooms());
	return "admin_userinfo";
}

//handler for processing update form using admin login
@RequestMapping(value= {"/admin/do_update"},method = RequestMethod.POST)
public String processUpdate(@ModelAttribute User user,HttpSession session) {
	
	
	System.out.println("USER "+user);
	if(user.getRole().equals("ROLE_EMPLOYEE")) {
		this.employeeRepository.save(user);
	}
	
//	user.getRooms().add((Rooms) user.getRooms());
	
	User result= this.userRepository.save(user);
	
	session.setAttribute("message", new Message("Contact updated Successfully...","success"));
	return "admin_userinfo";
}

//handler for billing page
@RequestMapping(value= {"/billing"})
public String userBillinginfo(@ModelAttribute("rooms") Rooms rooms,Model model,HttpSession session,Principal principal) {
	String name = principal.getName();
	
	User user=this.userRepository.getUserByUserName(name);
	int cId=user.getId();
	
//	Rooms roomReservations=this.roomRepository.getUserByCId(cId);
	List<Rooms> roomReservations=this.roomRepository.getUserByCId(cId);
	for(int i=0;i<roomReservations.size();i++){
	    System.out.println(roomReservations.get(i));
	} 
	model.addAttribute("user", user);
//	user.getRooms().add(user.getRooms());
	model.addAttribute("userRooms", roomReservations);
	
	System.out.println("User "+user);
	return "billing";
}


//handler for sorting the users according to their roles
@RequestMapping(value= {"/admin/employees"})
public String sortUsers(Model model) {
	
	List<User> listEmployees=userRepository.getUserByRole("ROLE_EMPLOYEE");
	model.addAttribute("listEmployees",listEmployees);
	return "sortedPage";
}

@RequestMapping(value= {"/admin/customers"})
public String sortCustomers(Model model) {
	
	List<User> listEmployees=userRepository.getUserByRole("ROLE_USER");
	model.addAttribute("listEmployees",listEmployees);
	return "sortedPage";
}

}
  
