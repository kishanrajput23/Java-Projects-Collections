package com.suraj.blog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suraj.blog.entity.Category;
import com.suraj.blog.entity.Post;
import com.suraj.blog.entity.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	List<Post> findByUser(User user);

	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);
}
