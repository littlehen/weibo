package com.nit.weibo.dto;

import java.io.Serializable;

public class AdminLoginDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer adminId;
	private String username;
	private String userSessionId;


	public AdminLoginDto(){
		super();
	}
	
	public AdminLoginDto(Integer adminId, String username, String userSessionId){
		super();
		this.adminId = adminId;
		this.username = username;
		this.userSessionId = userSessionId;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserSessionId() {
		return userSessionId;
	}

	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}
}
