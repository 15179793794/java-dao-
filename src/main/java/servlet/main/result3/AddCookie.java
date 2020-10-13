package servlet.main.result3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_cookies")
public class AddCookie extends HttpServlet {
    private static int cookieC;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "MyCookie" + (++cookieC);
        String value = String.valueOf(System.currentTimeMillis());
        Cookie cookie = new Cookie(name,value);
        cookie.setMaxAge(24*60*60);
        cookie.setDomain("localhost");
        resp.addCookie(cookie);
        resp.getWriter().println("A cookie has been created successfully!");
    }
}
