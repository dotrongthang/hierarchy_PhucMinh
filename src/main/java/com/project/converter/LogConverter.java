package com.project.converter;

import org.springframework.stereotype.Component;

import com.project.dto.LogDTO;
import com.project.entity.LogEntity;

@Component
public class LogConverter {
	
	public LogDTO toDTO( LogEntity entity) {
		LogDTO result = new LogDTO();
		result.setId(entity.getId());
		result.setUsername(entity.getUsername());
		result.setCreatedDate(entity.getCreatedDate());
		result.setCount(entity.getCount());
		return result;
	}

}
