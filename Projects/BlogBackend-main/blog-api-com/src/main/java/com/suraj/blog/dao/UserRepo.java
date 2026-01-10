package com.suraj.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suraj.blog.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
