package com.devpedrod.springboot_mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devpedrod.springboot_mongodb.domain.Post;
import com.devpedrod.springboot_mongodb.repository.PostRepository;
import com.devpedrod.springboot_mongodb.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.searchTitle(text);
	}
}
