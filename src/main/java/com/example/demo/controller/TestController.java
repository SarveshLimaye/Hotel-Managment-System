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

}
