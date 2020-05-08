package com.DistributedComputingCA2.DistributedComputingCA2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class UserEntity {
	
	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="isLoggedin")
	private boolean isLoggedin;
	
	public UserEntity() {
		
	}
	
	public UserEntity(String username, String password, boolean isLoggedin) {
		this.username = username;
		this.password = password;
		this.isLoggedin = isLoggedin;
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
