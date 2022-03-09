package com.user.user.controller;


import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.user.user.dto.*;
import com.user.user.model.User;
import com.user.user.repo.UserException;
import com.user.user.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;
	
	
	@GetMapping(value= "/getUser/{rollno}")
	public ResponseEntity getUser(@PathVariable String rollno) {
		UserStatus extraStatus = new UserStatus();

		try{
          extraStatus.setStatus(Status.StatusType.SUCCESS);
          extraStatus.setMessage("User present");
          extraStatus.setRollno(service.getUser(rollno).getRollno());
          extraStatus.setFirstName(service.getUser(rollno).getFirstName());
          extraStatus.setDept(service.getUser(rollno).getDept());
          extraStatus.setBatch(service.getUser(rollno).getBatch());
          extraStatus.setHttpStatus(HttpStatus.OK);
          return new ResponseEntity(extraStatus, HttpStatus.OK);

      }
      catch(UserException userException){
              extraStatus.setStatus(Status.StatusType.FAILED);
              extraStatus.setMessage("User Not Present");
              extraStatus.setHttpStatus(HttpStatus.CONFLICT);
          return new ResponseEntity(extraStatus, HttpStatus.CONFLICT);
      }    
		
		//return extraStatus;
}

	@GetMapping(value= "/getUserByName/{name}")
	public List<User> getUserByNameController(@PathVariable String name){
		return service.getUserByNameService(name);
	}
	
	@GetMapping(value= "/getUserByDept/{dept}")
	public List<User> getUserByDept(@PathVariable String dept){
		return service.getUserByDeptService(dept);
	}
	
	@GetMapping(value= "/getUserByBatch/{batch}")
	public List<User> getUserByBatch(@PathVariable String batch){
		return service.getUserByBatchService(batch);
	}
	
	
	@PostMapping(value= "/") 
		public void add(@Valid @RequestBody User user) throws EntityNotFoundException  {
			user.setCreatedDate(java.time.LocalDate.now());
			service.saveUser(user);
		
	}
	
	@PutMapping(value= "/updateUser")
	public void updateUser(@Valid @RequestBody User user) {
		user.setLastModifiedDate(java.time.LocalDate.now());
		service.saveUser(user);
		
	}
	
	@GetMapping(value= "/deleteUser/{rollno}")
	public void deleteUserController(@PathVariable String rollno) {
		service.deleteUserService(rollno);
	}
}
