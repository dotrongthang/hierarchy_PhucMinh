package com.project.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.project.dto.LogDTO;
import com.project.dto.UserDTO;
import com.project.entity.LogEntity;
import com.project.entity.SurveyAnswerStatistics;
import com.project.entity.UserEntity;

public interface ILogService {

	List<LogDTO> countLog(String start, String end);
	
	List<LogDTO> showtLog(String search, String start, String end);
	
	List<LogDTO> findChildLog(String search, String start, String end);
	
}
