package com.example.entiry;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

public class User {
	
	private Integer userId; // 使用者代號
	
	private String username; // 使用者名稱
	
	private String password; // 使用者密碼
	
	private String email;  // 使用者信箱
	
	private Integer level; // 使用者權限
	
	private String authType; // 授權來源
	
	private String authId; // 授權Id
	
	// 服務列表
	private List<com.example.entiry.Service> services;
	
	public User() {
		
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}	
	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public List<com.example.entiry.Service> getServices() {
		return services;
	}

	public void setServices(List<com.example.entiry.Service> services) {
	    this.services = services;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	

}