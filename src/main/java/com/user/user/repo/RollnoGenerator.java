package com.user.user.repo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.user.user.model.User;


@Repository
public class RollnoGenerator extends BaseRepository{

	public String generateId(String joining, String batch) {
		int c =0;
		String prefix = joining.concat(batch);
		System.out.println("Prefix" +prefix);
		EntityManager entityManager = getEntityManager();
		List<User> count = entityManager.createQuery("select u from User u where u.rollno LIKE :prefix").setParameter("prefix", prefix+"%").getResultList(); 
		for(User user: count) {
			c+=1;
		}
		int id = c + 101;
		String roll = prefix.concat(Integer.toString(id));
		System.out.println("roll" +roll);
		return roll;
		
	}
}
