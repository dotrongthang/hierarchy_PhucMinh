package com.project.dto;

public class LogDTO extends AbstractDTO<LogDTO> {
	private String parentname;
	private String username;
	private Long count;
	
	public String getParentname() {
		return parentname;
	}
	public void setParentname(String parentname) {
		this.parentname = parentname;
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
	
	public LogDTO() {
		super();
	}
	public LogDTO(String parentname, String username, Long count) {
		super();
		this.parentname = parentname;
		this.username = username;
		this.count = count;
	}	
	

}
