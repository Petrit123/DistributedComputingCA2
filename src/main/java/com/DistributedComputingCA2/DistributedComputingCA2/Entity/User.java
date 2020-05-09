package com.DistributedComputingCA2.DistributedComputingCA2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.DistributedComputingCA2.DistributedComputingCA2.DTO.UserDTO;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@Column(name="userId")
	private int userId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="isLoggedin")
	private boolean isLoggedin;
	
	public User() {
		
	}
	
	public User(int userId, String username, String password, boolean isLoggedin) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.isLoggedin = isLoggedin;
	}
	
	public User(UserDTO userDTO) {
		this.userId = userDTO.getUserId();
		this.username = userDTO.getUsername();
		this.password = userDTO.getPassword();
		this.isLoggedin = userDTO.isLoggedin();
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
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
