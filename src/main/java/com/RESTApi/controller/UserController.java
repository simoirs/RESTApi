package com.RESTApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RESTApi.exception.UserNotFoundException;
import com.RESTApi.model.User;
import com.RESTApi.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users/{pageNumber}/{pageSize}")
	public List<User> findAll(@PathVariable int pageNumber, @PathVariable int pageSize) {
		Pageable paging = PageRequest.of(pageNumber, pageSize);
		Page<User> pagedResult = userRepository.findAll(paging);
		return pagedResult.toList();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> findById(@PathVariable long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id: " + id));
		return ResponseEntity.ok().body(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
