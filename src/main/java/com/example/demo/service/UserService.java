package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.entity.User;
import com.example.demo.web.dto.UserRegistrationDto;



public interface UserService extends UserDetailsService {
	 User save(UserRegistrationDto registrationDto);
	 List<User> getAllUsers();
	
}
