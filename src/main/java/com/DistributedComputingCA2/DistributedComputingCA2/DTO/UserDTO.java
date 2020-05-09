package com.DistributedComputingCA2.DistributedComputingCA2.DTO;

import com.DistributedComputingCA2.DistributedComputingCA2.Entity.User;

public class UserDTO {
	

	int userId;
	String username;
	String password;
	boolean isLoggedin;
	
	public UserDTO() {
		
	}
	
	public UserDTO(int userId, String username, String password, boolean isLoggedin) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.isLoggedin = isLoggedin;
	}	
	
	public UserDTO(User userEntity) {
		this.userId = userEntity.getUserId();
		this.username = userEntity.getusername();
		this.password = userEntity.getPassword();
		this.isLoggedin = userEntity.isLoggedin();
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
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
	public boolean isLoggedin() {
		return isLoggedin;
	}
	public void setLoggedIn(boolean isLoggedin) {
		this.isLoggedin = isLoggedin;
	}
	
	
	

}
