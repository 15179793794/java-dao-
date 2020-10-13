package servlet.main;

import domain.User;
import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class JDBCRegister extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //获得用户名与密码
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String verifyPassword  =req.getParameter("verifyPassword");
        String verifyCode = req.getParameter("verifyCode");

        //判断用户名与密码、验证码
        //1，用户名或者密码是否为空  2，验证码是否正确 3，两次密码是否一致
        if ("".equals(name) || "".equals(password)) {
            session.setAttribute("msg","请输入用户名或密码");
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
            return;
        } else if (!verifyCode.equalsIgnoreCase((String)session.getAttribute("RANDOMREDISKEY"))) {
            session.setAttribute("msg","验证码输入有误，请重新输入");
            System.out.println(verifyCode);
            System.out.println((String)session.getAttribute("RANDOMREDISKEY"));
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
            return;
        } else {
            if (!password.equals(verifyPassword)) {
                session.setAttribute("msg","两次输入的密码不一致");
                resp.sendRedirect(req.getContextPath()+"/index.jsp");
                return;
            }
        }

        //进行注册
        UserService service = new UserService();
        try {
            service.register(new User(name,password));
            session.setAttribute("name",name);
            req.getRequestDispatcher("/main/main.jsp").forward(req,resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            session.removeAttribute("msg");
            session.setAttribute("msg","注册失败，用户已存在");
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }
    }
}
