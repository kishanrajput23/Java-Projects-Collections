package com.suraj.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suraj.blog.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	
}
