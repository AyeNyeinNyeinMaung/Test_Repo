package com.jdc.tut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.tut.entity.User;
import com.jdc.tut.repository.MainRepo;
@Service
public class MainService {
	@Autowired
	private MainRepo repo;

	public List<User> findAll() {
		
		
		return repo.findAll();
	}

	public void save(User u) {
		repo.save(u);
		
	}

}
