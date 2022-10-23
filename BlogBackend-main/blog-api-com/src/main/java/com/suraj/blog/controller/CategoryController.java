package com.suraj.blog.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.blog.payload.ApiResponse;
import com.suraj.blog.payload.CategoryDTO;
import com.suraj.blog.service.CategoryService;

@RestController
@RequestMapping("/api/categories/")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
		CategoryDTO newCategory = this.categoryService.createCategory(categoryDTO);
		return new ResponseEntity<CategoryDTO>(newCategory, HttpStatus.CREATED);
	}

	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,
			@PathVariable Integer catId) {
		CategoryDTO newCategory = this.categoryService.updateCategory(categoryDTO, catId);
		return new ResponseEntity<CategoryDTO>(newCategory, HttpStatus.OK);
	}

	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId) {
		this.categoryService.delterCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Successfully !!", true),
				HttpStatus.OK);
	}

	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable Integer catId) {
		CategoryDTO category = this.categoryService.getCategory(catId);
		return new ResponseEntity<CategoryDTO>(category, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDTO>> getAllCategory(){
		List<CategoryDTO> dtos = this.categoryService.getAllCategory();
		return new ResponseEntity<List<CategoryDTO>>(dtos, HttpStatus.OK);
	}
	

}
