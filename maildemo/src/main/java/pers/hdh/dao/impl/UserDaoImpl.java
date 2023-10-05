package pers.hdh.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import pers.hdh.dao.UserDao;
import pers.hdh.domain.User;
import pers.hdh.utils.DataSourceUtils;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    /**
     * 往user表插入数据，添加新用户
     * @param user
     * @throws SQLException
     */
    @Override
    public void add(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user values (?,?,?,?,?)";
        qr.update(sql, user.getUid(), user.getUsername(), user.getPassword(), user.getEmail(), user.getState());
    }

    /**
     * 通过uid查询user表
     * @param uid
     * @return
     */
    @Override
    public User getUser(String uid) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select uid, username, password, email, state from user where uid=?";
        return qr.query(sql, new BeanHandler<User>(User.class), uid);
    }

    @Override
    public void update(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update user set username=?, password=?, email=?, state=? where uid=?";
        qr.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getState(), user.getUid());
    }
}
