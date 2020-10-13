package service;

import DAO.MyDAO;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UserService {
    //用户登录

    /**
     * 进行登录操作，登录成功返回true，否则返回false，但无法对用户是否注册国不进行处理
     * @param user
     * @return
     */
    public boolean logIn(User user) throws SQLException {
        MyDAO myDAO = new MyDAO();
        if (myDAO.verifyUser(user.getName(),user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    //注册用户,注册失败时抛出异常，表示用户名已存在（那用户名非法呢，除了在servlet拦截还可以在哪里）
    public void register(User user) throws SQLException {
        MyDAO myDAO = new MyDAO();
        myDAO.insertUser(user.getName(),user.getPassword());

    }
}
