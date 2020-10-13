<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 吴仁杨
  Date: 2020/9/25
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<base href=<%=basePath%>>
<html>
<head>
    <title>主页</title>
    <%
        String URI = request.getContextPath();
    %>
</head>
<body>
<c:if test="${empty sessionScope.name}">
    <%
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    %>>
</c:if>
<%
    System.out.println("exp-main.jsp");
%>
<h3 text-align="center">
    Welcome! ${sessionScope.name}

</h3>
<a href="main/mainFunc/main1.jsp"><button>获取连接信息</button></a>
<a href="main/mainFunc/main2.jsp"><button>计算器</button></a>
<a href="main/mainFunc/main3.jsp"><button>cookie操作</button></a>
</body>
</html>
