package com.suraj.blog.service;

import java.util.List;

import com.suraj.blog.payload.CategoryDTO;

public interface CategoryService {
	
	CategoryDTO createCategory(CategoryDTO categoryDTO);
	
	CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer catId);
	
	void delterCategory(Integer categoryId);
	
	CategoryDTO getCategory(Integer categoryId);
	
	List<CategoryDTO> getAllCategory();
	
	
}
