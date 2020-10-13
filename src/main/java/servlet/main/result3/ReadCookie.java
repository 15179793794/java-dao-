package servlet.main.result3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/read_cookies")
public class ReadCookie extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        PrintWriter out = resp.getWriter();
        if (cookies == null) {
            out.println("Cookie not found!");
        } else {
            out.println("Number of cookie is "+cookies.length);
            for (Cookie a: cookies) {
                out.println(a.getName()+" = "+a.getValue());
            }
        }
    }
}
