package com.cap.capspringwebjpabatch2.controllers;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cap.capspringwebjpabatch2.entities.Employee;
import com.cap.capspringwebjpabatch2.entities.Usert;
import com.cap.capspringwebjpabatch2.repos.UserRepository;



@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value="/usert",method=RequestMethod.POST)
	public ResponseEntity<Void> addUser(@RequestBody Usert u)
	{
		ResponseEntity<Void> re=null;
		Usert user=userRepository.findByEmail(u.getEmail());
		System.out.println(user);
		if(user==null) {
			userRepository.save(u);
			re=new ResponseEntity<>(HttpStatus.CREATED);
		}
		else {
			re = new ResponseEntity<>(HttpStatus.CONFLICT);
			throw new UserAlreadyExistsException("User found with email : " +  u.getEmail());
		}
		return re;
	}

	@RequestMapping(value="/usert",method=RequestMethod.GET)
	public ResponseEntity<List<Usert>> findAllUser(){
		ResponseEntity<List<Usert>> re=null;
		List<Usert>user=userRepository.findAll();
		if(user.isEmpty()) {
			return re=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return re=new ResponseEntity<>(user,HttpStatus.FOUND);
	}
	
	@GetMapping("/usert/{email}")
	public ResponseEntity<Usert> findUserByEmail(@PathVariable("email") String email) {
		ResponseEntity<Usert>re;
		Usert u=userRepository.findByEmail(email);
		if(u==null) {
			return re=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re=new ResponseEntity<>(u,HttpStatus.FOUND);
	}
	
	@RequestMapping(value="/usert",method=RequestMethod.PUT)
	@Transactional
	public ResponseEntity<Void> updateUser(@RequestBody Usert u) {
		ResponseEntity<Void>  re;
		
		Usert up = userRepository.findByEmail(u.getEmail());
		up.setPassword(u.getPassword());
		re = new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return re;
	}
	@DeleteMapping("/usert/{email}")
	public void deleteUser(@PathVariable("email") String email) {
		Usert user = userRepository.findByEmail(email);
		Usert u = null;
		u=user;
		if(u!=null) {	
			userRepository.delete(u);
		}
		
	}
}
