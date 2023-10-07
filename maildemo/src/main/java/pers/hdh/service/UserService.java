package pers.hdh.service;

import pers.hdh.domain.User;

import java.sql.SQLException;

public interface UserService {
    void add(User user) throws Exception;

    User getUser(String uid) throws SQLException;

    void update(User user) throws SQLException;
}
