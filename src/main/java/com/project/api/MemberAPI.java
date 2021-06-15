package com.project.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.UserDTO;
import com.project.service.IUserService;

@RestController(value = "memberAPIOfAdmin")
public class MemberAPI {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/api/member")
	public UserDTO createUser(@RequestBody UserDTO userDTO) {
		return userService.save(userDTO);
	}


}