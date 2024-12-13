package com.suraj.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suraj.blog.payload.UserDTO;
import com.suraj.blog.service.UserService;
import com.suraj.blog.dao.UserRepo;
import com.suraj.blog.entity.User;
import com.suraj.blog.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = this.dtoToUser(userDTO);
		User savedUser = this.userRepo.save(user);
		return this.usertoUserDTO(savedUser);

	}

	@Override
	public UserDTO updateUser(UserDTO userDTO, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setAbout(userDTO.getAbout());
		user.setPassword(userDTO.getPassword());

		User updatedUser = this.userRepo.save(user);

		UserDTO userDTO1 = this.usertoUserDTO(updatedUser);
		return userDTO1;
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));
		return this.usertoUserDTO(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDTO> userDTOs = users.stream().map(user -> this.usertoUserDTO(user)).collect(Collectors.toList());
		
		return userDTOs;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		this.userRepo.delete(user);
	}

	private User dtoToUser(UserDTO userDTO) {
		
		User user = this.modelMapper.map(userDTO, User.class);
		return user;

	}

	private UserDTO usertoUserDTO(User user) {
		UserDTO userDTO = this.modelMapper.map(user, UserDTO.class);
		return userDTO;
	}

}
