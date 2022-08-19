package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.UserService;

@Controller
public class MainController {
	private UserService userService;
	public MainController(UserService userService) {
		super();
		this.userService = userService;
	}
	  @GetMapping("/login")
	    public String login() {
	        return "login";
	    }

	    @GetMapping("/")
	    public String home() {
	        return "index";
	    }
	    @GetMapping("/currentdetails")
		 public String showmydetails() {
			return  "currentdetails";
		 }
		@GetMapping("/displayUsers")
		 public String displayUsers(Model model) {
			model.addAttribute("userlist",userService.getAllUsers());
			 return "displayUsers";
		 }
}
