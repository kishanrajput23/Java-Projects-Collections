package com.suraj.blog.service;

import java.util.List;

import com.suraj.blog.entity.Post;
import com.suraj.blog.payload.PostDto;

public interface PostService {
		
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	void deletePost(Integer postId);
	
	List<PostDto> getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	PostDto getPostById(Integer postId);
	
	List<PostDto> getPostByCategory(Integer categoryId);

	List<PostDto> getPostByUser(Integer userId);
	
	List<PostDto> searchPosts(String Keyword);
}
