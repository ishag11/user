package com.user.user.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.user.user.model.User;

@Repository
public interface UserRepo {
	List<User> getUserByName(String name);
	List<User> getUserByDept(String dept);
	List<User> getUserByBatch(String batch);
	void deleteUser(String rollno);
}
