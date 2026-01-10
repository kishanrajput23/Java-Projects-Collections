package com.suraj.blog.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
	private int id;
	@NotEmpty
	@Size(min=4, message = "User name should be min of 4 characters !!")
	private String name;
	@Email(message = "Please enter valid Email address !!")
	private String email;
	@NotEmpty
	@Size(min=8, max=20, message = "Please Enter password between 8 to 20 chracters !!")
	private String password;
	@NotEmpty
	private String about;
}
