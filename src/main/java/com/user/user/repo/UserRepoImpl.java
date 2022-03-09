package com.user.user.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.user.user.model.User;

@Repository
public class UserRepoImpl extends BaseRepository implements UserRepo{


	@Override
	public List<User> getUserByName(String name) {
		EntityManager entityManager = getEntityManager();
		List<User> users = entityManager.createQuery("select u from User u where u.firstName =: name").setParameter("name", name).getResultList();
		return users;
	}

	@Override
	public List<User> getUserByDept(String dept) {
		EntityManager entityManager = getEntityManager();
		List<User> users = entityManager.createQuery("select u from User u where u.dept =: dept").setParameter("dept", dept).getResultList();
		return users;
	}

	@Override
	public List<User> getUserByBatch(String batch) {
		EntityManager entityManager = getEntityManager();
		List<User> users = entityManager.createQuery("select u from User u where u.batch =: batch").setParameter("batch", batch).getResultList();
		return users;
	}

	@Override
	public void deleteUser(String rollno) {
		
	}


	
}
