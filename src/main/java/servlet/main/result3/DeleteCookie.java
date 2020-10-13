package servlet.main.result3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete_cookies")
public class DeleteCookie extends HttpServlet {
    public static int count;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out  = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            out.println("No nookie found!");
        } else {
            for (Cookie a: cookies) {
                if (a.getName().equals("MyCookie"+(++count))) {
                    a.setMaxAge(0);
                    resp.addCookie(a);
                }
            }
            out.println("Your cookies which were created in this website have been deleted!");
        }
    }
}
