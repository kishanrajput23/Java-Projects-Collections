package pers.hdh.servlet;

import pers.hdh.domain.User;
import pers.hdh.service.UserService;
import pers.hdh.service.impl.UserServiceImpl;
import pers.hdh.utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户注册的servlet
 */
public class RegistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理中文乱码
        req.setCharacterEncoding("utf-8");

        // 接收数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        // 封装数据
        User user = new User();
        user.setUid(UUIDUtils.getId());
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setState(0);

        // 调用业务处理数据
        UserService service = new UserServiceImpl();
        try {
            service.add(user);
            resp.sendRedirect(req.getContextPath()+"/message.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
