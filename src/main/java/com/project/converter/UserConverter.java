package com.project.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dto.UserDTO;
import com.project.entity.UserEntity;
import com.project.service.impl.UserService;

@Component
public class UserConverter {
	
	@Autowired
	private UserService userService;
	
	public UserEntity toEntity( UserDTO dto) {
		UserEntity result = new UserEntity();
		result.setUsername(dto.getUsername());
		if(dto.getParentname() != "") {
			result.setParentid(userService.findByParentName(dto.getParentname()).get(0).getId());
		}else {
			result.setParentid(0L);
		}
		result.setCount(0L);
		return result;
	}
	
	public UserDTO toDTO( UserEntity entity) {
		UserDTO result = new UserDTO();
		result.setId(entity.getId());
		result.setCreatedDate(entity.getCreatedDate());
		result.setUsername(entity.getUsername());
		if(entity.getParentid() == 0) {
			result.setParentname("Không có");
		}else {
			result.setParentname(userService.findOneById(entity.getParentid()).getUsername());
		}
		result.setCount(entity.getCount());
		return result;
	}

}
