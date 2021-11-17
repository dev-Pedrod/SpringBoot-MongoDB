package com.devpedrod.springboot_mongodb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devpedrod.springboot_mongodb.domain.User;
import com.devpedrod.springboot_mongodb.dto.UserDTO;
import com.devpedrod.springboot_mongodb.repository.UserRepository;
import com.devpedrod.springboot_mongodb.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<UserDTO> findAll(){
		List<User> list = repo.findAll();
		return list.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.save(obj);
	}
	
	public User fromDTO(UserDTO obj) {
		return new User(null, obj.getName(), obj.getEmail());	
	}

}
