package com.RESTApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RESTApi.repository.UserRepository;

@RestController
@RequestMapping("/")
public class APIController {
	
	@Autowired
	UserRepository userRepository;

	@GetMapping
	public void home() {
				
	}
}
