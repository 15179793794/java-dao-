package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/fun1","/fun2","/fun3","/handle","/operation.do","/add_cookies","/read_cookies","/delete_cookies","/verifyCode.do"})
public class ServletFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String coString = req.getHeader("REFERER");
        if ("".equals(coString)||coString==null) {
            session.removeAttribute("msg");
            session.setAttribute("msg","请输入用户名或密码");
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
            return;
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
