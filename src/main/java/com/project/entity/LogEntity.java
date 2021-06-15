package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "log")
public class LogEntity extends BaseEntity {

	@Column(name = "username")
	private String username;

	@Column(name = "count")
	private Long count;
	
	@Column(name = "fromId")
	private Long fromid;
	

	public Long getFromid() {
		return fromid;
	}

	public void setFromid(Long fromid) {
		this.fromid = fromid;
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