package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

	@Column(name = "username")
	private String username;

	@Column(name = "parentid")
	private Long parentid;

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

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
	

}