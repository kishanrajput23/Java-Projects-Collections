package pers.hdh.service.impl;

import pers.hdh.dao.UserDao;
import pers.hdh.dao.impl.UserDaoImpl;
import pers.hdh.domain.User;
import pers.hdh.service.UserService;
import pers.hdh.utils.MailUtils;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    /**
     * 添加用户
     * @param user
     */
    @Override
    public void add(User user) throws Exception {
        // 添加新用户
        UserDao dao = new UserDaoImpl();
        dao.add(user);

        // 发送邮件
        MailUtils.sendMail(user.getEmail(), user.getUid());
    }

    /**
     * 通过id查找用户
     * @param uid
     * @return
     */
    @Override
    public User getUser(String uid) throws SQLException {
        UserDao dao = new UserDaoImpl();
        return dao.getUser(uid);
    }

    /**
     * 更新用户数据
     * @param user
     */
    @Override
    public void update(User user) throws SQLException {
        UserDao dao = new UserDaoImpl();
        dao.update(user);
    }
}
