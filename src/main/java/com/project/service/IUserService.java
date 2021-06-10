package com.project.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.project.dto.UserDTO;
import com.project.entity.UserEntity;

public interface IUserService {

	UserDTO save(UserDTO dto);
	List<UserEntity> findByParentName(String parentName);
	List<UserDTO> findByName(String name);
	UserEntity findOneById(Long id);
	List<UserDTO> findAll(Pageable pageable);
	int getTotalItem();
	List<UserDTO> findByParentId(Long parentId);
	String findIDWhenActive(int id);
			
}
