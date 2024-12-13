package com.suraj.blog.service;

import java.util.List;

import com.suraj.blog.payload.UserDTO;

public interface UserService {
	UserDTO createUser(UserDTO userDTO);
	UserDTO updateUser(UserDTO userDTO, Integer userID);
	UserDTO getUserById(Integer userId);
	List<UserDTO> getAllUsers();
	void deleteUser(Integer userId);
}
