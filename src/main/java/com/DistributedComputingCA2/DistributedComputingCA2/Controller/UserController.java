package com.DistributedComputingCA2.DistributedComputingCA2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.DistributedComputingCA2.DistributedComputingCA2.Service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(method = RequestMethod.POST, produces="application/json", value="/user/login")
	@ResponseBody
	public String login(@RequestBody ObjectNode objectNode) {
		
		String receivedUsername = objectNode.get("username").asText();
		String receivedPassword = objectNode.get("password").asText();
		
		return userService.login(receivedUsername, receivedPassword);		
	}
	
	@RequestMapping(method = RequestMethod.POST, produces="application/json", value="/user/logoff")
	public String logOff() {
		
		return userService.logOff();
	}
	

}