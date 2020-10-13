package servlet.main;

import domain.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class JDBCLogIn extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //获得用户名与密码
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String coString = req.getHeader("REFERER");
        System.out.println(coString);
        if ("".equals(name) || "".equals(password)) {
            session.removeAttribute("msg");
            session.setAttribute("msg", "请输入用户名或密码");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        UserService service = new UserService();
        try {
            if (service.logIn(new User(name,password))) {
                session.setAttribute("name",name);
                req.getRequestDispatcher("/main/main.jsp").forward(req,resp);
            } else {
                session.removeAttribute("msg");
                session.setAttribute("msg", "用户名或密码错误");
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
