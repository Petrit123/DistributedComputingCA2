package com.DistributedComputingCA2.DistributedComputingCA2.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import org.springframework.transaction.annotation.Transactional;
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
	

	public UserDTO findUserByName(String username) {
		
		
		UserDTO user = new UserDTO();
		
		List<User> foundUser = entityManager.createQuery("SELECT e FROM User e WHERE e.username = :username", User.class)
				.setParameter("username", username).getResultList();
		
		if (!foundUser.isEmpty()) {
			user = new UserDTO(foundUser.get(0));
		}		
		
		
		return user;
	}
	
	@Transactional
	public void updateLoginStatus(String username, boolean isLoggedin) {
		List<User> foundUser = entityManager.createQuery("SELECT e FROM User e WHERE e.username = :username", User.class)
		.setParameter("username", username).getResultList();
		
		foundUser.get(0).setLoggedIn(isLoggedin);
		entityManager.persist(foundUser.get(0));
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
