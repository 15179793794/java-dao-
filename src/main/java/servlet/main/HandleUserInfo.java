package servlet.main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/handle-1")
//初步处理与转发用户信息
public class HandleUserInfo extends HttpServlet {
    @Override
    //若页面不携带完全的参数调用下方法，则发生服务器错误
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String> map = new HashMap<>();
        map.put("admin","123");
        map.put("wry","456");

        HttpSession session = req.getSession();
        //获得用户名与密码
        String name = req.getParameter("name");
        String coString = req.getHeader("REFERER");
        if ("".equals(coString)||coString==null) {
            session.removeAttribute("msg");
            session.setAttribute("msg","请输入用户名或密码");
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
            return;
        }
        String password = req.getParameter("password");
        //用户传过来的验证码
        String verifyCode = req.getParameter("verifyCode");
        System.out.println(verifyCode);
        //获得是否存储cookie信息
        String isStoreCookie = req.getParameter("isStoreCookie");
        System.out.println((String)session.getAttribute("RANDOMREDISKEY"));
        if (!verifyCode.equalsIgnoreCase((String)session.getAttribute("RANDOMREDISKEY"))) {
            session.removeAttribute("msg");
            session.setAttribute("msg","验证码错误");
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
            return;
        }

        //进行查找
        for (String s:map.keySet()) { //一个在判断完所有东西之后才返回index.jsp
            //存在该用户
            if (s.equals(name) && map.get(s).equals(password)) {
                //存储信息在cookie
                if (isStoreCookie=="on") {
                    String userInfo = name+"%"+password;
                    Cookie cookie=new Cookie("userInfo",userInfo);
                    cookie.setMaxAge(3*24*60*60);
                    cookie.setDomain("localhost");
                    resp.addCookie(cookie);
                } else {
                    String userInfo = "";
                    Cookie cookie=new Cookie("userInfo",userInfo);
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
                //记录cookie成功后进入主页
                session.setAttribute("name",name);
                req.getRequestDispatcher("/main/main.jsp").forward(req,resp);

                return;
            }
        }
        session.removeAttribute("msg");
        session.setAttribute("msg","用户名或密码错误");
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }
}
