package com.DistributedComputingCA2.DistributedComputingCA2.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.DistributedComputingCA2.DistributedComputingCA2.DTO.UserDTO;
import com.DistributedComputingCA2.DistributedComputingCA2.Entity.User;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserDAO {
	
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<UserDTO> getAllUsers() {
		List<User> retrievedUsers = entityManager.createQuery("SELECT e FROM User e", User.class).getResultList();	
		
		List<UserDTO> users = new ArrayList<>();
		
		for (User user : retrievedUsers) {
			users.add(new UserDTO(user));
		}
		
		return users;
	}
	
	public UserDTO findUserByName(String username) {
		
		List<User> foundUser = entityManager.createQuery("SELECT e FROM User e WHERE e.username = :username", User.class)
				.setParameter("username", username).getResultList();
		UserDTO	user = new UserDTO(foundUser.get(0));			
		
		
		return user;
	}
	
	public void setLogInStatus() {
		
		User user = entityManager.find(User.class,1);
		user.setLoggedIn(true);
		entityManager.persist(user);
		 
	}
	
	public void setLogUserOff() {
		
		User user = entityManager.find(User.class,1);
		user.setLoggedIn(false);
		entityManager.persist(user);
		 
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return this.entityManagerFactory;
	}
	
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	public EntityManager getEntityManger() {
		return this.entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
