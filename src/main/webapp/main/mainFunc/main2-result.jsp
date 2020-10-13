<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 吴仁杨
  Date: 2020/9/26
  Time: 15:32
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
    <title>计算结果</title>
    <c:if test="${empty sessionScope.name}">
        <%
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        %>>
    </c:if>
</head>
<body>
<c:if test="${!empty requestScope.errMsg}">
    <c:out value="${requestScope.errMsg}"> </c:out>
</c:if>
<c:if test="${empty requestScope.errMsg}">
    <h2 text-align="center">计算结果是: ${requestScope.sum}</h2>
</c:if>

</body>
</html>
