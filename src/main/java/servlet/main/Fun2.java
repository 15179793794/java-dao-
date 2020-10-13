package servlet.main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/operation.do")
public class Fun2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String A = (String)req.getParameter("addend_a");
        String B = (String)req.getParameter("addend_b");
        if ("".equals(A) || "".equals(B)) {
            req.setAttribute("errMsg","请输入数字！");
            req.getRequestDispatcher("/main/mainFunc/main2-result.jsp").forward(req,resp);
            return;
        }

        Double a = Double.parseDouble(A);
        Double  b = Double.parseDouble(B);
        String o =  req.getParameter("operation");

        if("+".equals(o)) {
            req.setAttribute("sum",String.format("%.2f",a+b));
        } else if ("-".equals(o)) {
            req.setAttribute("sum",String.format("%.2f",a-b));
        } else if ("*".equals(o)) {
            req.setAttribute("sum",String.format("%.2f",a*b));
        } else {
            req.setAttribute("sum",String.format("%.2f",a/b));
        }
        req.getRequestDispatcher("/main/mainFunc/main2-result.jsp").forward(req,resp);
    }
}
