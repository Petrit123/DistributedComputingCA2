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
		
		UserDTO user = userRepository.findUserByName(username);
		if(user.getUsername() != null) {
			System.out.print("username is valid");
			if(user.getPassword().equals(password)) {
				System.out.print("password is correct also!");
				if (!user.isLoggedin()) {
					userRepository.updateLoginStatus(username, true);
				} else {
					loginResult = "This user is already signed in";
				}
			} else {
				loginResult = "The password is incorrect!";
			}
		} else {
			loginResult = "No such user with that username";
		}
		
		return loginResult;
	}
	
	
	public String logOff(String username) {
		
		userRepository.updateLoginStatus(username,false);
		
		return "Thanks for using my application! Goodbye";
	}
	

}
