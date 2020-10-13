package servlet.main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/fun1")
public class Fun1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Object> map = new HashMap<>();
        map.put("getRemoteAddr",req.getRemoteAddr());
        map.put("getRemoteHost:",req.getRemoteHost());
        map.put("RemotePort",String.valueOf(req.getRemotePort()));
        map.put("LocalAddr",req.getLocalAddr());
        map.put("LocalHome",req.getLocalName());
        map.put("LocalPort",String.valueOf(req.getLocalPort()));
        map.put("ServerName",req.getServerName());
        map.put("ServerPort",String.valueOf(req.getServerPort()));
        map.put("Scheme",req.getScheme());
        map.put("RequestUrl",req.getRequestURL());
        map.put("ContextPath",req.getContextPath());

        for (Map.Entry<String,Object> i: map.entrySet()) {
            System.out.println(i.getKey()+":"+ i.getValue());
        }
        req.setAttribute("connInfo",map);
        req.getRequestDispatcher("/main/mainFunc/main1-result.jsp").forward(req,resp);
    }
}
