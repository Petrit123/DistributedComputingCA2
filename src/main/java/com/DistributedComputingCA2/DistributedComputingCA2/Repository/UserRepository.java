package com.DistributedComputingCA2.DistributedComputingCA2.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.DistributedComputingCA2.DistributedComputingCA2.DTO.UserDTO;
import com.DistributedComputingCA2.DistributedComputingCA2.Entity.UserEntity;

import java.util.ArrayList;
import java.util.List;


@Transactional
@Repository
public class UserRepository {
	
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<UserDTO> getAllUsers() {
		List<UserEntity> retrievedUsers = entityManager.createQuery("SELECT e FROM UserEntity e", UserEntity.class).getResultList();	
		
		List<UserDTO> users = new ArrayList<>();
		
		for (UserEntity user : retrievedUsers) {
			users.add(new UserDTO(user));
		}
		
		return users;
	}
	
	public UserDTO findUserByName(String username) {
		
		List<UserEntity> foundUser = entityManager.createQuery("SELECT e FROM UserEntity e WHERE e.username = :username", UserEntity.class)
				.setParameter("username", username).getResultList();
		UserDTO	user = new UserDTO(foundUser.get(0));			
		
		
		return user;
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
