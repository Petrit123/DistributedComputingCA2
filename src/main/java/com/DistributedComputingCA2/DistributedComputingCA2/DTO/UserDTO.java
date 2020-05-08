package com.DistributedComputingCA2.DistributedComputingCA2.DTO;

import com.DistributedComputingCA2.DistributedComputingCA2.Entity.UserEntity;

public class UserDTO {
	

	String username;
	String password;
	boolean isLoggedin;
	
	public UserDTO() {
		
	}
	
	public UserDTO(String username, String password, boolean isLoggedin) {
		this.username = username;
		this.password = password;
		this.isLoggedin = isLoggedin;
	}	
	
	public UserDTO(UserEntity userEntity) {
		this.username = userEntity.getusername();
		this.password = userEntity.getPassword();
		this.isLoggedin = userEntity.isLoggedin();
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
