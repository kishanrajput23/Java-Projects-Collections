package com.suraj.blog.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suraj.blog.dao.CommentRepo;
import com.suraj.blog.dao.PostRepo;
import com.suraj.blog.entity.Comment;
import com.suraj.blog.entity.Post;
import com.suraj.blog.exceptions.ResourceNotFoundException;
import com.suraj.blog.payload.CommentDto;
import com.suraj.blog.payload.PostDto;
import com.suraj.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private PostRepo postRepo;
	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "post Id", postId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment = this.commentRepo.save(comment);
		return this.modelMapper.map(savedComment, CommentDto.class);
	}


	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("comment", "comment Id", commentId));
		this.commentRepo.delete(comment);
	}

}
