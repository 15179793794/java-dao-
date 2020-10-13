<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 吴仁杨
  Date: 2020/9/26
  Time: 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()
            +"/";
%>
<base href=<%=basePath%>>
<html>
<head>
    <title>显示连接信息</title>
    <c:if test="${empty sessionScope.name}">
        <%
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        %>>
    </c:if>
</head>
<body>
<a href="fun1"><button align="center">点击获取</button></a>
</body>
</html>
