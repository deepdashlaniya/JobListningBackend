package com.JobListning.JobListningBackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@CrossOrigin
public class JobController {

	@Autowired
	PostRepository repo;
	
	@Autowired
	SearchRepository srepo;
	
	@GetMapping("/")
	public String get() {
		return "hello";
	}
	
	
	@GetMapping("/allPosts")
	@CrossOrigin
	public List<Post> getAllPosts(){
		List<Post> posts = repo.findAll();
		
		return posts;
	}
	
	@GetMapping("posts/{text}")
	public List<Post> search(@PathVariable String text){
		return srepo.findByText(text);
	}
	
	
	@PostMapping(path = "/post")
	public Post addPost(@RequestBody Post post) {
		return repo.save(post);
	}
}
