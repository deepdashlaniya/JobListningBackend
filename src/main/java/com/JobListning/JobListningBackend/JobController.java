package com.JobListning.JobListningBackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class JobController {

	@Autowired
	PostRepository repo;
	
	@GetMapping("/")
	public String get() {
		return "hello";
	}
	
	
	@GetMapping("/posts")
	public List<Post> getAllPosts(){
		List<Post> posts = repo.findAll();
		
		return posts;
	}
}
