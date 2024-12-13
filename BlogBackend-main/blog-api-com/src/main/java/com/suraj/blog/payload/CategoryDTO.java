package com.suraj.blog.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {

	private Integer categoryId;
	@NotBlank
	@Size(min=4, message = "Title cannot be less than 4!!")
	private String categoryTitle;
	
	@NotBlank
	@Size(min = 10, message = "Description cannot be less than 10 characters !!!")
	private String categoryDescription;
}
