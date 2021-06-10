package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.converter.LogConverter;
import com.project.dto.LogDTO;
import com.project.dto.UserDTO;
import com.project.entity.LogEntity;
import com.project.entity.SurveyAnswerStatistics;
import com.project.entity.UserEntity;
import com.project.repository.LogRepository;
import com.project.service.ILogService;

@Service
public class LogService implements ILogService {
	
	@Autowired
	private LogRepository logRepository;
	
	@Autowired
	private LogConverter logConverter;

	@Override
	public List<LogDTO> countLog(String start, String end) {
		List<LogDTO> result = new ArrayList<>();
		List<Object[]> entities = logRepository.countLog(start, end);
		for(int i = 0; i<entities.size(); i++) {
			Object[] row = (Object[])entities.get(i);
			LogDTO dto = new LogDTO((String) row[0], Long.parseLong(row[1].toString()));
			result.add(dto);
		}
		return result;
	}

	@Override
	public List<LogDTO> showtLog(String search, String start, String end) {
		List<LogDTO> result = new ArrayList<>();
		List<LogEntity> entities = logRepository.showLog(start, end, search);
		for (LogEntity item: entities) {
			LogDTO logDTO = logConverter.toDTO(item);
			result.add(logDTO);
		}
		return result;
	}
	
	
}
