package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.web.dto.UserRegistrationDto;

@Controller
@RequestMapping ("/adminregistration")
public class AdminRegistrationController {
	 private UserService userService;
	
	 
	public AdminRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	 @ModelAttribute("admin")
	    public UserRegistrationDto userRegistrationDto() {
	        return new UserRegistrationDto();
	    }
	
	 @GetMapping
	    public String showRegistrationForm() {
	        return "adminregistration";
	    }
	
	 @PostMapping
	    public String registerUserAccount(@ModelAttribute("admin") UserRegistrationDto registrationDto) {
		 	registrationDto.setRole("ROLE_ADMIN");
	        userService.save(registrationDto);
	        return "redirect:/registration?success";
	    }
}
