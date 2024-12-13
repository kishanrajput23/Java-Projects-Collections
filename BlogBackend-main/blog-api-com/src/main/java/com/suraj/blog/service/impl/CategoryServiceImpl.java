package com.suraj.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suraj.blog.dao.CategoryRepo;
import com.suraj.blog.entity.Category;
import com.suraj.blog.exceptions.ResourceNotFoundException;
import com.suraj.blog.payload.CategoryDTO;
import com.suraj.blog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		Category category = categoryDtoToEntityt(categoryDTO);
		this.categoryRepo.save(category);
		CategoryDTO newCategoryDTO = categoryEntityToDto(category);
		return newCategoryDTO;
	}

	

	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer catId) {
		Category category = this.categoryRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", catId));
		category.setCategoryTitle(categoryDTO.getCategoryTitle());
		category.setCategoryDescription(categoryDTO.getCategoryDescription());
		
		Category updatedCategory = this.categoryRepo.save(category);
		
		return this.categoryEntityToDto(updatedCategory);
	}

	@Override
	public void delterCategory(Integer catId) {
		Category category = this.categoryRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", catId));
		 this.categoryRepo.delete(category);
	}

	@Override
	public CategoryDTO getCategory(Integer catId) {
		Category category = this.categoryRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", catId));
		return this.categoryEntityToDto(category);
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDTO> categoryDTOs = categories.stream().map(cat -> this.categoryEntityToDto(cat)).collect(Collectors.toList());
		return categoryDTOs;
	}

	public Category categoryDtoToEntityt(CategoryDTO categoryDTO) {
		return this.modelMapper.map(categoryDTO, Category.class);
	}
	
	public CategoryDTO categoryEntityToDto(Category category) {
		return this.modelMapper.map(category, CategoryDTO.class);
	}
	

}
