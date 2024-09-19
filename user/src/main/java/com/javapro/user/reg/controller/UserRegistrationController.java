package com.javapro.user.reg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javapro.user.reg.dto.UserDTO;
import com.javapro.user.reg.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRegistrationController {
	
	//public static final Logger logger = Logger
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public UserDTO addUser(@RequestBody UserDTO user) {
		return userService.addUser(user);
		
	}
	
	@GetMapping
	public List<UserDTO> getAllUsers(){
		List<UserDTO> users = new ArrayList<UserDTO>();
		return userService.getUsers();
		
	}
	
	@GetMapping("/{userId}")
	public UserDTO getUser(@PathVariable("userId") Integer userId) {
		userService.getUser(userId);
		return userService.getUser(userId);
	}
	
	@GetMapping("/token")
	public String getToken(@RequestBody UserDTO user) {
		return userService.getToken();
		
	}
	
	
	@GetMapping("/validate")
	public String validate(@RequestBody UserDTO user) {
		userService.validateUser(user);
		return "User Authenticate Successfully";
		
	}
	
	
	
	
	
	
	

}
