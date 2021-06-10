package com.project.dto;

public class LogDTO extends AbstractDTO<LogDTO> {
	private String username;
	private Long count;
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
	
	public LogDTO() {
		super();
	}
	public LogDTO(String username, Long count) {
		super();
		this.username = username;
		this.count = count;
	}
	
	

}
