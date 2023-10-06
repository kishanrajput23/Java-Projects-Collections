package pers.hdh.dao;

import pers.hdh.domain.User;

import java.sql.SQLException;

public interface UserDao {

    void add(User user) throws SQLException;

    User getUser(String uid) throws SQLException;

    void update(User user) throws SQLException;
}
