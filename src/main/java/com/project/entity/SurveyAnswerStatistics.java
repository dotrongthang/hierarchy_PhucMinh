package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


public class SurveyAnswerStatistics {
	private String username;
	private Long   count;
	
	public SurveyAnswerStatistics(String username, Long count) {
		super();
		this.username = username;
		this.count = count;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
	
}
