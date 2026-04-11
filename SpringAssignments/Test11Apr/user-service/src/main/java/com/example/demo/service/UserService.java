package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public User getUser(Long id) {
		return repo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	public User createUser(User user) {
		return repo.save(user);
	}
}