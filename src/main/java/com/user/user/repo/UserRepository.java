package com.user.user.repo;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	User findUserByRollno(String rollno) throws UserException;
	
	@Transactional
	@Modifying
	@Query("update User e set e.isDeleted=true where e.rollno=?1")
	void deleteUser(String rollno);
	
}
