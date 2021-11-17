package com.devpedrod.springboot_mongodb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devpedrod.springboot_mongodb.domain.User;
import com.devpedrod.springboot_mongodb.dto.UserDTO;
import com.devpedrod.springboot_mongodb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<UserDTO> findAll(){
		List<User> list = repo.findAll();
		return list.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());
	}

}
