package com.user.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.user.model.User;
import com.user.user.repo.RollnoGenerator;
import com.user.user.repo.UserException;
import com.user.user.repo.UserRepoImpl;
import com.user.user.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepoImpl impl;
	
	@Autowired
	RollnoGenerator generator;
	
	@Autowired
	UserRepository repository;
	
	public User getUser(String rollno) throws UserException {
		User u;
	    if (!((repository.findById(rollno).isPresent()))) {

	        throw new UserException();
	    } else {
	        u = repository.findUserByRollno(rollno);
	    }
	    return u;
	}
	
	public List<User> getUserByNameService(String name){
		return impl.getUserByName(name);
	}
	
	public List<User> getUserByDeptService(String dept){
		return impl.getUserByDept(dept);
	}
	
	public List<User> getUserByBatchService(String batch){
		return impl.getUserByBatch(batch);
	}
	

	public void saveUser(User user) {
		String id = generator.generateId(user.getYearOfJoining(), user.getDept());
		user.setRollno(id);
		repository.save(user);
		
	}
	
	public void deleteUserService(String rollno) {
		repository.deleteUser(rollno);
	}
}
