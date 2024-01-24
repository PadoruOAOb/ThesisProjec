package com.example.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private Integer userId;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private Integer level;
	
	private String authType; // local、github、google
	
	private String authId;
	
	private Type type;
	
	
	
}