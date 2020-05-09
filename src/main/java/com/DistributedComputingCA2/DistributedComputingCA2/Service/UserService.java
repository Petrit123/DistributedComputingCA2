package com.DistributedComputingCA2.DistributedComputingCA2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DistributedComputingCA2.DistributedComputingCA2.DAO.UserDAO;
import com.DistributedComputingCA2.DistributedComputingCA2.DTO.UserDTO;

@Service
public class UserService {
	
	@Autowired
	UserDAO userRepository;
	
	
	public String login(String username, String password) {
		
		String loginResult = "";
		
		for (UserDTO user : userRepository.getAllUsers()) {
			
			if (user.getUsername().equals(username)) {
				System.out.print("Username is valid\n");
				if (user.getPassword().equals(password)) {
					System.out.print("username and password are correct");
					if (!user.isLoggedin()) {
						userRepository.setLogInStatus();
						loginResult = "Successful Login";
					} else {
						loginResult = "User is already signed in";
					}
				} else {
					loginResult = "The password is incorrect";
				}
			} else {
				loginResult = "No such user with that username";
			}
		}
		
		return loginResult;
	}
	
	
	public String logOff() {
		
		userRepository.setLogUserOff();
		
		return "Thanks for using my application! Goodbye";
	}
	

}
