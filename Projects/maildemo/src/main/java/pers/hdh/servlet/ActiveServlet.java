package pers.hdh.servlet;

import pers.hdh.domain.User;
import pers.hdh.service.UserService;
import pers.hdh.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 激活用户
 */
public class ActiveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");

        // 调用业务处理数据
        UserService service = new UserServiceImpl();
        // 先查询到user
        User user = null;
        try {
            user = service.getUser(uid);
            if (user != null) {
                user.setState(1);
                service.update(user);
                resp.sendRedirect(req.getContextPath()+"/success.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath()+"/error.jsp");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
