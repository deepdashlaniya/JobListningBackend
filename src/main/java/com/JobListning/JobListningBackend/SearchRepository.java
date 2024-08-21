package com.JobListning.JobListningBackend;

import java.util.List;

public interface SearchRepository {
	
	public List<Post> findByText(String text);
}
